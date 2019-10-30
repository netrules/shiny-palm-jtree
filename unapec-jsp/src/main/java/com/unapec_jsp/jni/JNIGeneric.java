package com.unapec_jsp.jni;

import java.io.IOException;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

@WebServlet(name = "JNIGenericService", urlPatterns = "/genericJNI.do")
public class JNIGeneric extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                    HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(
//				request, response);
        String myName = "EgName";
        response.setContentType("text/plain");
        response.getWriter().write(new HelloWorldJNI().sayHelloToMe(myName, false));
    }
}