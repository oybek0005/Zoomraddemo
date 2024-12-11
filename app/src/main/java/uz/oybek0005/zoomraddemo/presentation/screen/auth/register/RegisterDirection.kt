package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton


/**
Created by Oybek 5:42 PM 12/5/2024
 */

@Singleton
class RegisterDirection @Inject constructor(private val appNavigator: AppNavigator):RegisterContract.Directions {
    override suspend fun openNextScreen(number:String) {
        appNavigator.navigateTo(RegisterScreenDirections.actionRegisterScreenToVerifyCodeScreen(number,false))
    }

    override suspend fun backScreen() {
        appNavigator.back()
    }
}