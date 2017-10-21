package com.example.tareq.weatherapp_kt.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.tareq.weatherapp_kt.R
import com.example.tareq.weatherapp_kt.domain.commands.RequestForecastCommand
import com.example.tareq.weatherapp_kt.domain.model.Forecast
import com.example.tareq.weatherapp_kt.ui.adapters.ForecastListAdapter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.jetbrains.anko.*


class MainActivity : AppCompatActivity() {
    private val items = listOf<String>(
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19",
            "Mon 3/23 - Sunny - 31/19"

    )

   //private val url = "http://api.openweathermap.org/data/2.5/forecast/daily?APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metri\\c&cnt=7"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val forecastList  = findViewById<RecyclerView>(R.id.forecast_list)
        val forecastList: RecyclerView  = find(R.id.forecast_list)
          forecastList.layoutManager = LinearLayoutManager(this)
         // forecastList.adapter = ForecastListAdapter(items)

doAsync {
    val result = RequestForecastCommand("94043").execute()
    uiThread {
        forecastList.adapter = ForecastListAdapter(result,
                object : ForecastListAdapter.OnItemClickListener{
                    override fun invoke(forecast: Forecast){
                        toast(forecast.date)
                    }
                })
     }

}

    }

    fun toast(message: String, tag: String =  MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this, "[$tag] $message",length).show()
    }
}
