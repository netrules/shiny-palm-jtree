package com.unapec.jsp.account.login;

import com.unapec.jsp.core.DBManager;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.unapec.jsp.core.Config;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

	private DBManager userValidationService = new DBManager();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("name") != null) {
                    response.sendRedirect(Config.SITE_URL + "list-todos.do");
                    return;
                }
                
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String password_repeat = request.getParameter("password2");

                if(!password.equals(password_repeat)) {
                    request.setAttribute("errorMessage", "The passwords must match!");
                    request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(
                                    request, response);
                    return;
                }
                
                
                DBManager userValidationService = new DBManager();
                try {
                    //boolean isUserValid = userValidationService.isUserValid(name, password);
                    userValidationService.setup();
                } catch (NamingException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
		int isUserValid = userValidationService.doMakeUser(name, password); 
                        //userValidationService.isUserValid(name, password);

		if (isUserValid==2) {
                    request.getSession().setAttribute("name", name);
                    response.sendRedirect(Config.SITE_URL + "list-todos.do");
		} else {
                    if(isUserValid==0) {
                        request.setAttribute("errorMessage", "Fail: could not create account, try again.");
                    } else {
                        request.setAttribute("errorMessage", "Username already exists.");
                    }
                    request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(
                                    request, response);
		}
	}

}