package com.example.androidchallenge.weather

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidchallenge.Navigator
import com.example.androidchallenge.ViewState
import com.example.androidchallenge.databinding.ActivityWeatherBinding
import com.example.androidchallenge.models.WeatherData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_main.view.actions_container
import kotlinx.android.synthetic.main.content_main.view.progress_circular
import kotlinx.android.synthetic.main.content_main.view.weather_data_container
import kotlinx.android.synthetic.main.content_main.view.weather_ny_button
import javax.inject.Inject

//move to extensions module/package
fun View.show() = kotlin.run { this.visibility = View.VISIBLE }
fun View.gone() = kotlin.run { this.visibility = View.GONE }
fun View.disable() = kotlin.run { this.isEnabled = false }
fun View.enable() = kotlin.run { this.isEnabled = true }

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity(), WeatherContract.View {

    @Inject
    internal lateinit var presenter: WeatherContract.WeatherPresenter

    @Inject
    internal lateinit var navigator: Navigator

    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        presenter.onViewCreated(this)

        binding.root.setOnClickListener { presenter.onViewForecastForCurrentRequested() }
        binding.root.weather_ny_button.setOnClickListener { presenter.onLoadWeather(LoadType.NewYork) }
        //did not had time todo the my location based one, but essentially
        //the activity can get an injected "LocationService that will provide a way to
        //request the user current location, ask permissions etc
    }

    override fun onWeatherDataFound(data: WeatherData) {
        binding.root.weather_data_container.text = data.currentWeather.toString()
        Log.d("Data", data.toString())
    }

    override fun onViewForecastForCurrentRequested(data: WeatherData) {
        navigator.toForecastDetails(this, data)
    }

    override fun onViewStateChanged(state: ViewState) {
        when (state) {
            is ViewState.Loading -> {
                binding.root.actions_container.disable()
                binding.root.weather_data_container.text = ""
                binding.root.weather_data_container.gone()
                binding.root.progress_circular.show()
            }
            is ViewState.Ready -> {
                binding.root.progress_circular.gone()
                binding.root.actions_container.enable()
                binding.root.weather_data_container.show()
            }
            is ViewState.Error -> {
                binding.root.progress_circular.gone()
                binding.root.actions_container.enable()
                binding.root.weather_data_container.gone()
                Toast.makeText(this, state.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }
}