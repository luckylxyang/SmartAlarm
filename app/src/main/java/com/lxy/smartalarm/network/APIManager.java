package com.lxy.smartalarm.network;

import com.lxy.smartalarm.base.Constants;
import com.lxy.smartalarm.weather.net.WeatherServer;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lxy on 2018/7/25.
 */

public class APIManager {

    private static APIManager manager;

    private WeatherServer weatherServer;

    private APIManager(){

    }

    public static APIManager getManager(){
        if (manager == null){
            synchronized (APIManager.class){
                if (manager == null){
                    manager = new APIManager();
                }
            }
        }
        return manager;
    }

    public WeatherServer getWeatherServer(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        if (weatherServer == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.WEATHER_URL)
                    // 与Okhttp关联
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            weatherServer = retrofit.create(WeatherServer.class);
        }
        return weatherServer;
    }


}
