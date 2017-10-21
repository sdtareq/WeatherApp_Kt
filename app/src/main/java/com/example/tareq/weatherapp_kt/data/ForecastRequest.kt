package com.example.tareq.weatherapp_kt.data

import com.google.gson.Gson
import java.net.URL

/**
 * Created by tareq on 17/10/17.
 */

class ForecastRequest(val zipCode: String){


    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val _URL  = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metri\\c&cnt=7"
        private val COMPLETE_URL = "${_URL}&APPID=${APP_ID}&q="
    }
    fun execute(): ForecastResult {
        val forecastJsonString = URL(COMPLETE_URL + zipCode).readText()

        return Gson().fromJson(forecastJsonString,
                ForecastResult::class.java )
    }

}