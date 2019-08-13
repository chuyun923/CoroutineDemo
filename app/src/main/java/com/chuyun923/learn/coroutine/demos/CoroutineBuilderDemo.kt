package com.chuyun923.learn.coroutine.demos

import com.chuyun923.learn.coroutine.FastMain
import com.chuyun923.learn.coroutine.coroutineLog
import kotlinx.coroutines.*
import java.lang.Runnable
import java.lang.RuntimeException

class CoroutineBuilderDemo : Runnable {

//    val errorHander = CoroutineExceptionHandler { _, t ->
//        println("errorhandler:"+t.message)
//    }

    override fun run() {
        val start = System.currentTimeMillis()
        println(start)
        GlobalScope.launch(FastMain) {
//            runBlocking {
//                coroutineLog("runBlocking1 start")
//                delay(500)
//                isActive
//                coroutineLog("runBlocking1 end")
//            }

//            val defer = async {
//                coroutineLog("async start")
//                delay(600)
//                coroutineLog("async end")
//            }

//            launch(FastMain) {
//                coroutineLog("launch start")
////                delay(600)
//                coroutineLog("launch end")
//
////                throw RuntimeException("TEST ")
//            }

//            runBlocking(Dispatchers.IO) {
//                coroutineLog("runBlocking2 start")
//                delay(700)
//                coroutineLog("runBlocking2 end")
//            }
            coroutineLog(">>>>>> end")
//            defer.await()
        }

        println(System.currentTimeMillis()-start)

    }
}
