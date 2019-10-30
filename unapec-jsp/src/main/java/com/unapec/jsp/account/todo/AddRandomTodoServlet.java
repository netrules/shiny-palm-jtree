package com.unapec.jsp.account.todo;

import com.unapec.ejb.ManageTodoBean;
import com.unapec.ejb.ManageTodoBeanLocal;
import com.unapec.ejb.todo.TodoEntity;
import com.unapec.jsp_mserver.rmi_service.Generator;
import com.unapec.jsp.core.Config;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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

@WebServlet(urlPatterns = "/add-random-todo.do")
public class AddRandomTodoServlet extends HttpServlet {

//	private TodoService todoService = new TodoService();

        @EJB
        private ManageTodoBeanLocal manageTodoBean;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            String newTodo = "";
            try {
                // fire to localhost port 1099
                Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099);
                // search for myMessage service
                Generator impl = (Generator) myRegistry.lookup("myGenerator");
                // call server's method
                newTodo = impl.generateMessage();

                System.out.println("Message Generated");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            TodoEntity todoEntity = new TodoEntity(newTodo, "Random");
            manageTodoBean = new ManageTodoBean();
            manageTodoBean.saveTodo(todoEntity);
//            todoService.addTodo(new TodoEntity(newTodo, "Random"));
            response.sendRedirect(Config.SITE_URL + "list-todos.do");
	}
}