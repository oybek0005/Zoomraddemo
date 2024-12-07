package uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode

import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterContract
import javax.inject.Inject


/**
Created by Oybek 3:04 PM 12/6/2024
 */

class VerifyDirection @Inject constructor(private val appNavigator: AppNavigator): VerifyCodeContract.Directions {
    override suspend fun openNextScreen() {
        appNavigator.navigateTo(R.id.action_verifyCodeScreen_to_homeScreen)
    }

    override suspend fun backScreen() {
        appNavigator.back()
    }
}