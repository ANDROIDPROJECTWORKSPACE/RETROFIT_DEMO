package com.example.phearun.retrofitdemo;

import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Phearun on 1/6/2017.
 */

public interface FeedService {

    @GET("/api/v1/feed")
    Call<List<Feed>> findAllFeeds();

    @POST("/api/v1/feed")
    Call<ResponseBody> save(@Body Feed feed);

}
