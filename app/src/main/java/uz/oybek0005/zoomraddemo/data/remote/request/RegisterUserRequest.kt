package uz.oybek0005.zoomraddemo.data.remote.request

import com.google.gson.annotations.SerializedName


/**
Created by Oybek 4:04 PM 12/5/2024
 */

data class RegisterUserRequest(
    val phone: String,
    val password: String,
    @SerializedName("first-name") val firstName: String,
    @SerializedName("last-name") val lastName: String,
    @SerializedName("born-date") val bornDate: String,
    val gender: String

)