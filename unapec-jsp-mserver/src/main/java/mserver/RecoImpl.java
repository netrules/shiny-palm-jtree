//package com.unapec.corba.mserver;
//
//import java.util.ArrayList;
//import java.util.List;
//import mserver.recollectorPOA;
//
///**
// * @see https://www.jc-mouse.net/
// * @author mouse
// */
//public class RecoImpl extends recollectorPOA {
//    // https://www.jc-mouse.net/proyectos/corba-en-java-ejemplo-completo
//    
//    private static List<String> todos = new ArrayList<String>();
//
////    public List<Todo> retrieveTodos() {
////            return todos;
////    }
////    public void deleteTodo(Todo todo) {
////            todos.remove(todo);
////    }
//        
//    @Override
//    public String undo() {
//        return todos.remove(todos.size()-1);
//    }
//    
//    @Override
//    public void keep(String description, String category) {
////        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        todos.add(description);
////        return;
//    }
//
//}