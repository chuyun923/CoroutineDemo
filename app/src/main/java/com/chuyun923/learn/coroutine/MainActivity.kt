package com.chuyun923.learn.coroutine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.lang.Runnable

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {

        v?.let {
            when (it) {
                is TextView -> dosomething(it.text.toString())
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ll = findViewById<ViewGroup>(R.id.container_ll)

        for (i in 0 until ll.childCount) {
            ll.getChildAt(i).setOnClickListener(this)
        }

    }


    fun dosomething(taskName: String) {
        val t = Class.forName("com.chuyun923.learn.coroutine.demos." + taskName).newInstance() as Runnable
        t.run()
    }
}
