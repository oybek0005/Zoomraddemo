package uz.jalolov.contactauthretrofit.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url
import uz.oybek0005.zoomraddemo.data.remote.api.AuthApi
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @[Provides Singleton]
    fun provideOkHttp(@ApplicationContext context: Context):OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(ChuckerInterceptor(context))
        .build()

    @[Provides Singleton]
    fun provideApiClient(okHttpClient: OkHttpClient):Retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.140/mobile-bank/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @[Provides Singleton]
    fun provideContactApi(retrofit: Retrofit):AuthApi = retrofit.create(AuthApi::class.java)



}