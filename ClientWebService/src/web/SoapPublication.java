/**
 * SoapPublication.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web;

public interface SoapPublication extends java.rmi.Remote {
    public java.lang.String getPublication(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String getPublications() throws java.rmi.RemoteException;
    public java.lang.String getResearchers() throws java.rmi.RemoteException;
    public java.lang.String getPublicationByResearcherName(java.lang.String researcherName) throws java.rmi.RemoteException;
}
