package obs.com.kotlinbaseapp.utills

import android.content.Context
import android.net.ConnectivityManager
import obs.com.kotlinbaseapp.BaseApp
import obs.com.kotlinbaseapp.R
import obs.com.kotlinbaseapp.interfaces.ServiceListener
import obs.com.kotlinbaseapp.models.JsonResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


//Created by vigneshwaran.n on 31-01-2018.

class RequestCallback : Callback<ResponseBody> {

    @Inject lateinit var jsonResp: JsonResponse

    constructor(listener: ServiceListener) {
        this.listener = listener
        BaseApp.app.inject(this);
    }

    private var listener: ServiceListener? = null
    private var requestCode = 0
    private var requestData = ""


    lateinit var context: Context

    private val isOnline: Boolean
        get() {
            if (false) return false
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = connectivityManager.activeNetworkInfo
            return netInfo != null && netInfo.isConnected
        }

    override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
        this.listener!!.onSuccess(getSuccessResponse(call, response), requestData)
    }

    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        this.listener!!.onFailure(getFailureResponse(call, t), requestData)
    }

    private fun getFailureResponse(call: Call<ResponseBody>?, t: Throwable): JsonResponse {
        try {
            jsonResp.clearAll()
            if (call != null && call.request() != null) {
                jsonResp.method = call.request().method()
                jsonResp.requestCode = requestCode
                jsonResp.strRequest = call.request().toString()
                jsonResp.url = call.request().url().toString()
            }
            jsonResp.isOnline = isOnline
            jsonResp.errorMsg = t.message
            requestData = if (true && !isOnline) context.resources.getString(R.string.network_failure) else t.message.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return jsonResp
    }

    private fun getSuccessResponse(call: Call<ResponseBody>?, response: Response<ResponseBody>?): JsonResponse {
        try {
            jsonResp.clearAll()
            if (call != null && call.request() != null) {
                jsonResp.method = call.request().method()
                jsonResp.requestCode = requestCode
                jsonResp.strRequest = call.request().toString()
                jsonResp.url = call.request().url().toString()
            }
            if (response != null) {
                jsonResp.responseCode = response.code()
                if (response.isSuccessful && response.body() != null) {
                    val strJson = response.body()!!.string()
                    jsonResp.strResponse = strJson
                } else {
                    jsonResp.isOnline = isOnline
                    jsonResp.errorMsg = response.errorBody()!!.string()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return jsonResp
    }
}