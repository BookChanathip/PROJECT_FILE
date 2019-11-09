package com.example.project_dentalclinic
import  com.google.gson.annotations.Expose
import  com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName(value = "username") val username : String,

    @Expose
    @SerializedName(value = "password") val password : String

){}