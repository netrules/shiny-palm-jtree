/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.ejb;

import com.unapec.ejb.todo.TodoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author virt001
 */
@Stateless
public class ManageTodoBean implements ManageTodoBeanLocal {

    // https://stackoverflow.com/questions/15842229/class-org-apache-derby-jdbc-clientdriver-not-found-when-trying-to-connect-to
    // https://stackoverflow.com/questions/11533921/where-is-org-apache-derby-jdbc-clientdriver
    // https://stackoverflow.com/questions/11173974/different-ways-of-getting-the-entitymanager
    // https://stackoverflow.com/questions/15501396/writing-static-utility-class-in-java-ee-system?rq=1
    // https://pt.stackoverflow.com/questions/241467/name-name-is-not-bound-in-this-context-unable-to-find-jdbc
    
    // https://stackify.com/enterprise-java-beans/
    // https://www.baeldung.com/hibernate-entitymanager
    // http://wiki.netbeans.org/SimpleJPAApplicationWithNetbeans
    
    private String description;
    private String category;
    private Long owner;
    
//    @PersistenceContext(unitName = "todopu")
//    private EntityManager em;
    
    private static ThreadLocal<EntityManager> instance = new ThreadLocal<EntityManager>();
    static EntityManagerFactory emf;
    
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    public Long getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Long owner) {
        this.owner = owner;
    }
    
    @Override
    public void removeTodoById(Long id) {
        EntityManager em = getCurrentInstance();
        TodoEntity ref = em.getReference(TodoEntity.class, id);
        
        em.getTransaction().begin();
        em.remove(ref);
        em.getTransaction().commit();
    }

    @Override
    public void removeTodo(TodoEntity todo) {
        EntityManager em = getCurrentInstance();
        em.remove(todo);
    }
    @Override
    public void saveTodo(TodoEntity todo) {
        EntityManager em = getCurrentInstance();
//        em = factory.createEntityManager();
        em.getTransaction().begin();
        if (!em.contains(todo)) {
            // persist object - add to entity manager
            em.persist(todo);
            // flush em - save to DB
            em.flush();
        }
        // commit transaction at all
        em.getTransaction().commit();
//        closeConnection(em);
    }

    @Override
    public TodoEntity getTodo(Long id) {
        EntityManager em = getCurrentInstance();
//        TodoEntity todo = em.find(TodoEntity.class, id);
        TodoEntity todo = (TodoEntity) em.createNamedQuery(TodoEntity.GET_ONE_QUERY_BYID, TodoEntity.class).setParameter("id", id)
          .getSingleResult();
        System.out.println(todo);
        return todo;
    }
    
    public void closeConnection(EntityManager em) {
        em.close();
        emf.close();
    }

    @Override
    public List<TodoEntity> retrieveTodos() {
        EntityManager em = getCurrentInstance();
//        em.getTransaction().begin();
        List<TodoEntity> ret = em.createNamedQuery(TodoEntity.GET_ALL_QUERY_NAME, TodoEntity.class).getResultList();
//        em.getTransaction().commit();
        return ret;
//        TypedQuery<TodoEntity> q = em.createQuery(
//            "SELECT td.Description, td.Category " +
//            "FROM Todos td " +
//            "WHERE td.Id = :id "/* +
//            "GROUP BY c.id"*/, TodoEntity.class).setParameter("Id", owner);
//        List<TodoEntity> listThing = em.createQuery(
//            "SELECT p FROM Todos p").getResultList();
//        return listThing;

//        Map<String, Long> resultMap = new HashMap<String, Long>(resultList.size());
//        for (Object[] result : resultList)
//          resultMap.put((String)result[0], (Long)result[1]);
    }
    
    public static EntityManager getCurrentInstance() {
        EntityManager em = null;
        if(instance.get() == null) {
            emf = javax.persistence.Persistence.createEntityManagerFactory("todopu");
            em = emf.createEntityManager();
//            em.getTransaction().begin();
//            try {
//                em.persist(object);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                e.printStackTrace();
//                em.getTransaction().rollback();
//            } finally {
//                //em.close();
//            }
        } else {
            em = instance.get();
        }
        return em;
    }

}
