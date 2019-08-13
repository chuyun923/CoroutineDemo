//package com.chuyun923.learn.coroutine;
//
//import android.util.Log;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//
//@Aspect
//public class SysTrace {
//
//    private static final String TAG = "aaaaaaa";
//
//    @Pointcut("execution(* *(..)) && within(com..*) ")
//    public void callConstructor() {
//    }
//
//    @Before("callConstructor()")
//    public void beforeConstructorCall(JoinPoint joinPoint) {
//        Log.e(TAG, " before->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
//    }
//
//    /**
//     * 执行（构造函数被调用）JPoint之后
//     *
//     * @param joinPoint
//     */
//    @After("callConstructor()")
//    public void afterConstructorCall(JoinPoint joinPoint) {
//        Log.e(TAG, " after->" + joinPoint.getThis().toString() + "#" + joinPoint.getSignature().getName());
//    }
//}
