package com.example.menu.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SendPizza(
    var description: String,
    var name: String,
    var price: Int,

):Parcelable
