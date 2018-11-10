package com.lxy.smartalarm.weather.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lxy.smartalarm.R;
import com.lxy.smartalarm.base.BaseAdapter;
import com.lxy.smartalarm.base.ViewHolder;
import com.lxy.smartalarm.network.APIManager;
import com.lxy.smartalarm.weather.bean.DailyForecast;
import com.lxy.smartalarm.weather.bean.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.heweather.com.interfacesmodule.bean.weather.forecast.Forecast;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lxy on 2018/9/9.
 */

public class WeatherFragment extends Fragment {

    private RecyclerView rvWeather;
    private TextView tvForecast;
    private WeatherAdapter weatherAdapter;
    private List<DailyForecast> weatherList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_weather,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initWeatherData();
    }

    private void initView(View view) {
        rvWeather = view.findViewById(R.id.weather_frag_rv_forecast);
        rvWeather.setLayoutManager(new LinearLayoutManager(getContext()));
        weatherAdapter = new WeatherAdapter(getContext(),weatherList,R.layout.item_weather_forecast);
        DividerItemDecoration decoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);

        rvWeather.addItemDecoration(decoration);
        rvWeather.setAdapter(weatherAdapter);
        tvForecast = view.findViewById(R.id.weather_frag_weather_15_forecast);

    }

    private void initWeatherData(){
        APIManager.getManager().getWeatherServer().getWeatherForecast("chongqing","12693de64b2e406c91d98d98333cd89e")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Weather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Weather weather) {
                        weatherList.clear();
                        weatherList.addAll(weather.getHeWeather6().get(0).getDaily_forecast());
                        Log.i("weather",weather.getHeWeather6().get(0).getStatus());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        weatherAdapter.notifyDataSetChanged();
                    }
                });
    }

    class WeatherAdapter extends BaseAdapter<DailyForecast>{

        public WeatherAdapter(Context context, List<DailyForecast> list, int layoutId) {
            super(context, list, layoutId);
        }

        @Override
        protected void convert(ViewHolder holder, DailyForecast bean, int position) {
            holder.setText(R.id.item_weather_date,bean.getDate());
            holder.setText(R.id.item_weather_desc,bean.getCond_txt_d());
            holder.setText(R.id.item_weather_num,bean.getTmp_max() + "/" + bean.getTmp_min() + "℃");
        }
    }
}
