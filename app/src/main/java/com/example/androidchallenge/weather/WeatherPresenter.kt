package com.example.androidchallenge.weather

import android.util.Log
import com.example.androidchallenge.ViewState
import com.example.androidchallenge.data.WeatherRepository
import com.example.androidchallenge.models.Result
import com.example.androidchallenge.models.WeatherData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class WeatherPresenter @Inject constructor(
    private val repo: WeatherRepository
) : WeatherContract.WeatherPresenter, CoroutineScope {

    private var view: WeatherContract.View? = null

    private var currentWeatherData: WeatherData? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onDestroy() = try {
        job.cancel()
        view = null
    } catch (e: Exception) {
        Log.e("Presenter.onDestroy", e.toString())
    }

    override fun onViewCreated(view: WeatherContract.View) {
        this.view = view
        Log.d("onViewCreated", "Ready to consume presenter")
    }

    override fun onLoadWeather(loadType: LoadType) = try {
        currentWeatherData = null
        view?.onViewStateChanged(ViewState.Loading)
        launch {
            val weatherData = when (loadType) {
                is LoadType.NewYork -> repo.loadWeatherForNewYork()
                is LoadType.CurrentLocation -> repo.loadWeather(
                    loadType.coords.latitude.toString(),
                    loadType.coords.longitude.toString()
                )
            }
            when (weatherData) {
                is Result.Success -> {
                    weatherData.data?.let { currentWeatherData = it }
                    currentWeatherData?.let { view?.onWeatherDataFound(it) }
                    view?.onViewStateChanged(ViewState.Ready)
                }
                is Result.Error -> {
                    view?.onViewStateChanged(ViewState.Error("Something broke, no worries OneDrop will show a more useful error next time!"))
                }
            }
        }

    } catch (e: Exception) {
        Log.e("onLoadWeatherTapped", e.toString())
    }

    override fun onViewForecastForCurrentRequested() {
        currentWeatherData?.let {
            //track things, this is for KPI's within product usually
            view?.onViewForecastForCurrentRequested(it)
        }
    }
}