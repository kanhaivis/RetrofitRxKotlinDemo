package ns.api

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


object RepositoryServer {

    fun getTestApi(callback: RequestCallback<JsonElement>, serverRequest: ServerRequest):  Disposable?{

        return  MyRetrofitBuilder.apiServers.getTestApi(serverRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                var code = it.code()
                if (code == 200) {
                    callback.onNext(it.body()!!)
                }
                if (code == 400) {
                    val msg = it.errorBody()!!.string()
                    val convertedObject = Gson().fromJson(msg, JsonObject::class.java)
                    callback.onError(convertedObject.toString())
                }
                if (code == 401) {
                    val msg = it.errorBody()!!.string()
                    val convertedObject = Gson().fromJson(msg, JsonObject::class.java)
                    callback.onError(convertedObject.toString())
                }
                if (code == 500) {
                    val msg = it.errorBody()!!.string()
                    val convertedObject = Gson().fromJson(msg, JsonObject::class.java)
                    callback.onError(convertedObject.toString())
                }
            }
    }
}