<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add comment</title>
</head>
<body>
<header>
        <h1>instagrim ! </h1>
        <h2>Your world in Black and White</h2>
        </header>
               
        <article>
            <h3></h3>
            <form method="POST"  action="Comment">
                <ul>
                    <li>Add your comment <input type="text" name="Comment"></li>
                </ul>
                    <input type="hidden" name="picid"  value="<%=request.getParameter("picid")%>">

                <br/>
                <input type="submit" value="SubmitComment"> 
            </form>

        </article>
</body>
</html>