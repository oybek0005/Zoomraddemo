package uz.oybek0005.zoomraddemo.presentation.screen.auth.splash

import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton


/**
Created by Oybek 5:58 PM 12/4/2024
 */

@Singleton
class SplashDirection @Inject constructor(private val appNavigator: AppNavigator){
     suspend fun moveToFinishScreen() {
             appNavigator.navigateTo(R.id.action_splashScreen_to_screenLanguage)
    }
}