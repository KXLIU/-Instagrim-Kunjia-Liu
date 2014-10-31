package uk.ac.dundee.computing.aec.instagrim.servlets;


import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;  
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
import uk.ac.dundee.computing.aec.instagrim.lib.Convertors;
import uk.ac.dundee.computing.aec.instagrim.models.PicModel;
import uk.ac.dundee.computing.aec.instagrim.models.ComModel;
import uk.ac.dundee.computing.aec.instagrim.models.User;
import uk.ac.dundee.computing.aec.instagrim.stores.Com;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Image
 */
/*@WebServlet(urlPatterns = {
    "/Comment",
    "/Comment/*",
   
})
@MultipartConfig*/

@WebServlet(name = "Comment", urlPatterns = {"/Comment"})



public class Comment extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private Cluster cluster;    
    

    public Comment() {
        super();
       
    }

    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        cluster = CassandraHosts.getCluster();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	
    	 
         java.util.UUID pid=java.util.UUID.fromString(request.getParameter("picid"));
         HttpSession session=request.getSession();
         ComModel c = new ComModel();
         java.util.LinkedList<Com> Ct = new java.util.LinkedList<>();
         c.setCluster(cluster);
         Ct=c.UserComment(pid);
         
      /*   Iterator<Com> iterator;
         iterator = Ct.iterator();
         PrintWriter out = response.getWriter();
         while (iterator.hasNext()) {     
       
            Com i = (Com) iterator.next();

            out.println(i.getCom());
         }
         */
         request.setAttribute("Comment", Ct);

          RequestDispatcher rd = request.getRequestDispatcher("/CommentList.jsp");
          rd.forward(request,response);
        	response.sendRedirect("/instagrim/CommentList.jsp");
        	
     
    }





    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	
        String comment=request.getParameter("Comment");
        java.util.UUID pid=java.util.UUID.fromString(request.getParameter("picid"));
        ComModel com=new ComModel();
        //System.out.println(comment);
        //System.out.println(pid);
        com.setCluster(cluster);
        
        com.insertComment(comment , pid);
        
       response.sendRedirect("/instagrim/UsersPics.jsp");

                
    }
    

   

      
    

	private void error(String mess, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = null;
        out = new PrintWriter(response.getOutputStream());
        out.println("<h1>You have an error in your input</h1>");
        out.println("<h2>" + mess + "</h2>");
        out.close();
        return;
    }
} 
