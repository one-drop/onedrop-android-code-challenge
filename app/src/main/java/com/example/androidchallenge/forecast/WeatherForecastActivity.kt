package com.example.androidchallenge.forecast

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidchallenge.R
import com.example.androidchallenge.databinding.ActivityWeatherForecastBinding
import com.example.androidchallenge.models.Weather
import com.example.androidchallenge.models.WeatherData
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherForecastActivity : AppCompatActivity() {


    /**
     * Did not had time to consider,
     * empty cases, better design, create View/Presenter contract in case
     * we want to expand etc
     */

    private var data: WeatherData? = null

    private lateinit var binding: ActivityWeatherForecastBinding
    private lateinit var forecastAdapter: ForecastAdapter

    companion object {
        const val EXTRA_WEATHER_DATA = "weather.data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherForecastBinding.inflate(layoutInflater)
        setContentView(binding.root)
        extractData()
        setupForecastList()
    }

    private fun extractData() {
        data = intent.getParcelableExtra(EXTRA_WEATHER_DATA)
        Log.d(WeatherForecastActivity::class.simpleName, "Data from intent:$data")
    }

    private fun setupForecastList() {
        forecastAdapter = ForecastAdapter()
        binding.forecastList.apply {
            adapter = forecastAdapter
            layoutManager  = LinearLayoutManager(this@WeatherForecastActivity)
        }
        forecastAdapter.setData(data?.forecast.orEmpty())
    }


    class ForecastAdapter : RecyclerView.Adapter<ForecastVH>() {
        private val data: MutableList<Weather> = mutableListOf()
        fun setData(weatherData: List<Weather>) {
            data.clear()
            data.addAll(weatherData)
            notifyItemRangeInserted(0, data.size)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastVH =
            ForecastVH.create(parent)

        override fun onBindViewHolder(holder: ForecastVH, position: Int) =
            holder.bind(data[position])

        override fun getItemCount(): Int = data.size
    }
}

class ForecastVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val weatherInfo: MaterialTextView = itemView.findViewById(R.id.weather_data)

    fun bind(weather: Weather) {
        weatherInfo.text = weather.forecastString()
    }

    companion object {
        @JvmStatic
        fun create(parent: ViewGroup) = ForecastVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_weather_data,
                parent,
                false
            )
        )
    }
}

