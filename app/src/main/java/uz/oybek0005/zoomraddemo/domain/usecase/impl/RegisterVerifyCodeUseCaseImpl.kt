package uz.oybek0005.zoomraddemo.domain.usecase.impl

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.usecase.RegisterVerifyCodeUseCase
import javax.inject.Inject


/**
Created by Oybek 7:44 PM 12/6/2024
 */

class RegisterVerifyCodeUseCaseImpl @Inject constructor(
    private val repository: AuthRepository
):RegisterVerifyCodeUseCase {
    override suspend fun invoke(sms:String,isSignIn:Boolean): Result<Unit>? {
        return if(!isSignIn){
            repository.registerVerifyCode(sms).firstOrNull()
        }else{
            repository.signInVerifyCode(sms).firstOrNull()
        }
    }


}