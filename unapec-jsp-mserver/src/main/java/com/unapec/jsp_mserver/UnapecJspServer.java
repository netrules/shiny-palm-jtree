/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver;

//import javax.xml.ws.Endpoint;

//import com.unapec.jsp_mserver.jdni.JndiServer;
//import com.unapec.jsp_mserver.jmsqueue.JMSReceiver;
//import com.unapec.jsp_mserver.jmsqueue.JMSSender;
//import javax.jms.JMSException;
//import org.apache.activemq.broker.BrokerService;
//import com.unapec.corba.mserver.RecoServer;
import com.unapec.jsp_mserver.rmi_service.GeneratorServer;
import java.rmi.RemoteException;
import java.util.Properties;

import HelloApp.*;
import com.unapec.jsp_mserver.webservices.WebServiceImpl;
import javax.xml.ws.Endpoint;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

/**
 *
 * @author net
 */
public class UnapecJspServer {
    public static Hello helloImpl;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {

        //////////////////////////////////////
        //////////////////////////////////////
        // ORB Startup
      try{
        // create and initialize the ORB
        ORB orb = ORB.init(args, null);

        // get the root naming context
        org.omg.CORBA.Object objRef = 
            orb.resolve_initial_references("NameService");
        // Use NamingContextExt instead of NamingContext. This is 
        // part of the Interoperable naming Service.  
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
 
        // resolve the Object Reference in Naming
        String name = "Hello";
        helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtained a handle on server object: " + helloImpl);
//        System.out.println(helloImpl.sayHello());
//        helloImpl.shutdown();

        } catch (Exception e) {
          System.out.println("ERROR : " + e) ;
          e.printStackTrace(System.out);
          }

        //////////////////////////////////////
        //////////////////////////////////////
        // WebService
        System.out.println("Beginning to publish WebService now");
        Endpoint.publish("http://127.0.0.1:9876/ws", new WebServiceImpl());
        System.out.println("Done publishing");
        
        //////////////////////////////////////
        //////////////////////////////////////
        // JNDI Server (GlassFish Usability?)
//      JndiServer.startServer();
//      JndiServer.storeSomeData(); 
//      System.out.println("Ready");
//        BrokerService broker = new BrokerService();
//        // configure the broker
//        broker.addConnector("tcp://localhost:61616");
//        broker.start();

        //////////////////////////////////////
        //////////////////////////////////////
        // JMS Service (makes a list of retrieve/send-able things)
//        JMSSender rec=new JMSSender();
//        JMSReceiver receiver = new JMSReceiver();
////        rec.sendMessage();
//        receiver.receiveMessage();

        //////////////////////////////////////
        //////////////////////////////////////
        // RMI Server (using Registry socket)
        GeneratorServer gener8 = new GeneratorServer();
        //RecoServer grav8 = new RecoServer(args);
        // gener8.debugger();
    }
    
}