package com.unapec.jsp.account.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.unapec.jsp.core.DBManager;

import com.unapec.jsp.core.Config;
import com.unapec.jsp.webservice.WebServiceServer;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

// http://www.thejavageek.com/2015/01/27/web-service-hello-world-example-explained/
/*

 // Method descriptor #15 ()V
 public void init() throws javax.servlet.ServletException;

 // Method descriptor #37 (Ljavax/servlet/ServletRequest;Ljavax/servlet/ServletResponse;)V
 public void service(javax.servlet.ServletRequest arg0, javax.servlet.ServletResponse arg1) throws javax.servlet.ServletException, java.io.IOException;

 // Method descriptor #15 ()V
 public void destroy();

 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private DBManager userValidationService = new DBManager();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
                if(request.getSession().getAttribute("name") != null) {
                    response.sendRedirect(Config.SITE_URL + "list-todos.do");
                    return;
                }
                
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

                try {
                    //boolean isUserValid = userValidationService.isUserValid(name, password);
                    userValidationService.setup();
                } catch (NamingException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                boolean isUserValid = userValidationService.isUserValid(name, password);
                
		if (isUserValid) {
			request.getSession().setAttribute("name", name);
			response.sendRedirect(Config.SITE_URL + "list-todos.do");
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
					request, response);
		}
	}

}