package com.example.retrofitandcoroutines.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Source {
    @Expose
    @SerializedName("name")
    var name: String? = null
}