/**
 * SoapPublicationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web;

public interface SoapPublicationService extends javax.xml.rpc.Service {
    public java.lang.String getSoapPublicationPortAddress();

    public web.SoapPublication getSoapPublicationPort() throws javax.xml.rpc.ServiceException;

    public web.SoapPublication getSoapPublicationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
