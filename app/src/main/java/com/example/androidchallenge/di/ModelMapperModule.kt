package com.example.androidchallenge.di

import com.example.androidchallenge.mapper.WireWeatherDataMapper
import com.example.androidchallenge.mapper.ModelMapper
import com.example.androidchallenge.models.WeatherData
import com.example.androidchallenge.data.network.models.WireWeatherData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ModelMapperModule {

    @Provides
    fun bindWireWeatherDataMapper(impl: WireWeatherDataMapper): ModelMapper<WireWeatherData?, WeatherData?> =
        impl

}