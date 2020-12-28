package web;

public class SoapresearcherProxy implements web.Soapresearcher {
  private String _endpoint = null;
  private web.Soapresearcher soapresearcher = null;
  
  public SoapresearcherProxy() {
    _initSoapresearcherProxy();
  }
  
  public SoapresearcherProxy(String endpoint) {
    _endpoint = endpoint;
    _initSoapresearcherProxy();
  }
  
  private void _initSoapresearcherProxy() {
    try {
      soapresearcher = (new web.SoapresearcherServiceLocator()).getSoapresearcherPort();
      if (soapresearcher != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)soapresearcher)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)soapresearcher)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (soapresearcher != null)
      ((javax.xml.rpc.Stub)soapresearcher)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public web.Soapresearcher getSoapresearcher() {
    if (soapresearcher == null)
      _initSoapresearcherProxy();
    return soapresearcher;
  }
  
  public java.lang.String getResearchers() throws java.rmi.RemoteException{
    if (soapresearcher == null)
      _initSoapresearcherProxy();
    return soapresearcher.getResearchers();
  }
  
  public java.lang.String getSkills() throws java.rmi.RemoteException{
    if (soapresearcher == null)
      _initSoapresearcherProxy();
    return soapresearcher.getSkills();
  }
  
  public java.lang.String getResearcher(java.lang.String name) throws java.rmi.RemoteException{
    if (soapresearcher == null)
      _initSoapresearcherProxy();
    return soapresearcher.getResearcher(name);
  }
  
  public java.lang.String getResearchersWithSkill(java.lang.String skills) throws java.rmi.RemoteException{
    if (soapresearcher == null)
      _initSoapresearcherProxy();
    return soapresearcher.getResearchersWithSkill(skills);
  }
  
  
}