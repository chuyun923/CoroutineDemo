package com.chuyun923.learn.coroutine.demos

import com.chuyun923.learn.coroutine.coroutineLog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

class MyContinuationInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) =
        MyContinuation(continuation)
}

class MyContinuation<T>(val continuation: Continuation<T>) : Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
//        coroutineLog("<MyContinuation> $result")
        continuation.resumeWith(result)
    }
}

suspend fun testCPS() {
    coroutineLog("testCPS")
    testCPS1()
    testCPS2()
}

suspend fun testCPS1() {
    coroutineLog("testCPS1")
}

suspend fun testCPS2() {
    coroutineLog("testCPS2")
}

class TestInterceptor : Runnable {
    override fun run() {

        GlobalScope.async {
            coroutineLog("first")
        }

        GlobalScope.async {
            coroutineLog("sencond")

            async {
                coroutineLog("thrid")

            }
        }




        GlobalScope.launch(MyContinuationInterceptor()) {
            coroutineLog("abcdd")
            val job = async {
                coroutineLog(2)
                delay(1000)
                coroutineLog(3)
                "Hello"
            }
            coroutineLog(4)
            val result = job.await()
            coroutineLog("5. $result")
        }

//        coroutineLog(6)
    }


}