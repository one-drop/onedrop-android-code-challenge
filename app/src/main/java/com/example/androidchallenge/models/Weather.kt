package com.example.androidchallenge.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(val timezone: String, val coords: Coords) : Parcelable

@Parcelize
data class Coords(val latitude: Double, val longitude: Double) : Parcelable

@Parcelize
data class Weather(
    val location: Location,
    val temp: Double,
    val humidity: Int,
    val feelsLike: Double,
    val windSpeed: Double,
    val windDegrees: Int,
    val pressure: Int
) : Parcelable {

    fun forecastString() : String {
        return "Temperature: $temp\nHumidity: $humidity\nFeels like: $feelsLike\nWind Speed and degress: $windSpeed|$windDegrees\nPressure:$pressure"

    }

    override fun toString(): String {
        return "Location: ${location.timezone}\nTemperature: $temp\nHumidity: $humidity\nFeels like: $feelsLike\nWind Speed and degress: $windSpeed|$windDegrees\nPressure:$pressure"
    }
}

@Parcelize
data class WeatherData(
    val currentWeather: Weather,
    val forecast: List<Weather>
) : Parcelable

/**
Location (i.e. New York, etc)
Temperature
Humidity
Feels like
Wind speed/degrees
Pressure
 */