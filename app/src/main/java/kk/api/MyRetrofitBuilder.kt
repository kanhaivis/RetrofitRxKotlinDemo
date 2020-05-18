package ns.api

import ns.api.OkHttpSupport.getUnsafeOkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

object MyRetrofitBuilder {

    const val BASE_URL ="Here put base url"

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ApiWorker.gsonConverter)
            .client(getUnsafeOkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }


    val apiServers: ApiInterface by lazy {
        retrofitBuilder
            .build()
            .create(ApiInterface::class.java)
    }
}