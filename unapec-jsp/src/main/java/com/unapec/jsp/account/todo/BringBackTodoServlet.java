package com.unapec.jsp.account.todo;

import com.unapec.ejb.ManageTodoBean;
import com.unapec.ejb.ManageTodoBeanLocal;
import com.unapec.ejb.todo.TodoEntity;
import com.unapec.jsp_mserver.rmi_service.Generator;
import com.unapec.jsp.core.Config;
import com.unapec.jsp.core.WebServiceConnection;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add-returned-todo.do")
public class BringBackTodoServlet extends HttpServlet {

//	private TodoService todoService = new TodoService();
        @EJB
        private ManageTodoBeanLocal manageTodoBean;
        
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            
            String newTodo = WebServiceConnection.respawnMessage();
            TodoEntity todoEntity = new TodoEntity(newTodo, "Returned");
            manageTodoBean = new ManageTodoBean();
            manageTodoBean.saveTodo(todoEntity);
//            todoService.addTodo(new TodoEntity(newTodo, "Random"));
            response.sendRedirect(Config.SITE_URL + "list-todos.do");
	}
}