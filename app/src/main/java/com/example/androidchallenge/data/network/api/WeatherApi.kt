package com.example.androidchallenge.data.network.api

import com.example.androidchallenge.data.network.models.WireWeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal const val OPEN_WEATHER_MAP_BASE_URL = "https://api.openweathermap.org/"
private const val key = "59ac41458256ef1fc2ebfddda1ded2da"

interface WeatherApi {

    @GET("data/2.5/onecall?appid=$key&exclude=alerts,hourly,minutely&units=imperial")
    suspend fun getWeatherForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Response<WireWeatherData>
}


