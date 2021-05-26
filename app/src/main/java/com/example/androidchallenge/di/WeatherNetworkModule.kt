package com.example.androidchallenge.di

import com.example.androidchallenge.data.network.api.OPEN_WEATHER_MAP_BASE_URL
import com.example.androidchallenge.data.network.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class WeatherNetworkModule {

    @[Provides Singleton]
    fun provideRetrofitInstance(): Retrofit = Retrofit.Builder()
        .baseUrl(OPEN_WEATHER_MAP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Provides Singleton]
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)
}


