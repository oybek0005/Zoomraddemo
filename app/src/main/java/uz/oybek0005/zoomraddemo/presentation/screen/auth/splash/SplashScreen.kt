package uz.oybek0005.zoomraddemo.presentation.screen.auth.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.oybek0005.zoomraddemo.R
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.screen_splash) {

    @Inject
    lateinit var direction: SplashDirection
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
             lifecycleScope.launch {
                 delay(1600)
                 direction.moveToFinishScreen()
              }
            }
}
