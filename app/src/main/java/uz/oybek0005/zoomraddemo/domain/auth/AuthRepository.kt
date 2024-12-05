package uz.oybek0005.zoomraddemo.domain.auth

import kotlinx.coroutines.flow.Flow
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.data.remote.response.RegisterRefreshAndAccessToken


/**
Created by Oybek 5:46 PM 12/4/2024
 */

interface AuthRepository {
    fun registerUser(userRequest: RegisterUserRequest):Flow<Result<Unit>>
    fun registerVerifyCode(registerVerifyCode: RegisterVerifyCode):Flow<Result<Unit>>
}