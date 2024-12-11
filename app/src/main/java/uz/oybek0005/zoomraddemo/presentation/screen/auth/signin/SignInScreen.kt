package uz.oybek0005.zoomraddemo.presentation.screen.auth.signin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest
import uz.oybek0005.zoomraddemo.databinding.ScreenSignInBinding


/**
Created by Oybek 9:58 AM 12/11/2024
 */

@AndroidEntryPoint
class SignInScreen:Fragment(R.layout.screen_sign_in) {
    private val binding: ScreenSignInBinding by viewBinding()
    private val viewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.apply {
            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    updateButtonState()
                }
                override fun afterTextChanged(s: Editable?) {}
            }
            phoneInput.addTextChangedListener(textWatcher)
            passwordInput.addTextChangedListener(textWatcher)
        }

        binding.toSignUp.setOnClickListener {
            viewModel.moveToSignUpScreen()
        }

    }

    private fun checkInputs() {
        binding.apply {
            if(!viewModel.checkPhone(phoneInput.text.toString())){
                Toast.makeText(requireContext(),"Raqam noto'g'ri kiritildi", Toast.LENGTH_SHORT).show()
            }else if(!viewModel.checkPassword(passwordInput.text.toString())){
                Toast.makeText(requireContext(),"Parol shartga mos kelmadi", Toast.LENGTH_SHORT).show()
            }else{
                setRequest()
            }

        }
    }

    private fun updateButtonState() {
        binding.apply {
            val allFieldsFilled = phoneInput.text.toString().isNotEmpty() &&
                    passwordInput.text.toString().isNotEmpty()
            if (allFieldsFilled) {
                btnNext.setBackgroundResource(R.drawable.bg_enabled_register)
                btnNext.setOnClickListener {
                    checkInputs()
                }
            }else{
                btnNext.setBackgroundResource(R.drawable.bg_disable_register)
            }
        }
    }

    private fun setRequest() {
        viewModel.signIn(
            SignInRequest(
                phone = viewModel.checkNumber()!!,
                password = binding.passwordInput.text.toString(),
            )
        )
    }
}