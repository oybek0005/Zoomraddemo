package uz.oybek0005.zoomraddemo.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.oybek0005.zoomraddemo.domain.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.auth.impl.AuthRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl) : AuthRepository


}