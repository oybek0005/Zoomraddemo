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
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.repository.auth.impl.AuthRepositoryImpl
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
      override val checkNumber = MutableLiveData<String>()
      override val checkBorn = MutableLiveData<String>()


      override fun registerUser(user: RegisterUserRequest) {
            authRepository.registerUser(user).onEach {
                  it.onSuccess{
                        direction.openNextScreen(user.phone)
                  }
                  it.onFailure { error->
                        message.postValue(error.message)
                  }
            }.launchIn(viewModelScope)
      }


      override fun clickBack() {
            viewModelScope.launch {
                  direction.backScreen()
            }
      }

      override fun checkPhone(phoneNumber: String): Boolean {
          checkNumber.value = phoneNumber.split(" ","").joinToString("")
            val regex = Regex("^(90|91|33|99|95|22)\\d{7}$")
            return regex.matches(checkNumber.value!!)
      }

      override fun getchechNumber():String?{
            return checkNumber.value
      }

      override fun getcheckBorn():String?{
            return checkBorn.value
      }

      override fun checkPassword(password: String): Boolean {
            return password.length>7
      }

      override fun checkBordDate(bornDate: String): Boolean {
            val regex = Regex("^(19[4-9][0-9]|200[0-9]|201[0-9]|2020)/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$")
            checkBorn.value = bornDate.split("/","").joinToString("")
            return regex.matches(bornDate)
      }

      override fun checkButtonEnabled(firstName:String,lastName:String,phone:Boolean,bornDate:Boolean,password:Boolean,gender:String): Boolean {
            if(phone && password && bornDate && firstName.isNotEmpty() && lastName.isNotEmpty()){
                  return true
            }else return false
      }


}