package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

import androidx.lifecycle.LiveData
import com.airbnb.lottie.L
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest


/**
Created by Oybek 12:23 PM 12/5/2024
 */

interface RegisterContract {

    interface ViewModel{
        val message:LiveData<String>
        val checkNumber:LiveData<String>
        val checkBorn: LiveData<String>
        fun registerUser(user:RegisterUserRequest)
        fun clickBack()
        fun checkPhone(phoneNumber:String):Boolean
        fun checkPassword(password:String):Boolean
        fun checkBordDate(bornDate:String):Boolean
        fun checkButtonEnabled(
            firstName: String,
            lastName: String,
            phone: Boolean,
            bornDate: Boolean,
            password: Boolean,
            gender: String
        ): Boolean

        fun getchechNumber(): String?
        fun getcheckBorn(): String?
    }

    interface Directions{
       suspend fun openNextScreen(number:String)
       suspend fun backScreen()
    }
}