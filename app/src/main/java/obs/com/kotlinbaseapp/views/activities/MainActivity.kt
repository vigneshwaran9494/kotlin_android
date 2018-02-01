package obs.com.kotlinbaseapp.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import obs.com.kotlinbaseapp.BaseApp
import obs.com.kotlinbaseapp.R
import obs.com.kotlinbaseapp.api.ApiService
import obs.com.kotlinbaseapp.interfaces.ServiceListener
import obs.com.kotlinbaseapp.models.JsonResponse
import obs.com.kotlinbaseapp.utills.RequestCallback
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ServiceListener {

    @Inject lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseApp.app.inject(this);

        apiService.getNotesDetail().enqueue(RequestCallback(this))
    }

    override fun onSuccess(jsonResp: JsonResponse, data: String) {
        Log.d("", "")
    }

    override fun onFailure(jsonResp: JsonResponse, data: String) {
        Log.d("", "")
    }
}
