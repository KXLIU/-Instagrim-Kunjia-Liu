<%-- 
    Document   : index1
    Created on : 2015-10-19, 16:25:45
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>instagrim</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header>
            <h1>instagrim ! </h1>
            <h2>Your world in Black and White</h2>
        </header>
        <nav>
            <ul>
                    <%
                        
                        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                        if (lg != null) {
                           
                            
                            if (lg.getlogedin()) {
                    %>
                <li><a href="upload.jsp">Upload</a></li>
                <li><a href="/instagrim/Images/<%=lg.getUsername()%>">Your Images</a></li>
                <li><a href="/instagrim/LogOut">LogOut</a></li>
	    <ul>      
                 
                    <%}
                            }else{
                                %>
                 <li><a href="register.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
                <% }%>
            </ul>
        </nav>
         <%if (lg != null) {%>
         <article>	
         <p> Welcome <%=lg.getfirst_name() %> <%=lg.getlast_name() %>  ! </p>
         <br>
         <p><%=lg.getemail() %></p>
         <br>
         <a href="/instagrim/Pictures/<%=lg.getUsername()%>">Your photo</a>
         </article>
         <%}%>         
    </body>
</html>
