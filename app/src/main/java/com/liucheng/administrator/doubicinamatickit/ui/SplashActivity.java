package com.liucheng.administrator.doubicinamatickit.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.liucheng.administrator.doubicinamatickit.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import cn.bmob.v3.BmobSMS;

public class SplashActivity extends Activity {
    private ViewFlipper viewFlipper;
    private Button button;

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



    }
    private void initialUI(){
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
               Intent intent = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(intent);
               finish();
           }
       });



    }




}
