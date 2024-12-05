package uz.oybek0005.zoomraddemo.presentation.screen.auth.language


/**
Created by Oybek 12:23 PM 12/5/2024
 */

interface LanguageContract {

    interface LanguageViewModel{
        fun clickBack()
        fun clickNextScreen()
    }

    interface Direction{
        suspend fun moveToRegisterScreen()
        suspend fun moveToBack()
    }

}