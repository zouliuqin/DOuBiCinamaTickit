package com.liucheng.administrator.doubicinamatickit.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.view.ImageText;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public abstract class BaseFragment extends Fragment{
    protected View contentView;
    protected RelativeLayout actionBar;

    public abstract void initialUI();

    protected void initiaActionBar(int lefetId,String text,String title,int rightId){
    if (actionBar == null){
        return;
    }
    //初始化控件
        ImageText imageText = contentView.findViewById(R.id.imageviewText);
        TextView textView = contentView.findViewById(R.id.textview_view_image_with_text);
        ImageView imageView = contentView.findViewById(R.id.imageview_view_image_with_text);

        TextView textView_title = contentView.findViewById(R.id.text_actionbar);
        ImageView imageButton_right = contentView.findViewById(R.id.imageView_actionbar);
        //控件的显示及控制条件
        if (lefetId<=0){
           //隐藏控件
            imageText.setVisibility(View.INVISIBLE);
        }else {
            imageText.setVisibility(View.VISIBLE);
           imageView.setImageResource(lefetId);
           textView.setText(text);

        }
        if (TextUtils.isEmpty(title)){
            //隐藏控件
            textView_title.setVisibility(View.INVISIBLE);
        }else {
            textView_title.setVisibility(View.VISIBLE);
            textView_title.setText(title);
        }
        if (rightId<=0){
            //隐藏控件
            imageButton_right.setVisibility(View.INVISIBLE);
        }else {
            imageButton_right.setVisibility(View.VISIBLE);
            imageButton_right.setImageResource(rightId);
        }



    }




}
