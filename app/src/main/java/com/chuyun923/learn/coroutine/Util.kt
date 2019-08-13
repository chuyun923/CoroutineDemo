package com.chuyun923.learn.coroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import java.lang.StringBuilder
import kotlin.coroutines.coroutineContext

suspend inline fun Job.Key.currentJob(): Job? {
    return coroutineContext[Job]
}

suspend fun coroutineLog(msg: Any) {
    val stringBuilder = StringBuilder()
    stringBuilder.append("【" + msg + "】------|")
    coroutineContext[CoroutineName]?.let {
        stringBuilder.append("cName:  " + it.name + ";")
    }
    stringBuilder.append("tName:  " + Thread.currentThread().name)
    println(stringBuilder.toString())
}
