package com.firebaseb.chucknorris.Models

import com.google.gson.annotations.SerializedName


data class ResponseJokeRandom (

    @SerializedName("categories" ) var categories : ArrayList<String> = arrayListOf(),
    @SerializedName("created_at" ) var createdAt  : String?           = null,
    @SerializedName("icon_url"   ) var iconUrl    : String?           = null,
    @SerializedName("id"         ) var id         : String?           = null,
    @SerializedName("updated_at" ) var updatedAt  : String?           = null,
    @SerializedName("url"        ) var url        : String?           = null,
    @SerializedName("value"      ) var value      : String?           = null

)
