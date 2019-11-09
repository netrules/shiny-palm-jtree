/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec_jsp.jni;

/**
 *
 * @author virt001
 */
public class HelloWorldJNI implements InterfaceHelloWorldJNI {
    static {
        System.loadLibrary("native");
    }
    
    // Declare a native method sayHello() that receives no arguments and returns void
    public native long sumIntegers(int first, int second);
    public native String sayHelloToMe(String name, boolean isFemale);

    public void finalize() {
        System.out.println("A garbage collected");
    }
}
