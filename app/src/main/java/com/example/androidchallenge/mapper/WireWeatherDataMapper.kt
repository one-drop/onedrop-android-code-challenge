package com.example.androidchallenge.mapper

import com.example.androidchallenge.models.Coords
import com.example.androidchallenge.models.Location
import com.example.androidchallenge.models.Weather
import com.example.androidchallenge.models.WeatherData
import com.example.androidchallenge.data.network.models.WireWeatherData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WireWeatherDataMapper @Inject constructor() : ModelMapper<WireWeatherData?, WeatherData?> {
    override fun map(inType: WireWeatherData?): WeatherData? = inType?.let {
        WeatherData(
            currentWeather = Weather(
                location = Location(it.timezone, Coords(it.lat, it.lon)),
                temp = it.current.temp,
                humidity = it.current.humidity,
                feelsLike = it.current.feelsLike,
                windSpeed = it.current.wind_speed,
                windDegrees = it.current.wind_deg,
                pressure = it.current.pressure
            ),
            forecast = it.daily.map { forecast ->
                Weather(
                    location = Location(it.timezone, Coords(it.lat, it.lon)),
                    temp = 0.0, //just for now, we can use open/close principles to provide more flexibility later
                    humidity = forecast.humidity,
                    feelsLike = forecast.feelsLike,
                    windSpeed = forecast.wind_speed,
                    windDegrees = forecast.wind_deg,
                    pressure = forecast.pressure
                )
            }
        )
    }
}