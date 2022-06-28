package com.example.menu.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PizzaItem(
    var description: String,
    var id: Int,
    var img: String,
    var name: String,
    var price: Int,
    var quantity: Int,
    var sizeandcrust: List<Sizeandcrust>,
    var veg: Boolean
):Parcelable