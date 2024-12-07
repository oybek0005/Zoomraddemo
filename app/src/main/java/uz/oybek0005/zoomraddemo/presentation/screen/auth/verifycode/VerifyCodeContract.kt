package uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.MutableStateFlow
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode


/**
Created by Oybek 3:05 PM 12/6/2024
 */

interface VerifyCodeContract {

    interface ViewModel{
        fun verifySMSCode(verifyCode: String)
        val message: LiveData<String>
        fun clickVerifyScreen()
        fun clickBack()
        fun formatSecondsToTime(seconds: Int): String
        val txtTimerState: MutableStateFlow<String>
        suspend fun startTimer()
        suspend fun replaceCode()
    }

    interface Directions{
        suspend fun openNextScreen()
        suspend fun backScreen()
    }
}