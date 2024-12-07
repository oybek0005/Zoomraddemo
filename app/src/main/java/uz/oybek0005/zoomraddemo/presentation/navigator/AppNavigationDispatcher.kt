package uz.oybek0005.zoomraddemo.presentation.navigator

import androidx.navigation.NavDirections
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppNavigationDispatcher @Inject constructor(): AppNavigator, AppNavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args: NavigationArgs) {
        navigationStack.emit(args)
    }

    override suspend fun navigateTo(dir: NavDirections) {
        navigationStack.emit { navigate(dir) }
    }
    override suspend fun navigateTo(id: Int) = navigate {
        navigate(id)
    }

    override suspend fun back() = navigate {
        navigateUp()
    }
}