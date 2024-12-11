package uz.oybek0005.zoomraddemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.oybek0005.zoomraddemo.presentation.screen.auth.language.LanguageContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.language.LanguageDirection
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterDirection
import uz.oybek0005.zoomraddemo.presentation.screen.auth.signin.SignInContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.signin.SignInDirection
import uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode.VerifyCodeContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode.VerifyDirection

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindLoginDirection(impl: LanguageDirection) : LanguageContract.Direction

    @Binds
    fun bindVerifyCodeDirection(impl: RegisterDirection):RegisterContract.Directions

    @Binds
    fun bindHomeDirection(impl: VerifyDirection):VerifyCodeContract.Directions

    @Binds
    fun bindSignInToVerify(impl:SignInDirection):SignInContract.Direction
}



