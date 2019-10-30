/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver.jdni;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jnp.server.Main;
import org.jnp.server.NamingBeanImpl;
/**
 *
 * @author virt001
 */
public class JndiServer {
    
   public static void storeSomeData() throws NamingException {
      Hashtable<String, String> env = new Hashtable<String, String>();
      env.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
      env.put(Context.PROVIDER_URL,            "jnp://localhost:3306");
      Context context = new InitialContext(env);
      context.createSubcontext("config");
      context.bind("/config/applicationName", "MyApp");
      context.bind("/config/clase", new SomeData("pedro",4,new Date()));
   }

   public static void startServer() throws Exception, UnknownHostException {
      System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");

      NamingBeanImpl jnpServer = new NamingBeanImpl();
      jnpServer.start();
      
      Main main = new Main();
      main.setNamingInfo(jnpServer);
      main.setPort(5400);
      main.setBindAddress(InetAddress.getLocalHost().getHostName());
      main.start();
   }

}
