package com.unapec.jsp.account.todo;

import com.unapec.ejb.ManageTodoBean;
import com.unapec.ejb.ManageTodoBeanLocal;
import com.unapec.ejb.todo.TodoEntity;
import com.unapec.ejb.todo.ValidateParameter;
import com.unapec.jsp.core.Config;
import java.io.IOException;
import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//INITIALIZATION OF JSP
//CREATE add_002dtodo_jsp.java from add-todo.jsp
//compile add_002dtodo_jsp.java to add_002dtodo_jsp.class
//call _jspInit

//SERVICE -> _jspService

//DESTROY -> _jspDestroy

@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet {

//	private TodoService todoService = new TodoService();

        @EJB
        private ManageTodoBeanLocal manageTodoBean;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/account/add-todo.jsp").forward(
				request, response);
	}
        
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String description = request.getParameter("todo");
            String category = request.getParameter("category");
//            String owner = request.getParameter("owner");

//            String message;

            if (ValidateParameter.validateDescription(description)
                    && ValidateParameter.validateCategory(category)) {

//                message = String.format("%s car is saved", sname);

//                int price = Integer.valueOf(sprice);
//                Todo todoEntity = new Todo(description, category, owner);
                TodoEntity todoEntity = new TodoEntity(description, category);
                System.out.println("todoEntity:" + todoEntity.toString());
                
                manageTodoBean = new ManageTodoBean();
                manageTodoBean.saveTodo(todoEntity);
                
//		todoService.addTodo(new TodoEntity(description, category));
		response.sendRedirect(Config.SITE_URL + "list-todos.do");


            } else {

//                message = "Wrong parameters";
            }

//            response.setContentType("text/plain;charset=UTF-8");
//
//            try (PrintWriter out = response.getWriter()) {
//
//                out.println(message);
//            }
        }


//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		String newTodo = request.getParameter("todo");
//		String category = request.getParameter("category");
//		todoService.addTodo(new Todo(newTodo, category));
//		response.sendRedirect(Config.SITE_URL + "list-todos.do");
//	}
}