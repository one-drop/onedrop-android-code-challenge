package com.example.androidchallenge.network.models

// TEMP split these into separate files
// TEMP add jackson annotations to all of these properties
// TEMP rename to WeatherForecast
data class WeatherData(
    val lat: Double, // TEMP use value classes
    val lon: Double, // TEMP use value classes
    val timezone: String, // TEMP stronger data type
    val current: CurrentWeather
)

data class CurrentWeather(
    val dt: Long, // TEMP better name + stronger data type
    val sunrise: Long, // TEMP this should be a time data type
    val sunset: Long, // TEMP this should be a time data type
    val temp: Double, // TEMP make a Temperature data type that includes unit information
    val feelsLike: Double, // TEMP feelsLikeTemperature - use above temperature data type
    val pressure: Int, // TEMP pressure data type that includes unit information
    val humidity: Int, // TEMP humidity data type that includes unit information
    val weather: List<Weather> // TEMP not exactly sure what this is, but we could name it better
)

data class Weather(
    val id: Int, // TEMP value class?
    val main: String, // TEMP not sure what this is, but name it better and use an enum
    val description: String,
    val icon: String // TEMP might want a class or enum for this
)


// TEMP move this to a example_forecast_response.json file
/*
{
    "lat": 40.12,
    "lon": -96.66,
    "timezone": "America/Chicago",
    "timezone_offset": -18000,
    "current": {
    "dt": 1595243443,
    "sunrise": 1595243663,
    "sunset": 1595296278,
    "temp": 293.28,
    "feels_like": 293.82,
    "pressure": 1016,
    "humidity": 100,
    "dew_point": 293.28,
    "uvi": 10.64,
    "clouds": 90,
    "visibility": 10000,
    "wind_speed": 4.6,
    "wind_deg": 310,
    "weather": [
    {
        "id": 501,
        "main": "Rain",
        "description": "moderate rain",
        "icon": "10n"
    },
    {
        "id": 201,
        "main": "Thunderstorm",
        "description": "thunderstorm with rain",
        "icon": "11n"
    }
    ],
    "rain": {
        "1h": 2.93
    }
},
    }*/
