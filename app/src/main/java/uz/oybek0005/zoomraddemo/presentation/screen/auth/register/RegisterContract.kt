package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

import androidx.lifecycle.LiveData
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest


/**
Created by Oybek 12:23 PM 12/5/2024
 */

interface RegisterContract {

    interface ViewModel{
        val message:LiveData<String>
        fun registerUser(user:RegisterUserRequest)
        fun clickVerifyScreen()
        fun clickBack()
    }

    interface Directions{
       suspend fun openNextScreen()
       suspend fun backScreen()
    }
}