package uz.oybek0005.zoomraddemo.presentation.navigator

import androidx.navigation.NavDirections


interface AppNavigator {
    suspend fun navigateTo(id: Int)
    suspend fun navigateTo(dir: NavDirections)
    suspend fun back()
}