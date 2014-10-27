

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
        <h2>Choose one picture as your user photo.</h2>
        <nav>
            <ul>
               <li class="nav"><a href="UploadUserPic.jsp">UploadYourPhoto</a></li>
                <%LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");%>
              
               <li><a href="/instagrim_KJL/Pictures/<%=lg.getUsername()%>">Your photo</a></li>
            </ul>
        </nav>
 
        <article>
          
            <form method="POST" enctype="multipart/form-data" action="Picture">
                Photo to upload: <input type="file" name="upfile"><br/>
            
                <br/>
                <input type="submit" value="Press"> to upload the file!
            
            </form>

        </article>
        
      <!--  <meta http-equiv="refresh" content="0; url=photo.jsp"> --> 
       <footer>
            <ul>
                <li class="footer"><a href="/instagrim_KJL">Home</a></li>
            </ul>
        </footer>
       
    </body>
</html>
