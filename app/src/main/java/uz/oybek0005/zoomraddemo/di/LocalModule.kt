package uz.oybek0005.zoomraddemo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.oybek0005.zoomraddemo.utils.SharedPreference
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

//    @[Provides Singleton]
//    fun providesLocalStorage(@ApplicationContext context: Context) = SharedPreference(context)

}