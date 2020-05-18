package ns.api

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiWorker {
    private var mClient: OkHttpClient? = null
    private var mGsonConverter: GsonConverterFactory? = null


    /**
     * Don't forget to remove Interceptors (or change Logging Level to NONE)
     * in production! Otherwise people will be able to see your request and response on Log Cat.
     */
    val client: OkHttpClient
    get(){

        if (mClient == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpBuilder = OkHttpClient.Builder()
            httpBuilder.connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            mClient = httpBuilder.build()

        }

        return mClient!!
    }

    val gsonConverter : GsonConverterFactory
    get() {

        if (mGsonConverter == null) {
            mGsonConverter = GsonConverterFactory.create(
                GsonBuilder().setLenient().disableHtmlEscaping().create()
            )
        }
        return mGsonConverter!!
    }
}