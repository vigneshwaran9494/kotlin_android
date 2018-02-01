package obs.com.kotlinbaseapp.models

/**
 * Created by vigneshwaran.n on 31-01-2018.
 */
class JsonResponse {
    var url: String? = null
    var method: String? = null
    var strRequest: String? = null
    var strResponse: String? = null
    var responseCode: Int = 0
    var requestCode: Int = 0
    var errorMsg: String? = null
    var requestData: String? = null
    var isOnline: Boolean = false

    fun clearAll() {
        this.url = ""
        this.method = ""
        this.errorMsg = ""
        this.strRequest = ""
        this.strResponse = ""
        this.requestData = ""
        this.requestCode = 0
        this.responseCode = 0
        this.isOnline = false
    }
}