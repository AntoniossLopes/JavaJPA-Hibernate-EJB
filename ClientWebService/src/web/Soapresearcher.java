/**
 * Soapresearcher.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package web;

public interface Soapresearcher extends java.rmi.Remote {
    public java.lang.String getResearchers() throws java.rmi.RemoteException;
    public java.lang.String getSkills() throws java.rmi.RemoteException;
    public java.lang.String getResearcher(java.lang.String name) throws java.rmi.RemoteException;
    public java.lang.String getResearchersWithSkill(java.lang.String skills) throws java.rmi.RemoteException;
}
