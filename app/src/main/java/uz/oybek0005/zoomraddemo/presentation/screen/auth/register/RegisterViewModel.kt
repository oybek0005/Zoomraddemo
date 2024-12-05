package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.domain.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.auth.impl.AuthRepositoryImpl
import javax.inject.Inject


/**
      Created by Oybek 5:01 PM 12/5/2024
 */


@HiltViewModel
class RegisterViewModel  @Inject constructor(
      private val authRepository: AuthRepository,
      private val direction: RegisterContract.Directions,
):ViewModel(),RegisterContract.ViewModel {
      override val message = MutableLiveData<String>()

      override fun registerUser(user: RegisterUserRequest) {
            authRepository.registerUser(user).onEach {
                  it.onSuccess{
                        direction.openNextScreen()
                  }
                  it.onFailure { error->
                        message.postValue(error.message)
                  }
            }.launchIn(viewModelScope)
      }

      override fun clickVerifyScreen() {

      }

      override fun clickBack() {
            viewModelScope.launch {
                  direction.backScreen()
            }
      }


}