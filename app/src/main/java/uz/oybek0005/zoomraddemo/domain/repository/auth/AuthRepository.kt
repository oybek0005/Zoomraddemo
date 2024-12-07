package uz.oybek0005.zoomraddemo.domain.repository.auth

import kotlinx.coroutines.flow.Flow
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest


/**
Created by Oybek 5:46 PM 12/4/2024
 */

interface AuthRepository {
    fun registerUser(userRequest: RegisterUserRequest):Flow<Result<Unit>>
    fun registerVerifyCode(sms: String): Flow<Result<Unit>>
    fun registerResendCode(): Flow<Result<Unit>>
}