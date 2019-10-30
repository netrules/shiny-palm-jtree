/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unapec.jsp_mserver.rmi_service;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author virt001
 */
public interface Generator 
    extends java.rmi.Remote {
        public String generateMessage(/*int difficulty*/) throws java.rmi.RemoteException;
}
