<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.models.*" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.UUID" %>
<%@ page import="java.util.*" %>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comment List</title>
</head>
<body>

        <%
        //HttpSession session=request.getSession();
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        //ComModel com = new ComModel();
        //String uid=request.getParameter("picid");
      
        //java.util.UUID pid=java.util.UUID.fromString(uid);
        %>
        
        Your Comment:<%=lg.getCom() %>
</body>
</html>