<%-- 
    Document   : UsersPics
    Created on : Sep 24, 2014, 2:52:48 PM
    Author     : Administrator
--%>

<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>instagrim_KJL</title>
        <link rel="stylesheet" type="text/css" href="/instagrim_KJL/Styles.css" />
    </head>
    <body>
        <header>
        
        <h1>instagrim_KJL ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
        
        <nav>
            <ul>
                <li class="nav"><a href="/instagrim_KJL/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/instagrim_KJL/Images/majed">Sample Images</a></li>
            </ul>
        </nav>
 
        <article>
            <h1>Your Pics</h1>
        <%
            java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
            if (lsPics == null) {
        %>
        <p>No Pictures found</p>
        <%
        } else {
            Iterator<Pic> iterator;
            iterator = lsPics.iterator();
           
            while (iterator.hasNext()) {     
          
               Pic p = (Pic) iterator.next();

        %>
        <a href="/instagrim_KJL/Image/<%=p.getSUUID()%>" ><img src="/instagrim_KJL/Thumb/<%=p.getSUUID()%>"></a><br/>
        <a href="/instagrim_KJL/CT?picid=<%=p.getSUUID()%>">CommentList</a><br/>
        <a href="/instagrim_KJL/Comment.jsp?picid=<%=p.getSUUID()%>">Add Comment</a><br>
         
		
                                                
            <% 
            }
            }
        %>
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/instagrim_KJL">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
