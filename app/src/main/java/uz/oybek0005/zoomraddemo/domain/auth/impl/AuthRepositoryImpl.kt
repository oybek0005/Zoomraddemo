package uz.oybek0005.zoomraddemo.domain.auth.impl

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.oybek0005.zoomraddemo.data.local.LocalStorage
import uz.oybek0005.zoomraddemo.data.remote.api.AuthApi
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.domain.auth.AuthRepository
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

    }.flowOn(Dispatchers.IO).catch { error-> emit(Result.failure(error)) }

    override fun registerVerifyCode(registerVerifyCode: RegisterVerifyCode): Flow<Result<Unit>> = flow{
            val result = api.registerVerifySMS(localStorage.token,registerVerifyCode)
            if(result.isSuccessful){
                localStorage.accessToken = result.body()!!.accessToken
                localStorage.refreshToken = result.body()!!.refreshToken
                emit(Result.success(Unit))
            }
    }.flowOn(Dispatchers.IO).catch { error -> emit(Result.failure(error)) }


}