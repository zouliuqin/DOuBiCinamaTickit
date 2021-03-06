package com.liucheng.administrator.doubicinamatickit.ui;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.liucheng.administrator.doubicinamatickit.adapter.MyFragmentAdapter;
import com.liucheng.administrator.doubicinamatickit.fragment.BuyTicketFragment;
import com.liucheng.administrator.doubicinamatickit.fragment.CinemaFragment;
import com.liucheng.administrator.doubicinamatickit.module.find.FindFragment;
import com.liucheng.administrator.doubicinamatickit.fragment.HomeFragment;
import com.liucheng.administrator.doubicinamatickit.module.myself.MyFragment;
import com.liucheng.administrator.doubicinamatickit.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialUI();
        SetListener();
    }

    //声明控件
    ViewPager viewPager_main = null;
    RadioGroup radioGroup_bottom = null;
    MyFragmentAdapter adapter = null;
    BuyTicketFragment buyTicketFragment;
    CinemaFragment cinemaFragment;
    FindFragment findFragment;
    HomeFragment homeFragment;
    MyFragment myFragment;


    private void initialUI() {
        //初始化控件
        viewPager_main = findViewById(R.id.mainactivity_viewPager);
        radioGroup_bottom = findViewById(R.id.include_ridiogroup_bottom);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        //初始化Fragment
        buyTicketFragment = new BuyTicketFragment();
        cinemaFragment = new CinemaFragment();
        findFragment = new FindFragment();
        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        //向适配器集合中添加Fragment
        adapter.addFragment(homeFragment);
        adapter.addFragment(buyTicketFragment);
        adapter.addFragment(cinemaFragment);
        adapter.addFragment(findFragment);
        adapter.addFragment(myFragment);
        //将adpter与ViewPager进行关联
        viewPager_main.setAdapter(adapter);


    }

    private void SetListener() {
        //将viewPager_main2与radioGroup_Button进行关联
        viewPager_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup_bottom.check(R.id.radioButton_home);
                        break;
                    case 1:
                        radioGroup_bottom.check(R.id.radioButton_buy_ticket);
                        break;
                    case 2:
                        radioGroup_bottom.check(R.id.radioButton_cinema);
                        break;
                    case 3:
                        radioGroup_bottom.check(R.id.radioButton_find);
                        break;
                    case 4:
                        radioGroup_bottom.check(R.id.radioButton_my);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioButton_home:
                        viewPager_main.setCurrentItem(0);
                        break;
                    case R.id.radioButton_buy_ticket:
                        viewPager_main.setCurrentItem(1);
                        break;
                    case R.id.radioButton_cinema:
                        viewPager_main.setCurrentItem(2);
                        break;
                    case R.id.radioButton_find:
                        viewPager_main.setCurrentItem(3);
                        break;
                    case R.id.radioButton_my:
                        viewPager_main.setCurrentItem(4);
                        break;
                }
            }
        });


    }


}
