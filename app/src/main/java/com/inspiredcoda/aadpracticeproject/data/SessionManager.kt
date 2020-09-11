package com.inspiredcoda.aadpracticeproject.data

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.inspiredcoda.aadpracticeproject.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class SessionManager(
    val applicationContext: Context
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (isInternetAvailable()){
            throw NoInternetException("Please turn on your Internet Connection")
        }
       return chain.proceed(chain.request())
    }


    private fun isInternetAvailable(): Boolean{
        var result = false
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        connectivityManager?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                it.getNetworkCapabilities(connectivityManager.activeNetwork)?.apply {
                    result = when {
                        hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        else -> false
                    }
                }
            } else {
                TODO("VERSION.SDK_INT < M")
            }
        }
        return result
    }


}