@file:Suppress("DEPRECATION")

package kk.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionDetector {

    companion object {

        fun isConnectingToInternet(context: Context): Boolean {

            val connectivity =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val info = connectivity.allNetworkInfo
            for (i in info) {

                if (i.state == NetworkInfo.State.CONNECTED) {
                    return true
                }

            }
            return false
        }
    }
}