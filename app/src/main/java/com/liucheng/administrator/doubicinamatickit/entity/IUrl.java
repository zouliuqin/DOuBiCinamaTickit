package com.liucheng.administrator.doubicinamatickit.entity;

/**
 * Created by Administrator on 2017/10/29 0029.
 */

public interface IUrl {
    String  MOVIES_IS_HIT = "https://api-m.mtime.cn/Showtime/LocationMovies.api?locationId=";

   String MOVIES_ON_NEXT = "https://api-m.mtime.cn/Movie/MovieComingNew.api?locationId=";

   //影片资讯   参数传入1-10
    String MOVIES_NEWS="https://api-m.mtime.cn/News/NewsList.api?pageIndex=";


}
