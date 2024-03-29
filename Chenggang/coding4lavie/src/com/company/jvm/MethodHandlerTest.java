package com.company.jvm;

import com.sun.tools.doclets.internal.toolkit.util.MethodTypes;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlerTest {
    static class ClassA {
        public void println(String s){
            System.out.println(s + " voila");
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invoke("this is a test");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
