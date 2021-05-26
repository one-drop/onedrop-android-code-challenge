package com.example.androidchallenge

import android.content.Context
import android.content.Intent
import com.example.androidchallenge.forecast.WeatherForecastActivity
import com.example.androidchallenge.models.WeatherData
import javax.inject.Inject

interface Navigator {
    fun toForecastDetails(context: Context, weatherData: WeatherData)
}


class NavigatorImpl @Inject constructor() : Navigator {
    override fun toForecastDetails(context: Context, weatherData: WeatherData) {
        context.startActivity(
            Intent(
                context,
                WeatherForecastActivity::class.java
            ).apply {
                putExtra(
                    WeatherForecastActivity.EXTRA_WEATHER_DATA,
                    weatherData
                )
            }
        )
    }
}
