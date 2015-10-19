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
        <title>instagrim</title>
        <link rel="stylesheet" type="text/css"  />
         <style>
            h2 {background-color:black;
                    color: white;
                    font-variant: small-caps;
                    display:block;
                    font-weight:bold;
                    width:400px;
                    text-align:center;
                    padding:4px;
                    text-decoration:none;  
                    }
            h1 {font-size: 300%;
                    font-style: italic;
                    font-variant: small-caps;}
            body
                {
                    background-image: url(http://www.technosamrat.com/wp-content/uploads/2012/05/Black-and-White-Wallpaper-Picture.jpg);
                    background-position: center;
                    background-repeat: repeat-y;
                    background-position: 0px -50px;
                } 
            nav a:link,nav a:visited
                {
                display:block;
                font-weight:bold;
                color:white;
                background-color:#bebebe;
                width:120px;
                text-align:center;
                padding:4px;
                text-decoration:none;
                text-transform:uppercase;
                }
            nav a:hover,nav a:active
                {
                background-color:black;
                }
            ul{
                list-style-type:none;
                margin:0;
                padding:0;
                }
        </style>
    </head>
    <body>
        <header>
        
        <h1>instagrim ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
        
        <nav>
            <ul>
                <li class="nav"><a href="/instagrim/upload.jsp">Upload</a></li>
                <li class="nav"><a href="/instagrim/SamplePics.jsp">Sample Images</a></li>
                <li class="nav"><a href="/instagrim/index1.jsp">Home</a></li>
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
        <a href="/instagrim/Image/<%=p.getSUUID()%>" ><img src="/instagrim/Thumb/<%=p.getSUUID()%>"></a><br/>
        <a href="/instagrim/Comment?picid=<%=p.getSUUID()%>">CommentList</a><br/>
        <a href="/instagrim/Comment.jsp?picid=<%=p.getSUUID()%>">Add Comment</a><br>
         
		
                                                
            <% 
            }
            }
        %>
        </article>
    </body>
</html>
