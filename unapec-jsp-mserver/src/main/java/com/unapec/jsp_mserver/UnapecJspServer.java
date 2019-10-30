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
import com.unapec.corba.mserver.RecoServer;
import com.unapec.jsp_mserver.rmi_service.GeneratorServer;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 *
 * @author net
 */
public class UnapecJspServer {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        Properties properties = System.getProperties();
        properties.put( "org.omg.CORBA.ORBInitialHost",
            "localhost" );
        properties.put( "org.omg.CORBA.ORBInitialPort",
            "3700" );
        properties.put( "com.sun.CORBA.POA.ORBPersistentServerPort",
                Integer.toString(3700) );

        // TODO code application logic here
//        System.out.println("Beginning to publish WebService now");
//        Endpoint.publish("http://127.0.0.1:9876/ws", new WebServiceImpl());
//        System.out.println("Done publishing");
//      JndiServer.startServer();
//      JndiServer.storeSomeData(); 
//      System.out.println("Ready");
//        BrokerService broker = new BrokerService();
//        // configure the broker
//        broker.addConnector("tcp://localhost:61616");
//        broker.start();

//        JMSSender rec=new JMSSender();
//        JMSReceiver receiver = new JMSReceiver();
////        rec.sendMessage();
//        receiver.receiveMessage();
        GeneratorServer gener8 = new GeneratorServer();
        //RecoServer grav8 = new RecoServer(args);
        // gener8.debugger();
    }
    
}