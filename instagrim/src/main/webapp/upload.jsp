<%-- 
    Document   : upload
    Created on : Sep 22, 2014, 6:31:50 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>instagrim_KJL</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
    </head>
    <body>
        <h1>instagrim_KJL ! </h1>
        <h2>Your world in Black and White</h2>
        <nav>
            <ul>
                <li class="nav"><a href="upload.jsp">Upload</a></li>
                <li class="nav"><a href="/instagrim_KJL/Images/majed">Sample Images</a></li>
            </ul>
        </nav>
 
        <article>
            <h3>File Upload</h3>
            <form method="POST" enctype="multipart/form-data" action="Image">
                File to upload: <input type="file" name="upfile"><br/>

                <br/>
                <input type="submit" value="Press"> to upload the file!
            </form>
            
<!-- my code -->
           
            <%LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");%>
            <a href="/instagrim_KJL/Images/<%=lg.getUsername()%>">Your Images</a>
            
<!-- my code -->
        </article>
        <footer>
            <ul>
                <li class="footer"><a href="/instagrim_KJL">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
