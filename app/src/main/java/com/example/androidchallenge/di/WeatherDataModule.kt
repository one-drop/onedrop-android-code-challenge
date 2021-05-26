package com.example.androidchallenge.di

import com.example.androidchallenge.data.WeatherRepository
import com.example.androidchallenge.data.WeatherRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherDataModule {

    @[Binds Singleton]
    abstract fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository
}