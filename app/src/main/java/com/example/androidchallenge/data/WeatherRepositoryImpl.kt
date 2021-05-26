package com.example.androidchallenge.data

import com.example.androidchallenge.mapper.ModelMapper
import com.example.androidchallenge.models.Result
import com.example.androidchallenge.models.WeatherData
import com.example.androidchallenge.data.network.api.WeatherApi
import com.example.androidchallenge.data.network.models.WireWeatherData
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val wireWeatherDataMapper: ModelMapper<WireWeatherData?, WeatherData?>
) : WeatherRepository {
    override suspend fun loadWeatherForNewYork(): Result<WeatherData?> =
        loadWeather(lat = "40.712776", long = "-74.005974")


    override suspend fun loadWeather(lat: String, long: String): Result<WeatherData?> = try {
        val response = weatherApi.getWeatherForecast(lat, long)
        val weatherData = wireWeatherDataMapper.map(response.body())

        Result.Success(weatherData)
    } catch (e: Exception) {
        Result.Error(Throwable(e)) //or en-rich further
    }
}