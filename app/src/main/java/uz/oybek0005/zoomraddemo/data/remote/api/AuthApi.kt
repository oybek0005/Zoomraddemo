package uz.oybek0005.zoomraddemo.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterTokenResend
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest
import uz.oybek0005.zoomraddemo.data.remote.response.RegisterRefreshAndAccessToken
import uz.oybek0005.zoomraddemo.data.remote.response.RegisterTokenResponse


/**
Created by Oybek 3:55 PM 12/5/2024
 */

interface AuthApi{
    @POST("v1/auth/sign-up")
    suspend fun registerUser(@Body registerUserRequest: RegisterUserRequest):Response<RegisterTokenResponse>

    @POST("v1/auth/sign-up/verify")
    suspend fun registerVerifySMS(@Body code:RegisterVerifyCode):Response<RegisterRefreshAndAccessToken>

    @POST("v1/auth/sign-in/verify")
    suspend fun signInVerifySMS(@Body code:RegisterVerifyCode):Response<RegisterRefreshAndAccessToken>

    @POST("v1/auth/sign-up/resend")
    suspend fun registerResend(@Body tokenResend:RegisterTokenResend):Response<RegisterTokenResponse>

    @POST("v1/auth/sign-in")
    suspend fun signIn(@Body signInRequest: SignInRequest):Response<RegisterTokenResponse>








}

