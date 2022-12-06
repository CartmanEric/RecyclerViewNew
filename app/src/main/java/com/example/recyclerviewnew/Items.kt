package com.example.recyclerviewnew

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items(
    val name: String?,
    val id: Int ): Parcelable