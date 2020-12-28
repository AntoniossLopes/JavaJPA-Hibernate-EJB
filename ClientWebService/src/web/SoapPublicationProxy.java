package web;

public class SoapPublicationProxy implements web.SoapPublication {
  private String _endpoint = null;
  private web.SoapPublication soapPublication = null;
  
  public SoapPublicationProxy() {
    _initSoapPublicationProxy();
  }
  
  public SoapPublicationProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapPublicationProxy();
  }
  
  private void _initSoapPublicationProxy() {
    try {
      soapPublication = (new web.SoapPublicationServiceLocator()).getSoapPublicationPort();
      if (soapPublication != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapPublication)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapPublication)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapPublication != null)
      ((javax.xml.rpc.Stub)soapPublication)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public web.SoapPublication getSoapPublication() {
    if (soapPublication == null)
      _initSoapPublicationProxy();
    return soapPublication;
  }
  
  public java.lang.String getPublication(java.lang.String name) throws java.rmi.RemoteException{
    if (soapPublication == null)
      _initSoapPublicationProxy();
    return soapPublication.getPublication(name);
  }
  
  public java.lang.String getPublications() throws java.rmi.RemoteException{
    if (soapPublication == null)
      _initSoapPublicationProxy();
    return soapPublication.getPublications();
  }
  
  public java.lang.String getResearchers() throws java.rmi.RemoteException{
    if (soapPublication == null)
      _initSoapPublicationProxy();
    return soapPublication.getResearchers();
  }
  
  public java.lang.String getPublicationByResearcherName(java.lang.String researcherName) throws java.rmi.RemoteException{
    if (soapPublication == null)
      _initSoapPublicationProxy();
    return soapPublication.getPublicationByResearcherName(researcherName);
  }
  
  
}