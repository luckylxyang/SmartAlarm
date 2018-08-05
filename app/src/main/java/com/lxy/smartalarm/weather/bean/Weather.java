package com.lxy.smartalarm.weather.bean;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lxy on 2018/7/24.
 */

public class Weather {
    /**
     * "HeWeather6": [
     {
     "basic": [],
     "status": "ok"
     }
     ]
     */

    public Basic[] basics;
    @SerializedName("daily_forecast")
    public List<DailyForecast> dailyForecasts;

    @SerializedName("hourly")
    public List<DailyForecast> hourly;

    @SerializedName("air_now_city")
    public List<AQI> air_now_citys;

    @SerializedName("air_now_station")
    public List<AQIStation> air_now_stations;
    public Now now;
    public String status;
    public Update update;
    public Lifestyle lifestyle;

    public class Update{
        public String loc;
        public String utc;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "basics=" + Arrays.toString(basics) +
                ", dailyForecasts=" + dailyForecasts +
                ", hourly=" + hourly +
                ", air_now_citys=" + air_now_citys +
                ", air_now_stations=" + air_now_stations +
                ", now=" + now +
                ", status='" + status + '\'' +
                ", update=" + update +
                ", lifestyle=" + lifestyle +
                '}';
    }
}
