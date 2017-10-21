package com.example.tareq.weatherapp_kt.domain.commands

/**
 * Created by tareq on 19/10/17.
 */

 interface Command<out T> {
    fun execute():T
}