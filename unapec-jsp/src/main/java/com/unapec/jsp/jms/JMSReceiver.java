package com.unapec.jsp.jms;

import java.io.IOException;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

@WebServlet(name = "ReceiveMessageServlet", urlPatterns = "/receiveJMS.do")
public class JMSReceiver extends HttpServlet {
    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageConsumer consumer = null;
    // http://www.coderpanda.com/jms-example-using-apache-activemq/
    
    protected void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(
//				request, response);
            receiveMessages(response);
    }
        
    private void writeRepsonse(HttpServletResponse httpServletResponse, String text) throws IOException {
            httpServletResponse.setContentType("text/plain");
            if (!empty(text)) {
                    httpServletResponse.getWriter().write(String.format("Received message with text '%s'.", text));
            } else {
                    httpServletResponse.getWriter().write("Received no message.");
            }
    }
        
    private void receiveMessages(HttpServletResponse response) throws IOException {
        try {
            factory = new ActiveMQConnectionFactory(
            ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("CONECTIONEST");
            consumer = session.createConsumer(destination);
            Message message = consumer.receive();

            if (message instanceof TextMessage) {
                TextMessage text = (TextMessage) message;
                writeRepsonse(response, text.getText());
            }
            connection.close();
            connection.stop();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean empty( final String s ) {
        // Null-safe, short-circuit evaluation.
        return s == null || s.trim().isEmpty();
    }
}