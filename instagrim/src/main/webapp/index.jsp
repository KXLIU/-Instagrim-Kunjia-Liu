<%-- 
    Document   : index
    Created on : Sep 28, 2014, 7:01:44 PM
    Author     : Administrator
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uk.ac.dundee.computing.aec.instagrim.stores.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>instagrim_KJL</title>
        <link rel="stylesheet" type="text/css" href="Styles.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <header>
            <h1>instagrim_KJL ! </h1>
            <h2>Your world in Black and White</h2>
        </header>
        <nav>
            <ul>

               
                <li><a href="upload.jsp">Upload</a></li>
                    <%
                        
                        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
                        if (lg != null) {
                           
                            
                            if (lg.getlogedin()) {
                    %>

                <li><a href="/instagrim_KJL/Images/<%=lg.getUsername()%>">Your Images</a></li>
           
<!-- my code -->
                <li><a href="UploadUserPic.jsp">   UploadYourPhoto</a></li>
				       
            
        <%
            java.util.LinkedList<Pic> lsPics = (java.util.LinkedList<Pic>) request.getAttribute("Pics");
            if (lsPics == null) {
        %>
        <p>No Pictures found</p>
        <%
        } else {
            Iterator<Pic> iterator;
            iterator = lsPics.iterator();
           
            //while (iterator.hasNext()) {     
          
               Pic p = (Pic) iterator.next();
           
           %>
           
              <li> <a href="/instagrim_KJL/Picture/<%=p.getSUUID()%>" ><img src="/instagrim_KJL/Thumb1/<%=p.getSUUID()%>"></a></li>
           <%} %>
<!-- my code -->  
			<ul>      
                  <!-- log out -->
                 <li><a href="/instagrim_KJL/LogOut">LogOut</a></li>
                    <%}
                            }else{
                                %>
                 <li><a href="register.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
                <% }%>
            </ul>
        </nav>
         <%if (lg != null) {%>
        	
         Welcome <%=lg.getfirst_name() %> <%=lg.getlast_name() %>  !
         <br>
         <%=lg.getemail() %>
         <br>
         <a href="/instagrim_KJL/Pictures/<%=lg.getUsername()%>">Your photo</a>
        
         <%}%>  
       
        <footer>
            <ul>
                <li class="footer"><a href="/instagrim_KJL">Home</a></li>
                <li>&COPY; Andy C</li>
            </ul>
        </footer>
    </body>
</html>
