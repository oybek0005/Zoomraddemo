package uz.oybek0005.zoomraddemo.presentation.screen.auth.verifycode

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.data.remote.request.RegisterVerifyCode
import uz.oybek0005.zoomraddemo.databinding.ScreenVerifyCodeBinding


/**
Created by Oybek 5:47 PM 12/5/2024
 */

@AndroidEntryPoint
class VerifyCodeScreen:Fragment(R.layout.screen_verify_code) {
    private val binding: ScreenVerifyCodeBinding by viewBinding()
    private val viewModel: VerifyCodeContract.ViewModel by viewModels<VerifyCodeViewModel>()
    private val navArgs:VerifyCodeScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setUpTextWatcher()
        binding.textNumber.text = "+998${navArgs.phoneNumber}"


        lifecycleScope.launch {
            viewModel.txtTimerState.collect { formattedTime ->
                binding.chronometr.text = formattedTime
            }
        }

        binding.startTime.setOnClickListener {
            lifecycleScope.launch {
                if(binding.chronometr.text.toString().isEmpty()){
                    viewModel.replaceCode()
                    viewModel.startTimer()
                    viewModel.verifySMSCode(binding.textPassword.text.toString())
                }
            }
        }

    }

    private fun setUpTextWatcher() {
        binding.btnNext.setOnClickListener {
            viewModel.verifySMSCode(binding.textPassword.text.toString())
        }
        binding.textPassword.doOnTextChanged { text, _, _, _ ->
            val isTextValid = ((text.toString().length) == 6)
            binding.btnNext.isEnabled = isTextValid
            if (isTextValid) {
                binding.btnNext.setBackgroundResource(R.drawable.bg_enabled_register)

            }else {
                binding.btnNext.setBackgroundResource(R.drawable.bg_disable_register)
            }
        }
    }
}