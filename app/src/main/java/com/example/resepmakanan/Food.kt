package com.example.resepmakanan

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val name: String,
    val time: String,
    val ingredients: String,
    val process: String,
    val imageResourceId: Int
) : Parcelable