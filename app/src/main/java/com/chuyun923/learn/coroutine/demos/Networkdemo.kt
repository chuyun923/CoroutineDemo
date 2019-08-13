package com.chuyun923.learn.coroutine.demos

import android.widget.Toast
import com.chuyun923.learn.coroutine.DemoApplication
import com.chuyun923.learn.coroutine.net.NetApi
import com.chuyun923.learn.coroutine.net.NetUtils.retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Networkdemo : Runnable {
    override fun run() {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(DemoApplication.app, getBaiduIndexHtml(), Toast.LENGTH_LONG).show()
        }
    }
}

suspend fun getBaiduIndexHtml(): String {
    return retrofit.create(NetApi::class.java).getIndex().await().string()
}
