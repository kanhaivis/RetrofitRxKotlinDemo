package ns.api

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.POST
import com.google.gson.JsonElement


interface ApiInterface {

    @POST("")
    fun getTestApi(
        @Body serverRequest: ServerRequest
    ): Observable<Response<JsonElement>>
}