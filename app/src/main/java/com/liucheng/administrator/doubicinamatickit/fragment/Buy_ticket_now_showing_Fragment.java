package com.liucheng.administrator.doubicinamatickit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.liucheng.administrator.doubicinamatickit.R;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class Buy_ticket_now_showing_Fragment extends BaseFragment{


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_now_showing_fragment,container,false);
        return contentView ;
    }

    @Override
    public void initialUI() {

    }
}
