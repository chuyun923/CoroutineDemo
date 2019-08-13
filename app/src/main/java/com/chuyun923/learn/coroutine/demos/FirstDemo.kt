package com.chuyun923.learn.coroutine.demos

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import com.chuyun923.learn.coroutine.DemoApplication
import com.chuyun923.learn.coroutine.FirstDemoActivity


class FirstDemo : Runnable {
    override fun run() {
        val intent = Intent(DemoApplication.app, FirstDemoActivity::class.java)
        intent.addFlags(FLAG_ACTIVITY_NEW_TASK)
        DemoApplication.app.startActivity(intent)
    }
}
