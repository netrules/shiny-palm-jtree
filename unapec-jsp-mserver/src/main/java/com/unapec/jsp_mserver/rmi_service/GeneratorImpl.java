/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver.rmi_service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/**
 *
 * @author virt001
 */
public class GeneratorImpl extends
    java.rmi.server.UnicastRemoteObject implements Generator {
    
    public GeneratorImpl()
        throws java.rmi.RemoteException {
            super();
    }
    
    public String generateMessage(/*int difficulty*/)
    throws java.rmi.RemoteException {
        String api_url = "https://api.adviceslip.com/advice" ;
        JSONObject json = null;
        try {
            String fetchApi = IOUtils.toString(new URL(api_url), Charset.forName("UTF-8"));           
            json = new JSONObject(fetchApi);
        } catch (MalformedURLException ex) {
            Logger.getLogger(GeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GeneratorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
//        String answer = json["slip"]["advice"];
        //String answer = json.getArr
        String ret = "";
        if(json != null)
            ret = json.getJSONObject("slip").getString("advice");

        System.out.print(ret);        
        return ret;//answer;
    }
}
