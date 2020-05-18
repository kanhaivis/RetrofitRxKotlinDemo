package ns.api

import android.content.Context
import okhttp3.*
import java.io.IOException
import java.security.AccessControlContext

class SupportInterceptor : Interceptor/*, Authenticator*/ {

//    val context = g

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("Content-Type", "application/json")
            ?.addHeader("Accept", "application/json")
            ?.build()
        return chain.proceed(request)
    }

    /**
     * Authenticator for when the authToken need to be refresh and updated
     * everytime we get a 401 error code
     */
  /*  @Throws(IOException::class)
    override fun authenticate (route: Route?, response: Response?): Request? {

        val auth_token =
            MyPrefrence(context).getTokenType() + " " + MyPrefrence(context).getAccressToken()
        var requestAvailable: Request? = null
        try {
            requestAvailable = response?.request()?.newBuilder()
                ?.addHeader("Authorization", "$auth_token")
                ?.build()
            return requestAvailable
        } catch (ex: Exception) { }
        return requestAvailable
    }
*/
}
