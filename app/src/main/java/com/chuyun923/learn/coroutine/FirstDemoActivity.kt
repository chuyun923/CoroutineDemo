package com.chuyun923.learn.coroutine

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.chuyun923.learn.coroutine.net.getBaiduIndex
import com.chuyun923.learn.coroutine.ui.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class FirstDemoActivity : BaseActivity(), View.OnClickListener {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_demo)
        textView = findViewById<TextView>(R.id.text)
        textView.setOnClickListener(this)
        launch {
            textView.text = "im loading"
            val result = getBaiduIndex()
            textView.text = result
        }
    }

    override fun onClick(v: View?) {
        launch {
            textView.text = "im loading"
            delay(500)
            throw RuntimeException("Erroooooor!")
        }
    }

    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        textView.text = throwable.message
    }
}