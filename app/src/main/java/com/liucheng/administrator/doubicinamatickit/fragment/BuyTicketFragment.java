package com.liucheng.administrator.doubicinamatickit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.liucheng.administrator.doubicinamatickit.adapter.MyFragmentAdapter;
import com.liucheng.administrator.doubicinamatickit.R;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class BuyTicketFragment extends BaseFragment {
    //actionbar




    //声明控件
    RadioGroup radioGroup = null;
    ViewPager viewPager = null;
    Buy_ticket_upcoming_movies_Fragment upcoming_movies_fragment;
    Buy_ticket_now_showing_Fragment now_showing_fragment;
    MyFragmentAdapter adapter;


    public BuyTicketFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.buy_ticket_fragment, container, false);
        initialUI();
        Listener();


        return contentView;
    }

    private void Listener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton_lefet:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radioButton_right:
                        viewPager.setCurrentItem(0);
                        break;

                }
            }
        });



    }


    @Override
    public void initialUI() {
        //初始化控件
        viewPager = contentView.findViewById(R.id.framentlayout_BuyTicket_viewpager);
        Log.d("TTTTgetActivity()", getActivity().toString());
        actionBar = contentView.findViewById(R.id.include_actionbar_buy_ticket);
        initiaActionBar(R.drawable.go,"武汉","电影票",-1);



        radioGroup = contentView.findViewById(R.id.radioGroup_byu_ticket);
        upcoming_movies_fragment = new Buy_ticket_upcoming_movies_Fragment();
        now_showing_fragment = new Buy_ticket_now_showing_Fragment();
        adapter = new MyFragmentAdapter(getChildFragmentManager());
        adapter.addFragment(now_showing_fragment);
        adapter.addFragment(upcoming_movies_fragment);

        viewPager.setAdapter(adapter);


    }
}
