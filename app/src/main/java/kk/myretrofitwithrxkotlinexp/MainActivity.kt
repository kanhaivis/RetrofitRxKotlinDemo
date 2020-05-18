package kk.myretrofitwithrxkotlinexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.JsonElement
import kk.api.ConnectionDetector
import ns.api.RepositoryServer
import ns.api.RequestCallback
import ns.api.ServerRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ConnectionDetector.isConnectingToInternet(this)) {

            onTestApiCall()
        } else {
            Toast.makeText(this@MainActivity, "", Toast.LENGTH_LONG).show()
        }
    }

    private fun onTestApiCall() {
        var serverRequest = ServerRequest.Builder().userId("").build()

        var callbackList = object : RequestCallback<JsonElement> {
            override fun onNext(response: JsonElement) {
            // get server response
            }

            override fun onError(error: String) {
               Toast.makeText(this@MainActivity, "", Toast.LENGTH_LONG).show()
            }

            override fun onComplete(str: String) {

            }
        }
        RepositoryServer.getTestApi(callbackList, serverRequest)
    }
}
