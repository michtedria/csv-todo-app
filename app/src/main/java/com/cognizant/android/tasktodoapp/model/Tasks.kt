package com.cognizant.android.tasktodoapp.model

import android.os.Parcelable
import android.telecom.Call
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tasks (
    val title: String,
    val details: String,
): Parcelable
