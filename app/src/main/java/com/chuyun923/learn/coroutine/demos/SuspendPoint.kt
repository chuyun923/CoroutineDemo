package com.chuyun923.learn.coroutine.demos

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

/**
 * 挂起点
 */
class SuspendPoint : Runnable {

    override fun run() {

        GlobalScope.launch(PrintPointInterceptor()) {
            level1_1()
            level1_2()
            level1_3()
        }
    }

    suspend fun level1_1() {
        println("start level11")
        delay(50)
        println("end level11")

    }

    suspend fun level1_2() {
        println("start level12")
        delay(50)
        println("end level12")

    }

    suspend fun level1_3() {
        println("start level13")
        delay(50)
        println("end level13")
    }

}

class PrintPointInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) =
        PrintPointContinuation(continuation)
}

class PrintPointContinuation<T>(val continuation: Continuation<T>) : Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
//        coroutineLog("<PrintPoint> $result")
        continuation.resumeWith(result)
    }
}