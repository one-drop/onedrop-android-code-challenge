package com.example.androidchallenge.weather

import com.example.androidchallenge.BasePresenter
import com.example.androidchallenge.BaseView
import com.example.androidchallenge.models.Coords
import com.example.androidchallenge.models.Weather
import com.example.androidchallenge.models.WeatherData

interface WeatherContract {
    interface WeatherPresenter : BasePresenter {
        fun onViewCreated(view: View)
        fun onLoadWeather(loadType: LoadType): Any
        fun onViewForecastForCurrentRequested()
    }

    interface View : BaseView<WeatherPresenter> {
        fun onWeatherDataFound(data: WeatherData)
        fun onViewForecastForCurrentRequested(data: WeatherData)
    }
}

sealed class LoadType {
    object NewYork : LoadType()
    data class CurrentLocation(val coords: Coords) : LoadType()
}