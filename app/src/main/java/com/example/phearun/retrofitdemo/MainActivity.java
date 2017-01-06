package com.example.phearun.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    FeedService feedService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tvView);

        feedService = ServiceGenerator.createService(FeedService.class);
    }

    public void findAllFeed(View view){
        Toast.makeText(MainActivity.this, "Requesting...", Toast.LENGTH_SHORT).show();

        Call<List<Feed>> call = feedService.findAllFeeds();

        call.enqueue(new Callback<List<Feed>>() {
            @Override
            public void onResponse(Call<List<Feed>> call, Response<List<Feed>> response) {
                if(response.isSuccessful()){
                    Log.d("RETROFIT DATA", response.body() + "");
                    textView.setText(response.body() + "");
                }else{
                    Log.d("RETROFIT FAIL", response + "");
                }
            }

            @Override
            public void onFailure(Call<List<Feed>> call, Throwable t) {
                Log.d("RETROFIT ERROR", t.getMessage());
            }
        });

    }

    public void saveFeed(View view){

        Call<ResponseBody> call = feedService.save(new Feed());

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Log.d("RETROFIT DATA", response.body() + "");
                    try {
                        textView.setText(response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.d("RETROFIT ERROR", response + "");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("RETROFIT FAILED", t.getMessage());
            }
        });

    }

}
