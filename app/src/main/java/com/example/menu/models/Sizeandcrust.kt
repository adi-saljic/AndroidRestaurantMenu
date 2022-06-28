package com.example.menu.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sizeandcrust(
    var mediumPan: List<MediumPan>,
    var mediumstuffedcrustcheesemax: List<Mediumstuffedcrustcheesemax>,
    var mediumstuffedcrustvegkebab: List<Mediumstuffedcrustvegkebab>
):Parcelable