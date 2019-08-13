package com.chuyun923.learn.coroutine.net

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import retrofit2.http.GET
import java.io.IOException
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

interface NetApi {

    @GET("index")
    fun getIndex(): Deferred<ResponseBody>

}

suspend fun getBaiduIndex(): String {
    delay(2000)
    val r = Request.Builder().url("https://www.baidu.com/index").build()
    var c = NetUtils.unsafeOkHttpClient.newCall(r)
    return c.awaitCallable()
}

suspend fun Call.awaitCallable() : String {
    return suspendCancellableCoroutine {

        enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                it.resumeWithException(e)
            }

            override fun onResponse(call: Call, response: Response) {
                if(response.isSuccessful) {
                    it.resume(response.body()!!.string())
                }else {
                    it.resumeWithException(object : RuntimeException(response.request().url().toString()){})
                }
            }

        })

        it.invokeOnCancellation {
            cancel()
        }
    }
}

