/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver.rmi_service;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author virt001
 */
public class GeneratorServer {
    // https://edwin.baculsoft.com/2012/01/a-simple-java-rmi-tutorial/
    // http://www.ejbtutorial.com/java-rmi/a-step-by-step-implementation-tutorial-for-java-rmi
    Generator c;
    
    public GeneratorServer() throws RemoteException {
//            try {
//                Naming.rebind("//localhost//GeneratorService", c);
//            } catch (Exception e) {
//                System.out.println("Trouble: " + e);
//            }
        c = new GeneratorImpl();
        try {
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // create a new service named myMessage
            registry.rebind("myGenerator", c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("system is ready");
    }
    
    public void debugger() throws RemoteException {
        c.generateMessage();
    } 
}
