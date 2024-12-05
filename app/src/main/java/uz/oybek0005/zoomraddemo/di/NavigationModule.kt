package uz.oybek0005.zoomraddemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.oybek0005.zoomraddemo.domain.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.auth.impl.AuthRepositoryImpl
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigationDispatcher
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigationHandler
import uz.oybek0005.zoomraddemo.presentation.navigator.AppNavigator

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindAppNavigator(dispatcher: AppNavigationDispatcher): AppNavigator

    @Binds
    fun bindAppNavigationHandler(dispatcher: AppNavigationDispatcher): AppNavigationHandler


}