package com.example.menu.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "recipe_table")
data class Recipe (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val name: String,
    val category: String,
    val ingredients: String,
    val desc: String,

):Parcelable