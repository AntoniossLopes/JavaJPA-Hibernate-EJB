/**
 * SoapresearcherServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web;

public class SoapresearcherServiceLocator extends org.apache.axis.client.Service implements web.SoapresearcherService {

    public SoapresearcherServiceLocator() {
    }


    public SoapresearcherServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SoapresearcherServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SoapresearcherPort
    private java.lang.String SoapresearcherPort_address = "http://localhost:8080/Projeto-WS/Soapresearcher";

    public java.lang.String getSoapresearcherPortAddress() {
        return SoapresearcherPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SoapresearcherPortWSDDServiceName = "SoapresearcherPort";

    public java.lang.String getSoapresearcherPortWSDDServiceName() {
        return SoapresearcherPortWSDDServiceName;
    }

    public void setSoapresearcherPortWSDDServiceName(java.lang.String name) {
        SoapresearcherPortWSDDServiceName = name;
    }

    public web.Soapresearcher getSoapresearcherPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SoapresearcherPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSoapresearcherPort(endpoint);
    }

    public web.Soapresearcher getSoapresearcherPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            web.SoapresearcherServiceSoapBindingStub _stub = new web.SoapresearcherServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSoapresearcherPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSoapresearcherPortEndpointAddress(java.lang.String address) {
        SoapresearcherPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (web.Soapresearcher.class.isAssignableFrom(serviceEndpointInterface)) {
                web.SoapresearcherServiceSoapBindingStub _stub = new web.SoapresearcherServiceSoapBindingStub(new java.net.URL(SoapresearcherPort_address), this);
                _stub.setPortName(getSoapresearcherPortWSDDServiceName());
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
        if ("SoapresearcherPort".equals(inputPortName)) {
            return getSoapresearcherPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://web/", "SoapresearcherService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://web/", "SoapresearcherPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SoapresearcherPort".equals(portName)) {
            setSoapresearcherPortEndpointAddress(address);
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
