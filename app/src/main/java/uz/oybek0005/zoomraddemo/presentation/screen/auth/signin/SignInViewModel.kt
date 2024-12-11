package uz.oybek0005.zoomraddemo.presentation.screen.auth.signin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.usecase.SignInUseCase
import javax.inject.Inject


/**
Created by Oybek 10:04 AM 12/11/2024
 */

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val useCase: SignInUseCase,
    private val direction: SignInContract.Direction
):ViewModel(),SignInContract.ViewModel {

    override val checkNumber = MutableLiveData<String>()
    override val message = MutableLiveData<String>()
    override fun signIn(user: SignInRequest) {
        viewModelScope.launch {
            val result = useCase.invoke(user)
            result?.onSuccess{
                direction.openNextScreen(user.phone)
            }
            result?.onFailure { error->
                message.postValue(error(error))
            }
        }
    }


    override fun clickBack() {
        viewModelScope.launch {
            direction.backScreen()
        }
    }


    override fun checkPhone(phoneNumber: String): Boolean {
        checkNumber.value = phoneNumber.split(" ","").joinToString("")
        val regex = Regex("^(90|91|33|99|95|22|94|97)\\d{7}$")
        return regex.matches(checkNumber.value!!)
    }

    override fun checkNumber():String?{
        return checkNumber.value
    }

    override fun checkPassword(password: String): Boolean {
        return password.length > 7
    }

    override fun moveToSignUpScreen(){
        viewModelScope.launch {
            direction.openSingUpScreen()
        }
    }


}