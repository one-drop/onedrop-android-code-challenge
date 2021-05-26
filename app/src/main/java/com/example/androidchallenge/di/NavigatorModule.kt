package com.example.androidchallenge.di

import com.example.androidchallenge.Navigator
import com.example.androidchallenge.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigatorModule {

    @[Binds Singleton]
    abstract fun bindNavigator(impl: NavigatorImpl): Navigator
}