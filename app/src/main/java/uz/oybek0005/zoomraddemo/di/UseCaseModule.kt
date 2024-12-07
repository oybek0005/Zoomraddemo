package uz.oybek0005.zoomraddemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.oybek0005.zoomraddemo.domain.usecase.RegisterVerifyCodeUseCase
import uz.oybek0005.zoomraddemo.domain.usecase.ResendCodeUseCase
import uz.oybek0005.zoomraddemo.domain.usecase.impl.RegisterVerifyCodeUseCaseImpl
import uz.oybek0005.zoomraddemo.domain.usecase.impl.ResendCodeUseCaseImpl


/**
Created by Oybek 7:48 PM 12/6/2024
 */

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun verifyCode(impl:RegisterVerifyCodeUseCaseImpl): RegisterVerifyCodeUseCase

    @Binds
    fun resendCode(impl:ResendCodeUseCaseImpl):ResendCodeUseCase
}