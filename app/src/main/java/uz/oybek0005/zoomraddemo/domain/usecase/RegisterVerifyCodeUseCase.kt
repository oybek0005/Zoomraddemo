package uz.oybek0005.zoomraddemo.domain.usecase


/**
Created by Oybek 7:40 PM 12/6/2024
 */

interface RegisterVerifyCodeUseCase {
    suspend operator fun invoke(sms:String):Result<Unit>?
}