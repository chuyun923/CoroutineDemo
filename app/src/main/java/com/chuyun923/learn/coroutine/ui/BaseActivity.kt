package com.chuyun923.learn.coroutine.ui

import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(), CoroutineScope {

    val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + SupervisorJob() + errorHandler

    protected open fun onError(throwable: Throwable) {

    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineContext.cancel()
    }
}