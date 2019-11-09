package com.unapec.jsp_mserver.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceServer {
    
    @WebMethod
    void slay(String msg);
    @WebMethod
    String respawn();
    
}
