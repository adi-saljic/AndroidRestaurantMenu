package com.example.menu.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.menu.models.Sizeandcrust
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "pizza_table")
data class PizzaBase (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var description: String,
    var name: String,
    var price: Int
):Parcelable