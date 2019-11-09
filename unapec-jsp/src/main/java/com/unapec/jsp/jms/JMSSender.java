package com.unapec.jsp.jms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

@WebServlet(name = "SendMessageServlet", urlPatterns = "/sendJMS.do")
public class JMSSender extends HttpServlet {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;
    // http://www.coderpanda.com/jms-example-using-apache-activemq/

    protected void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(
//				request, response);

        String parameter = getTextParameter(request);
//        String parameter = "Hello ...This is a sample message..sending from FirstClient";
        sendMessage(parameter);
        writeResponse(response, parameter);
//        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(
//                        request, response);
    }

    public void sendMessage(String param) {
        try {
            factory = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("CONECTIONEST");
            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText(param);
            producer.send(message);
            System.out.println("Sent: " + message.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void writeResponse(HttpServletResponse httpServletResponse,
                    String parameter) throws IOException {
        httpServletResponse.setContentType("text/plain");
        httpServletResponse.getWriter().write(String.format("Sent message with content '%s'.", parameter));
    }

    private String getTextParameter(HttpServletRequest httpServletRequest) {
            String parameter = httpServletRequest.getParameter("text");
    if(empty(parameter)) {
            parameter = (new Date()).toString();
    }
            return parameter;
    }

//    private void sendMessage(String text) {
//        try {
//            InitialContext initCtx = new InitialContext();
//            Context envContext = (Context) initCtx.lookup("java:comp/env");
//            ConnectionFactory connectionFactory = (ConnectionFactory) envContext.lookup("jms/ConnectionFactory");
//            Connection connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            Destination destination = session.createTopic("jms/topic/MyTopic");
//            MessageProducer producer = session.createProducer(destination);
////            TextMessage msg=session.createTextMessage();
////            msg.setText("Message sent");
////            producer.send(msg);
//            
////            InitialContext initCtx = new InitialContext();
////            ConnectionFactory connectionFactory = (ConnectionFactory) initCtx.lookup("java:comp/env/jms/ConnectionFactory");
////            Connection connection = connectionFactory.createConnection();
////            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
////            MessageProducer producer = session.createProducer((Destination) initCtx.lookup("java:comp/env/jms/queue/MyQueue"));
//
//            TextMessage testMessage = session.createTextMessage();
//            testMessage.setText(text);
//            testMessage.setStringProperty("aKey", "someRandomTestValue");
//            producer.send(testMessage);
//            System.out.println("Successfully sent message.");
//        } catch (Exception e) {
//            System.out.println("Sending JMS message failed: "+e.getMessage());
//        }
//    }
    
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
      }
}