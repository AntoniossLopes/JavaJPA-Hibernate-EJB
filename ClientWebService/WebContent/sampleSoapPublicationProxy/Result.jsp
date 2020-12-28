<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleSoapPublicationProxyid" scope="session" class="web.SoapPublicationProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleSoapPublicationProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleSoapPublicationProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleSoapPublicationProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        web.SoapPublication getSoapPublication10mtemp = sampleSoapPublicationProxyid.getSoapPublication();
if(getSoapPublication10mtemp == null){
%>
<%=getSoapPublication10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 17:
        gotMethod = true;
        String name_1id=  request.getParameter("name20");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        java.lang.String getPublication17mtemp = sampleSoapPublicationProxyid.getPublication(name_1idTemp);
if(getPublication17mtemp == null){
%>
<%=getPublication17mtemp %>
<%
}else{
        String tempResultreturnp18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getPublication17mtemp));
        %>
        <%= tempResultreturnp18 %>
        <%
}
break;
case 22:
        gotMethod = true;
        java.lang.String getPublications22mtemp = sampleSoapPublicationProxyid.getPublications();
if(getPublications22mtemp == null){
%>
<%=getPublications22mtemp %>
<%
}else{
        String tempResultreturnp23 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getPublications22mtemp));
        %>
        <%= tempResultreturnp23 %>
        <%
}
break;
case 25:
        gotMethod = true;
        java.lang.String getResearchers25mtemp = sampleSoapPublicationProxyid.getResearchers();
if(getResearchers25mtemp == null){
%>
<%=getResearchers25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getResearchers25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
}
break;
case 28:
        gotMethod = true;
        String researcherName_2id=  request.getParameter("researcherName31");
            java.lang.String researcherName_2idTemp = null;
        if(!researcherName_2id.equals("")){
         researcherName_2idTemp  = researcherName_2id;
        }
        java.lang.String getPublicationByResearcherName28mtemp = sampleSoapPublicationProxyid.getPublicationByResearcherName(researcherName_2idTemp);
if(getPublicationByResearcherName28mtemp == null){
%>
<%=getPublicationByResearcherName28mtemp %>
<%
}else{
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getPublicationByResearcherName28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>