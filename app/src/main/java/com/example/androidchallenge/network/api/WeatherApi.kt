package com.example.androidchallenge.network.api

import com.example.androidchallenge.network.models.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

private const val key = "59ac41458256ef1fc2ebfddda1ded2da"

// TEMP move to network package
interface WeatherApi {

    @GET("data/2.5/onecall?appid=$key&exclude=alerts,minutely&units=imperial")
    fun getWeatherForecast(
        @Query("lat") lat: String, // TEMP these should be doubles - or maybe use inline classes?
        @Query("lon") lon: String
    ): Call<WeatherData>
}
