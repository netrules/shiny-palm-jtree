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
    static String urlstr = "http://127.0.0.1:9876/ws?wsdl";
    static Service service = null;
    static WebServiceServer server = null;
    
    static void startup() {    
          try {
              if(server == null) {
                URL url = new URL(urlstr);
                QName qname = new QName("http://webservices.jsp_mserver.unapec.com/","WebServiceImplService");                  
                service = Service.create(url, qname);
                QName qport = new QName("http://webservices.jsp_mserver.unapec.com/","WebServiceImplPort");                  
                server = service.getPort(qport, WebServiceServer.class);
              } else {
                  System.out.println("server already started...");
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
    }
    
    public static String respawnMessage() {
        if(server == null){
            startup();
        }
        return server.respawn();       
    }
    public static void slayMessage(String msg) {
        if(server == null){
            startup();
        }
        server.slay(msg);    
    }
}
