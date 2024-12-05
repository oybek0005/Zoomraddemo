package uz.oybek0005.zoomraddemo.presentation.screen.auth.language

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.oybek0005.zoomraddemo.R
import uz.oybek0005.zoomraddemo.databinding.ScreenLanguageBinding
import uz.oybek0005.zoomraddemo.utils.LocationHelperLanguage


/**
Created by Oybek 6:03 PM 12/4/2024
 */

@AndroidEntryPoint
class ScreenLanguage:Fragment(R.layout.screen_language) {
    private val viewModel: LanguageContract.LanguageViewModel by viewModels<LanguageScreenViewModel>()
    private val binding:ScreenLanguageBinding by viewBinding(ScreenLanguageBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btnUzbek.setOnClickListener {
            LocationHelperLanguage.setLocation(requireContext(),"uz")
            viewModel.clickNextScreen()
        }

        binding.btnRus.setOnClickListener {
            LocationHelperLanguage.setLocation(requireContext(),"ru")
            viewModel.clickNextScreen()
        }

        binding.btnEnglish.setOnClickListener {
            LocationHelperLanguage.setLocation(requireContext(),"en")
            viewModel.clickNextScreen()
        }
    }
}