package com.example.simulador.domain

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("nome")
    val name:String,
    @SerializedName("força")
    val stars:Int,
    @SerializedName("imagem")
    val image:String
)
