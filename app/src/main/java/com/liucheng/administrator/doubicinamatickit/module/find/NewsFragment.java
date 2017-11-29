package com.liucheng.administrator.doubicinamatickit.module.find;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.liucheng.administrator.doubicinamatickit.R;
import com.liucheng.administrator.doubicinamatickit.entity.MovieNews;
import com.liucheng.administrator.doubicinamatickit.module.find.adapter.NewsAdapter;
import com.liucheng.administrator.doubicinamatickit.module.find.data.NewsData;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoaderInterface;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class NewsFragment extends Fragment implements NewsData.NewsLoadListener {


    @BindView(R.id.banner)
    Banner bvBanner;

    Unbinder unbinder;
    @BindView(R.id.lv_news)
    ListView lvNews;
    /**
     * 新闻资讯数据
     */
    private List<MovieNews.NewsListBean> newsLists=new ArrayList<>();

    /**
     * 新闻资讯adapter
     */
    private NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        //获取新闻资讯数据
        NewsData.getNewsData(this);
       // initUi();
        return view;
    }


    private void initUi() {


        //设置图片加载器
        bvBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
       // bvBanner.setImages();
        //banner设置方法全部调用完毕时最后调用
        bvBanner.start();


    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        bvBanner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        bvBanner.stopAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 接口回调显示电影资讯数据
     *
     * @param movieNews 电影资讯
     */
    @Override
    public void onWeathersLoadEnd(MovieNews movieNews) {
        //获取新闻资讯数组

        newsLists = movieNews.getNewsList();

        Log.i("ATG", "onWeathersLoadEnd: " + newsLists.get(0));
//        adapter = new NewsAdapter(getActivity(), newsLists);
//        lvNews.setAdapter(adapter);


    }

    private class GlideImageLoader implements ImageLoaderInterface {
        @Override
        public void displayImage(Context context, Object path, View imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */

            //
            //            //Glide 加载图片简单用法
            //            Glide.with(context).load(path).into(imageView);

            //Picasso 加载图片简单用法
            // Picasso.with(context).load(path.toString()).into(imageView);
            //
            //            //用fresco加载图片简单用法，记得要写下面的createImageView方法
            //            Uri uri = Uri.parse((String) path);
            //            imageView.setImageURI(uri);
        }

        @Override
        public View createImageView(Context context) {
            return null;
        }
    }
}
