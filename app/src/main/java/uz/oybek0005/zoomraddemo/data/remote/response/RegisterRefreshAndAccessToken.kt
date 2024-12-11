package uz.oybek0005.zoomraddemo.data.remote.response

import com.google.gson.annotations.SerializedName


/**
Created by Oybek 4:26 PM 12/5/2024
 */

data class RegisterRefreshAndAccessToken(
    @SerializedName("refresh-token")val refreshToken:String,
    @SerializedName("access-token")val accessToken:String,
)