/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.ejb.todo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author virt001
 * https://stackoverflow.com/questions/33367725/stateless-ejb-throwing-nullpointerexception-in-enterprise-application-client
 */
@Entity(name="Todos")
@Table(name="Todos")
@NamedQueries({@NamedQuery(name = "TodoEntity.getAll", query = "SELECT t FROM Todos AS t")})
public class TodoEntity implements Serializable {

    // http://zetcode.com/java/ejb/
    
    public static final String GET_ALL_QUERY_NAME = "TodoEntity.getAll";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Long id;

//    @Column(name="Owner")
//    private Long owner;
    
    @Column(name="Description")
    private String description;
    
    @Column(name="Category")
    private String category;
    
    public TodoEntity() { }
    public TodoEntity(/*Long owner, */String description, String category) {;
//        this.owner = owner;
        this.description = description;
        this.category = category;
    }

//    public Long getOwner() {
//        return owner;
//    }
//
//    public void setOwner(Long owner) {
//        this.owner = owner;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TodoEntity)) {
            return false;
        }
        TodoEntity other = (TodoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unapec.ejb.todo.TodoEntity[ id=" + id + " ]";
    }
    
}
