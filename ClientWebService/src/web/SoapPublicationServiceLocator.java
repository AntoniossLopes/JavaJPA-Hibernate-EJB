/**
 * SoapPublicationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web;

public class SoapPublicationServiceLocator extends org.apache.axis.client.Service implements web.SoapPublicationService {

    public SoapPublicationServiceLocator() {
    }


    public SoapPublicationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapPublicationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapPublicationPort
    private java.lang.String SoapPublicationPort_address = "http://localhost:8080/Projeto-WS/SoapPublication";

    public java.lang.String getSoapPublicationPortAddress() {
        return SoapPublicationPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapPublicationPortWSDDServiceName = "SoapPublicationPort";

    public java.lang.String getSoapPublicationPortWSDDServiceName() {
        return SoapPublicationPortWSDDServiceName;
    }

    public void setSoapPublicationPortWSDDServiceName(java.lang.String name) {
        SoapPublicationPortWSDDServiceName = name;
    }

    public web.SoapPublication getSoapPublicationPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapPublicationPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapPublicationPort(endpoint);
    }

    public web.SoapPublication getSoapPublicationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            web.SoapPublicationServiceSoapBindingStub _stub = new web.SoapPublicationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoapPublicationPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapPublicationPortEndpointAddress(java.lang.String address) {
        SoapPublicationPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (web.SoapPublication.class.isAssignableFrom(serviceEndpointInterface)) {
                web.SoapPublicationServiceSoapBindingStub _stub = new web.SoapPublicationServiceSoapBindingStub(new java.net.URL(SoapPublicationPort_address), this);
                _stub.setPortName(getSoapPublicationPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SoapPublicationPort".equals(inputPortName)) {
            return getSoapPublicationPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://web/", "SoapPublicationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://web/", "SoapPublicationPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapPublicationPort".equals(portName)) {
            setSoapPublicationPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
