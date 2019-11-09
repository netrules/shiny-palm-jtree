package com.unapec.jsp.account.todo;

import com.unapec.ejb.ManageTodoBean;
import com.unapec.ejb.ManageTodoBeanLocal;
import com.unapec.ejb.todo.TodoEntity;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list-todos.do")
public class ListTodoServlet extends HttpServlet {

//	private TodoService todoService = new TodoService();

        @EJB
        private ManageTodoBeanLocal manageTodoBean;
        
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("todos", manageTodoBean.retrieveTodos());

                manageTodoBean = new ManageTodoBean();
                List<TodoEntity> myList = manageTodoBean.retrieveTodos();
                System.out.println("ListTodoServlet::myList - " + myList.toString());
		request.setAttribute("todos", myList);
                
		request.getRequestDispatcher("/WEB-INF/views/account/list-todos.jsp").forward(
				request, response);
	}
}