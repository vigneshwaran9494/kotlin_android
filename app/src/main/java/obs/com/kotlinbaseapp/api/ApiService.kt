package obs.com.kotlinbaseapp.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET


//Created by vigneshwaran.n on 31-01-2018.

interface ApiService {

    @GET("ip")
    fun getNotesDetail(): Call<ResponseBody>

}