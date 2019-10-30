/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp.core;

import com.unapec_jsp.jni.CustomClassLoader;
import com.unapec_jsp.jni.HelloWorldJNI;
import com.unapec_jsp.jni.InterfaceHelloWorldJNI;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 20162032
 */
public class AccountInfo implements java.io.Serializable {
    	private String username = null;
	private String password = null;

	public String getUsername() {
		return username;
	}

	public void setUsername(String _username) {
		username = _username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		password = _password;
	}
        
        @Override
        public String toString() {
            String hrprde = "somebody";
//            try {
//                // https://web.archive.org/web/20140704120535/http://www.codethesis.com/blog/unload-java-jni-dll
// 
//                CustomClassLoader cl = new CustomClassLoader();
//                Class ca = cl.findClass("com.unapec_jsp.jni.HelloWorldJNI");
//                InterfaceHelloWorldJNI ia = (InterfaceHelloWorldJNI)ca.newInstance();
//                hrprde = ia.sayHelloToMe(username, false);
//                ca = null;
//                ia = null;
//                cl = null;
//                System.gc();


//            return "hello and welcome, " + username;
//return WebServiceConnection.greetMessage(username);
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
//            }   catch (InstantiationException ex) {
//                    Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IllegalAccessException ex) {
//                Logger.getLogger(AccountInfo.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            HelloWorldJNI hdni = new HelloWorldJNI();
//            hrprde = hdni.sayHelloToMe(username, false);
//            hdni = null;
            return "hello and welcome, " + username;
        }
}
