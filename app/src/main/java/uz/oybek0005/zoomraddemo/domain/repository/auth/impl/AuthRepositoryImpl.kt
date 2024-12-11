package uz.oybek0005.zoomraddemo.domain.repository.auth.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.oybek0005.zoomraddemo.data.local.LocalStorage
import uz.oybek0005.zoomraddemo.data.remote.api.AuthApi
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterTokenResend
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton


/**
Created by Oybek 5:50 PM 12/4/2024
 */

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val localStorage:LocalStorage
) : AuthRepository {

    override fun registerUser(userRequest: RegisterUserRequest): Flow<Result<Unit>> = flow{
        val result =  api.registerUser(userRequest)
        if(result.isSuccessful){
            localStorage.token = result.body()!!.token
            emit(Result.success(Unit))
        }

    }.flowOn(IO).catch { error-> emit(Result.failure(error)) }

    override fun signIn(signIn: SignInRequest): Flow<Result<Unit>> = flow {
        val result = api.signIn(signIn)
        if(result.isSuccessful){
            localStorage.token = result.body()!!.token
            emit(Result.success(Unit))
        }
    }.flowOn(IO).catch { error->emit(Result.failure(error)) }

    override fun registerVerifyCode(sms:String): Flow<Result<Unit>> = flow{
        val result = api.registerVerifySMS(RegisterVerifyCode(localStorage.token,sms))
            if(result.isSuccessful){
                localStorage.accessToken = result.body()?.accessToken ?:""
                localStorage.refreshToken = result.body()?.refreshToken?:""
                Log.d("token", result.body()?.accessToken.toString() +" && "+ localStorage.refreshToken)
                emit(Result.success(Unit))
            }
    }.flowOn(IO).catch { error -> emit(Result.failure(error)) }

    override fun signInVerifyCode(sms:String): Flow<Result<Unit>> = flow{
        val result = api.signInVerifySMS(RegisterVerifyCode(localStorage.token,sms))
        if(result.isSuccessful){
            localStorage.accessToken = result.body()?.accessToken ?:""
            localStorage.refreshToken = result.body()?.refreshToken?:""
            Log.d("token", result.body()?.accessToken.toString() +" && "+ localStorage.refreshToken)
            emit(Result.success(Unit))
        }
    }.flowOn(IO).catch { error -> emit(Result.failure(error)) }



    override fun registerResendCode(): Flow<Result<Unit>> = flow {
        val result = api.registerResend(RegisterTokenResend(localStorage.token))
        if(result.isSuccessful){
            localStorage.token = result.body()!!.token
            emit(Result.success(Unit))
        }
    }.flowOn(IO).catch { error-> emit(Result.failure(error)) }


}