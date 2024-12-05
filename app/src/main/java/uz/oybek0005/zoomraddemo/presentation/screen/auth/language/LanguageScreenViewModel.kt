package uz.oybek0005.zoomraddemo.presentation.screen.auth.language

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
Created by Oybek 12:27 PM 12/5/2024
 */


@HiltViewModel
class LanguageScreenViewModel @Inject constructor(
    private val direction: LanguageContract.Direction
) :LanguageContract.LanguageViewModel,ViewModel(){
    override  fun clickBack() {
        viewModelScope.launch {
            direction.moveToBack()
        }
    }

    override  fun clickNextScreen() {
        viewModelScope.launch {
            direction.moveToRegisterScreen()
        }
    }

}