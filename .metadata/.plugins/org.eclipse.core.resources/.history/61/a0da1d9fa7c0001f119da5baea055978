/**
 * Hello_BindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.examples.www.wsdl.HelloService_wsdl;

public class Hello_BindingSkeleton implements com.examples.www.wsdl.HelloService_wsdl.Hello_PortType, org.apache.axis.wsdl.Skeleton {
    private com.examples.www.wsdl.HelloService_wsdl.Hello_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "firstName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sayHello", _params, new javax.xml.namespace.QName("", "greeting"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("urn:examples:helloservice", "sayHello"));
        _oper.setSoapAction("sayHello");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sayHello") == null) {
            _myOperations.put("sayHello", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sayHello")).add(_oper);
    }

    public Hello_BindingSkeleton() {
        this.impl = new com.examples.www.wsdl.HelloService_wsdl.Hello_BindingImpl();
    }

    public Hello_BindingSkeleton(com.examples.www.wsdl.HelloService_wsdl.Hello_PortType impl) {
        this.impl = impl;
    }
    public java.lang.String sayHello(java.lang.String firstName) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.sayHello(firstName);
        return ret;
    }

}
