package uz.oybek0005.zoomraddemo.presentation.screen.auth.language

import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton


/**
Created by Oybek 5:58 PM 12/4/2024
 */

@Singleton
class LanguageDirection @Inject constructor(private val appNavigator: AppNavigator):LanguageContract.Direction{
    override suspend fun moveToRegisterScreen() {
        appNavigator.navigateTo(R.id.action_screenLanguage_to_registerScreen)
    }

    override suspend fun moveToBack() {
       appNavigator.back()
    }

}