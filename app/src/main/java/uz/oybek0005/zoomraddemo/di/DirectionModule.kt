package uz.oybek0005.zoomraddemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.oybek0005.zoomraddemo.presentation.screen.auth.language.LanguageContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.language.LanguageDirection
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterContract
import uz.oybek0005.zoomraddemo.presentation.screen.auth.register.RegisterDirection

@Module
@InstallIn(ViewModelComponent::class)
interface DirectionModule {

    @Binds
    fun bindLoginDirection(impl: LanguageDirection) : LanguageContract.Direction

    @Binds
    fun bindVerifyCodeDirection(impl: RegisterDirection):RegisterContract.Directions
}



