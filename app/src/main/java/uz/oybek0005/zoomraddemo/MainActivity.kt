package uz.oybek0005.zoomraddemo

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigationHandler
import uz.oybek0005.zoomraddemo.utils.LocationHelperLanguage
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var appNavigationHandler: AppNavigationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mainView = findViewById<FragmentContainerView>(R.id.main_view)
        val navHostFragment = mainView.getFragment<NavHostFragment>()
        val navController = navHostFragment.navController

        appNavigationHandler.navigationStack
            .onEach { it(navController) }
            .launchIn(lifecycleScope)
    }
    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocationHelperLanguage.attach(newBase))
    }
}