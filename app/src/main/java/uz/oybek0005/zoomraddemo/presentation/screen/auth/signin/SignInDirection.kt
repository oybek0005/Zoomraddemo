package uz.oybek0005.zoomraddemo.presentation.screen.auth.signin

import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterScreenDirections
import javax.inject.Inject
import javax.inject.Singleton


/**
Created by Oybek 10:08 AM 12/11/2024
 */

@Singleton
class SignInDirection @Inject constructor(private val appNavigator: AppNavigator):SignInContract.Direction {
    override suspend fun openNextScreen(number:String) {
        appNavigator.navigateTo(SignInScreenDirections.actionSignInScreenToVerifyCodeScreen(number))
    }

    override suspend fun openSingUpScreen(){
        appNavigator.navigateTo(SignInScreenDirections.actionSignInScreenToRegisterScreen())
    }

    override suspend fun backScreen() {
        appNavigator.back()
    }
}