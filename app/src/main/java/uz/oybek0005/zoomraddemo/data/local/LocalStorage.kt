package uz.oybek0005.zoomraddemo.data.local

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import uz.oybek0005.zoomraddemo.utils.SharedPreference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalStorage @Inject constructor(@ApplicationContext context: Context) : SharedPreference(context) {
    var token: String by Strings()
    var refreshToken:String by Strings()
    var accessToken:String by Strings()
}


