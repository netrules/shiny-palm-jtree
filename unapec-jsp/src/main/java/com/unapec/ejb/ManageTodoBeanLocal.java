/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.ejb;

import com.unapec.ejb.todo.TodoEntity;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author virt001
 */
@Local
public interface ManageTodoBeanLocal {
    void removeTodoById(Long id);
    void removeTodo(TodoEntity todo);
    void saveTodo(TodoEntity todo);
    void setOwner(Long owner);
    void setDescription(String description);
    void setCategory(String category);

    List<TodoEntity> retrieveTodos();
    TodoEntity getTodo(Long id);
    
}
