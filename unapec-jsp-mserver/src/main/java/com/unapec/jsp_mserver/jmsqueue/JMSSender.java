/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver.jmsqueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author virt001
 */
public class JMSSender {
    
    // http://idanfridman.com/2011/12/19/using-jms-in-tomcat/
    // https://howtodoinjava.com/jms/jms-java-message-service-tutorial/
    // https://javatpoint.com/jms-tutorial
    // http://www.jtech.ua.es/j2ee/publico/mens-2010-11/sesion01-apuntes.html
    // https://www.youtube.com/watch?v=QGrrEZ0j7QY
//    public void JMSServer() throws Exception {
//        BrokerService broker = new BrokerService();
//        // configure the broker
//        broker.addConnector("tcp://localhost:61616");
//        broker.start();
//        //use broker.stop() to stop the service.
//    }

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;

    public void sendMessage() {
        try {
            factory = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("SAMPLEQUEUE");
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText("Hello ...This is a sample message..sending from FirstClient");
            producer.send(message);
            System.out.println("Sent: " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}