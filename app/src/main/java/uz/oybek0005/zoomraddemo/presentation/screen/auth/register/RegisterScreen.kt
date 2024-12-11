package uz.oybek0005.zoomraddemo.presentation.screen.auth.register

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
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterUserRequest
import uz.oybek0005.zoomraddemo.databinding.ScreenSignUpBinding


/**
Created by Oybek 12:21 PM 12/5/2024
 */

@AndroidEntryPoint
class RegisterScreen : Fragment(R.layout.screen_sign_up) {
    private val binding: ScreenSignUpBinding by viewBinding()
    private val viewModel: RegisterViewModel by viewModels()
    private var  gender = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.apply {
            val textWatcher = object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    updateButtonState()
                }
                override fun afterTextChanged(s: Editable?) {}
            }

            firstNameInput.addTextChangedListener(textWatcher)
            lastNameInput.addTextChangedListener(textWatcher)
            phoneInput.addTextChangedListener(textWatcher)
            passwordInput.addTextChangedListener(textWatcher)
            bornDateInput.addTextChangedListener(textWatcher)

            genderGroup.setOnCheckedChangeListener { _, _ ->
                updateButtonState()
            }
            binding.genderGroup.setOnCheckedChangeListener { _, checkedId ->
                gender = when (checkedId) {
                    R.id.radioMale -> "0"
                    R.id.radioFemale -> "1"
                    else -> "3"
                }
            }
        }
    }
        private fun updateButtonState() {
            binding.apply {
                val allFieldsFilled = firstNameInput.text.toString().isNotEmpty() &&
                        lastNameInput.text.toString().isNotEmpty() &&
                        phoneInput.text.toString().isNotEmpty() &&
                        passwordInput.text.toString().isNotEmpty() &&
                        bornDateInput.text.toString().isNotEmpty() &&
                        genderGroup.checkedRadioButtonId != -1

                if (allFieldsFilled) {
                    btnNext.setBackgroundResource(R.drawable.bg_enabled_register)
                    btnNext.setOnClickListener {
                        checkInputs()
                    }
                } else {
                    btnNext.setBackgroundResource(R.drawable.bg_disable_register)
                }
            }
        }



        private fun setRequest(gender:String) {
            viewModel.registerUser(
                RegisterUserRequest(
                    firstName = binding.firstNameInput.text.toString(),
                    lastName = binding.lastNameInput.text.toString(),
                    phone = viewModel.getchechNumber()!!,
                    password = binding.passwordInput.text.toString(),
                    bornDate = viewModel.getcheckBorn()!!,
                    gender = gender
                )
            )
    }

    private fun checkInputs() {

        binding.apply {
            if(!viewModel.checkPhone(phoneInput.text.toString())){
                Toast.makeText(requireContext(),"Raqam noto'g'ri kiritildi",Toast.LENGTH_SHORT).show()
            }else if(!viewModel.checkPassword(passwordInput.text.toString())){
                Toast.makeText(requireContext(),"Parol shartga mos kelmadi",Toast.LENGTH_SHORT).show()
            }else if(!viewModel.checkBordDate(bornDateInput.text.toString())){
                Toast.makeText(requireContext(),"Tug'ilgan yil noto'g'ri kiritildi",Toast.LENGTH_SHORT).show()
            }else if(firstNameInput.text.toString().length<3 || lastNameInput.text.toString().length<3){
                Toast.makeText(requireContext(),"Ism familiya noto'g'ri kiritildi",Toast.LENGTH_SHORT).show()
            }else{
                setRequest(gender)
            }

        }
    }



}
