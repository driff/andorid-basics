package com.fif.tech.android.myapplication.entities


import com.google.gson.annotations.SerializedName

data class ListResults<T>(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<T>?
)