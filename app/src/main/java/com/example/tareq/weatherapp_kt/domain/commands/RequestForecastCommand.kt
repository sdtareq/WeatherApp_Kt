package com.example.tareq.weatherapp_kt.domain.commands

import com.example.tareq.weatherapp_kt.domain.mappers.ForecastDataMapper
import com.example.tareq.weatherapp_kt.data.ForecastRequest
import com.example.tareq.weatherapp_kt.domain.model.ForecastList

/**
 * Created by tareq on 19/10/17.
 */

class RequestForecastCommand(val zipCode: String): Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest  = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }

}