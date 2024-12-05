package uz.oybek0005.zoomraddemo.presentation.navigator

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppNavigationDispatcher @Inject constructor(): AppNavigator, AppNavigationHandler {
    override val navigationStack = MutableSharedFlow<NavigationArgs>()

    private suspend fun navigate(args: NavigationArgs) {
        navigationStack.emit(args)
    }

    override suspend fun navigateTo(id: Int) = navigate {
        navigate(id)
    }

    override suspend fun back() = navigate {
        navigateUp()
    }
}