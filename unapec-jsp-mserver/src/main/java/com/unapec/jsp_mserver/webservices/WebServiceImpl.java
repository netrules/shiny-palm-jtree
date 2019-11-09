package com.unapec.jsp_mserver.webservices;
//
/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////package com.unapec_jsp.webservice;
////
import com.unapec.jsp_mserver.UnapecJspServer;
import javax.jws.WebService;
/////**
//// *
//// * @author net
//// */
@WebService(endpointInterface = "com.unapec.jsp_mserver.webservices.WebServiceServer")
public class WebServiceImpl implements WebServiceServer {
    
    public String sayHello(String name) {
            return "Hola " + name + " !, Espero que todo este bien !!";
    }

    public void slay(String msg) {
        UnapecJspServer.helloImpl.slay(msg);
    }

    public String respawn() {
        return UnapecJspServer.helloImpl.respawn();
    }

}
