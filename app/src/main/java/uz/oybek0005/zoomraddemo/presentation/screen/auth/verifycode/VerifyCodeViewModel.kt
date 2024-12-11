package uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode

import android.util.Log
import androidx.collection.emptyLongSet
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.usecase.RegisterVerifyCodeUseCase
import uz.oybek0005.zoomraddemo.domain.usecase.ResendCodeUseCase
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterContract
import javax.inject.Inject


/**
Created by Oybek 3:05 PM 12/6/2024
 */

@HiltViewModel
class VerifyCodeViewModel @Inject constructor(
    private val useCaseVerify: RegisterVerifyCodeUseCase,
    private val useCaseResend: ResendCodeUseCase,
    private val direction: VerifyDirection,
):VerifyCodeContract.ViewModel,ViewModel() {
    override val message = MutableLiveData<String>()
    override val txtTimerState = MutableStateFlow("")


    override fun clickVerifyScreen() {
        viewModelScope.launch {
            direction.openNextScreen()
        }
    }



    override fun clickBack() {
        viewModelScope.launch {
            direction.backScreen()
        }
    }

    override fun verifySMSCode(verifyCode: String,isSignIn:Boolean) {
        viewModelScope.launch {
            val result = useCaseVerify.invoke(verifyCode,isSignIn)
            if (result?.isSuccess == true) {
                clickVerifyScreen()
            }else{
                Log.d("AAAC", result?.isSuccess.toString())
                message.postValue(result?.exceptionOrNull()?.message ?: "")
            }
        }
    }

    override fun formatSecondsToTime(seconds: Int): String {
        if (seconds == 0) return ""
        val minutes = seconds / 60
        val remainingSeconds = seconds % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)
    }



    private val countDownTimerFlow = flow {
        var duration = 60
        emit(duration)
        while (duration > 0) {
            delay(1000L)
            emit(--duration)
        }
    }

    override suspend fun startTimer() {
        countDownTimerFlow.onEach {
            txtTimerState.emit(formatSecondsToTime(it))
        }.collect()
    }

    override suspend fun replaceCode(){
        useCaseResend()
    }





}