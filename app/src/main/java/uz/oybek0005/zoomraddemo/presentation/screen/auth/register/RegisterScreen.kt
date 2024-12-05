package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.databinding.ScreenSignInBinding


/**
Created by Oybek 12:21 PM 12/5/2024
 */

@AndroidEntryPoint
class RegisterScreen:Fragment(R.layout.screen_sign_in) {
    private val binding:ScreenSignInBinding by viewBinding()
    private val viewModel:RegisterViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnNext.setOnClickListener {
            binding.genderGroup.setOnCheckedChangeListener { _, checkedId ->
                val gender = when (checkedId) {
                    R.id.radioMale -> "0"
                    R.id.radioFemale -> "1"
                    else -> "0"
                }

                var text = binding.phoneInput.text.toString()
                val textParts = text.split(" ", "").joinToString ("")

                val bird = binding.bornDateInput.text.toString()
                val birdParts = bird.split("/", "").joinToString ("")
                viewModel.registerUser(
                    RegisterUserRequest(
                        firstName = binding.firstNameInput.text.toString(),
                        lastName = binding.lastNameInput.text.toString(),
                        phone = textParts,
                        password = binding.passwordInput.text.toString(),
                        bornDate = birdParts,
                        gender = gender
                    )
                )
            }
  }
    }
}
