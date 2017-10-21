package com.example.tareq.weatherapp_kt.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.tareq.weatherapp_kt.R
import com.example.tareq.weatherapp_kt.R.id.*
import com.example.tareq.weatherapp_kt.domain.model.Forecast
import com.example.tareq.weatherapp_kt.domain.model.ForecastList
import com.example.tareq.weatherapp_kt.ui.utils.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * Created by tareq on 17/10/17.
 */

class ForecastListAdapter(val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit):
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_forecast,parent,false)
         return ViewHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        with(weekForecast.dailyForecast[position]){
            holder?.bindForecast(weekForecast[position])
        }

    }

    override fun getItemCount(): Int = weekForecast.size

   // class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit):
           RecyclerView.ViewHolder(view){
       private val iconView = view.find<ImageView>(icon)
       private val dateView = view.find<TextView>(date)
       private val descriptionView  = view.find<TextView>(description)
       private val maxTemperatureView = view.find<TextView>(maxTemperature)
       private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

fun bindForecast(forecast: Forecast){
    with(forecast){
        Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
        dateView.text = date
        descriptionView.text = description
        maxTemperatureView.text = "$high"
        minTemperatureView.text = "$low"
        itemView.setOnClickListener{ itemClick(this)}
    }
}
   }

    interface OnItemClickListener {
    operator  fun invoke(forecast: Forecast)
    }
}