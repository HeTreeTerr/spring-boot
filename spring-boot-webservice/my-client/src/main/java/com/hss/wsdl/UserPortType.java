package com.hss.wsdl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.5
 * 2022-10-10T00:31:52.386+08:00
 * Generated source version: 3.2.5
 *
 */
@WebService(targetNamespace = "service.hss.com", name = "userPortType")
@XmlSeeAlso({ObjectFactory.class})
public interface UserPortType {

    @WebMethod
    @RequestWrapper(localName = "getUserName", targetNamespace = "service.hss.com", className = "com.hss.service.GetUserName")
    @ResponseWrapper(localName = "getUserNameResponse", targetNamespace = "service.hss.com", className = "com.hss.service.GetUserNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public User getUserName(
        @WebParam(name = "name", targetNamespace = "")
        java.lang.String name
    );
}
