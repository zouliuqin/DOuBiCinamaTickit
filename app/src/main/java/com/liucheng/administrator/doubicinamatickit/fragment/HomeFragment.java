package com.liucheng.administrator.doubicinamatickit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.view.ImageText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/10/15 0015.
 */

public class HomeFragment extends BaseFragment {


    Unbinder unbinder;
    @BindView(R.id.imageviewText)
    ImageText imageviewText;
    @BindView(R.id.text_actionbar)
    TextView textActionbar;
    @BindView(R.id.imageView_actionbar)
    ImageView imageViewActionbar;
    @BindView(R.id.cinema_line_1)
    TextView cinemaLine1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(R.layout.home_fragment, container, false);
        initialUI();
        unbinder = ButterKnife.bind(this, contentView);
        return contentView;
    }

    @Override
    public void initialUI() {
        actionBar = contentView.findViewById(R.id.include_actionbar_home);
        initiaActionBar(R.drawable.go, "武汉", "某票", -1);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



}
