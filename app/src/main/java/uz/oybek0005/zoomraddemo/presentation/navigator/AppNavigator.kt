package uz.oybek0005.zoomraddemo.presentation.navigator



interface AppNavigator {
    suspend fun navigateTo(id: Int)
    suspend fun back()
}