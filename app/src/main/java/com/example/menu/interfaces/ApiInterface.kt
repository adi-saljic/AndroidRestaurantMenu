package com.example.menu.interfaces

import com.example.menu.models.DessertItem
import com.example.menu.models.PizzaBase
import com.example.menu.models.PizzaItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiInterface {
    @Headers("X-RapidAPI-Key: 10d6261b9emsh28cd4967bbac31cp1902afjsnc50fc490726d",
    "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com")

    @GET("desserts")
    fun getData(
    ):Call<List<DessertItem>>

    @Headers("X-RapidAPI-Key: 10d6261b9emsh28cd4967bbac31cp1902afjsnc50fc490726d",
        "X-RapidAPI-Host: pizza-and-desserts.p.rapidapi.com")

    @GET("pizzas")
    fun getPizzaData(
    ):Call<List<PizzaItem>>
}