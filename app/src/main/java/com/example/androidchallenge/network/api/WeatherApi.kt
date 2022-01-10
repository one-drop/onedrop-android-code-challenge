package com.example.androidchallenge.network.api

import com.example.androidchallenge.network.models.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val key = "insert_your_key_here"

interface WeatherApi {

    @GET("data/2.5/onecall?appid=$key&exclude=alerts,minutely&units=imperial")
    fun getWeatherForecast(
        @Query("lat") lat: String,
        @Query("lon") lon: String
    ): Call<WeatherData>
}