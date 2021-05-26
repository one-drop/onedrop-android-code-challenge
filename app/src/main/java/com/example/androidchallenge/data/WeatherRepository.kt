package com.example.androidchallenge.data

import com.example.androidchallenge.models.Result
import com.example.androidchallenge.models.WeatherData

interface WeatherRepository {
    suspend fun loadWeatherForNewYork(): Result<WeatherData?>
    suspend fun loadWeather(lat: String, long: String): Result<WeatherData?>
}