package com.liucheng.administrator.doubicinamatickit.ui;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.IsHit;
import com.liucheng.administrator.doubicinamatickit.manager.IsHitData;
import com.liucheng.administrator.doubicinamatickit.sql.MyDataBaseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.b.This;

public class SplashActivity extends Activity implements IsHitData.IsHitLoadListener {
    private ViewFlipper viewFlipper;
    private Button button;

    //正在热映
    List<IsHit.MsBean> ms = new ArrayList<>();
    //偏好设置数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initialUI();

        //初始化Bmob
        //初始化自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        BmobConfig config = new BmobConfig.Builder(this)
                ////设置appkey
                .setApplicationId("b05ee63033093ab6510cdefeaf7af167")
                ////请求超时时间（单位为秒）：默认15s
                .setConnectTimeout(30)
                ////文件分片上传时每片的大小（单位字节），默认512*1024
                .setUploadBlockSize(1024 * 1024)
                ////文件的过期时间(单位为秒)：默认1800s
                .setFileExpiration(2500)
                .build();
        Bmob.initialize(config);


        //初始化正在热映电影数据,设置偏好设置保存在本地,用于票房榜查询电影详情
        initIsHit();


    }

    //初始化正在热映电影数据,设置偏好设置保存在本地,用于票房榜查询电影详情
    private void initIsHit() {
        IsHitData.getIIsHitData(this);
    }

    private void initialUI() {
        viewFlipper = findViewById(R.id.splash_viewFlipper);
        //        ImageView imageView = new ImageView(this);
        //        imageView.setImageResource(R.drawable.ic_cinema_selecte2);
        //        ImageView imageView1 = new ImageView(this);
        //        imageView1.setImageResource(R.drawable.ic_find_selecte2);
        //       viewFlipper.addView(imageView);
        //       viewFlipper.addView(imageView1);
        //       viewFlipper.setFlipInterval(1000);
        //       viewFlipper.startFlipping();
        button = findViewById(R.id.button_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }


    @Override
    public void onIsHitLoadEnd(IsHit isHit) {

        ms.addAll(isHit.getMs());
        SQLiteDatabase db= new MyDataBaseHelper(this,"IsHit.db",null,1).getWritableDatabase();
        //先清空数据表，再添加数据
        db.execSQL("delete from IsHit;");
        ContentValues cv = new ContentValues();
        //添加当天正在热映的电影编号和电影名称在数据库，方便后期排行榜调用
        for(int i=0 ; i <ms.size();i++){
            Log.i("TAG", "movieId: "+ms.get(i).getId());
            Log.i("TAG", "movieName: "+ms.get(i).getT());
            cv.put("movieId",ms.get(i).getId());
            cv.put("movieName",ms.get(i).getT());
            db.insert("IsHit", null, cv);
        }

    }
}
