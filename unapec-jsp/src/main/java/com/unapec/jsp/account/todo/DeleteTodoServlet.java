package com.unapec.jsp.account.todo;

import com.unapec.ejb.ManageTodoBean;
import com.unapec.ejb.ManageTodoBeanLocal;
import com.unapec.ejb.todo.TodoEntity;
import com.unapec.jsp.core.Config;
import com.unapec.jsp.core.WebServiceConnection;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;

@WebServlet(urlPatterns = "/delete-todo.do")
public class DeleteTodoServlet extends HttpServlet {

//	private TodoService todoService = new TodoService();    @EJB
        private ManageTodoBeanLocal manageTodoBean;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {            
                TodoEntity todo;
                Long sauceId = Long.valueOf(request.getParameter("todo"));
                System.out.println(sauceId);
                manageTodoBean = new ManageTodoBean();
                
                todo = manageTodoBean.getTodo(sauceId);
                System.out.println(todo.getDescription() + "DESCRIPTION");
                
                if(todo.getCategory() != "Returned")
                    WebServiceConnection.slayMessage(todo.getDescription());
                
                manageTodoBean.removeTodoById(sauceId);
                manageTodoBean = null;
//		todoService.deleteTodo(new TodoEntity(request.getParameter("todo"), request
//				.getParameter("category")));
		response.sendRedirect(Config.SITE_URL + "list-todos.do");
	}
}