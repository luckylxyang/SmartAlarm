package com.lxy.smartalarm.weather.net;

import com.lxy.smartalarm.weather.bean.Weather;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by lxy on 2018/7/24.
 */

public interface WeatherServer {

    /**
     * https://search.heweather.com/find?parameters
     * @param cityName
     * @return
     */
    @HTTP(method = "GET" ,path = "https://search.heweather.com/find?")
    public Observable<Weather> getCity(
            @Query("location") String cityName,
            @Query("key") String key);
}
