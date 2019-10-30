/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp.core;

import com.unapec.jsp.webservice.WebServiceServer;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author net
 */
public class WebServiceConnection {
    static String urlstr = "http://localhost:9876/ws?wsdl";
    static Service service = null;
    static WebServiceServer server = null;
    
    static void startup() {    
          try {
              if(server == null) {
                URL url = new URL(urlstr);
                QName qname = new QName("http://webservice.unapec_jsp.com/","WebServiceImplService");                  
                service = Service.create(url, qname);
                server = service.getPort(WebServiceServer.class);
              } else {
                  System.out.println("server already started...");
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    
    static String greetMessage(String username) {
        if(server == null){
            startup();
        }
        return server.sayHello(username);       
    }
}
