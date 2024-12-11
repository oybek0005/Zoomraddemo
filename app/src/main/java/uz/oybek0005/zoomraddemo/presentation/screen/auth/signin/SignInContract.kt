package uz.oybek0005.zoomraddemo.presentation.screen.auth.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest


/**
Created by Oybek 10:05 AM 12/11/2024
 */

interface SignInContract {
    interface ViewModel{

        val checkNumber: LiveData<String>
        fun checkPhone(phoneNumber: String): Boolean
        fun checkNumber(): String?
        fun checkPassword(password: String): Boolean
        fun signIn(user: SignInRequest)
        fun clickBack()
        val message: LiveData<String>
        fun moveToSignUpScreen()
    }

    interface Direction{
        suspend fun openNextScreen(number: String)
        suspend fun backScreen()
        suspend fun openSingUpScreen()
    }
}