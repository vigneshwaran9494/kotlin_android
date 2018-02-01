package obs.com.kotlinbaseapp.interfaces

import obs.com.kotlinbaseapp.models.JsonResponse


/**
 * Created by vigneshwaran.n on 31-01-2018.
 */
interface ServiceListener {
    fun onSuccess(jsonResp: JsonResponse, data: String)

    fun onFailure(jsonResp: JsonResponse, data: String)
}