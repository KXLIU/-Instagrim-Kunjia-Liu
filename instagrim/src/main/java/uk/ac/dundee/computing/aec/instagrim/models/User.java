/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;//////////////////
import java.util.List;////////////////

import javax.servlet.http.HttpServletRequest;

import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;


/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    /*public boolean InsertUN(String un)
    {
    	 
    	 Session session = cluster.connect("instagrim");
    	 PreparedStatement p = session.prepare("select * from usernamelist where username = un ");
		 BoundStatement boundStmt = new BoundStatement(p);
    	 session.execute( // this is where the query is executed
         boundStmt.bind( // here you are binding the 'boundStatement'
                 un));

         ResultSet result=null;
         String s=null;
         //BoundStatement boundStatement1 = new BoundStatement(p);
         //result = session.execute("select * from usernamelist where username = un ");////what"s wrong?
         for (Row row : result) {
        	 s=row.getString("username");
        	 }
         
        	 if(s==null){
        		
        		 PreparedStatement ps = session.prepare("insert into usernamelist (username) Values(?)");
        		 BoundStatement boundStatement = new BoundStatement(ps);
                 session.execute( // this is where the query is executed
                         boundStatement.bind( // here you are binding the 'boundStatement'
                                 un));
                 //We are assuming this always works.  Also a transaction would be good here !
                 session.close();
                 return true;
                 }
        	 else return false;
         }*/
         
         
      /*   Statement select = QueryBuilder.select().all().from("Keyspaces", "usernamelist")
                 .where(eq("username", un));
         results = session.execute(select);
         for (Row row : results) {
             System.out.format("%s %d \n", row.getString("username"),
                    );
         }
         
         
         
         ResultSet results = session.execute("SELECT * FROM users WHERE lastname='Jones'");
         for (Row row : results) {
         System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
         }
         
         
       if(s==null){
         session.execute( // this is where the query is executed
                 boundStatement.bind( // here you are binding the 'boundStatement'
                         un));
         //We are assuming this always works.  Also a transaction would be good here !
         session.close();
         return true;}*/
        
    
  
    
    
    
    public boolean RegisterUser(String username, String Password, String first_name, String last_name, Set<String> email){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
       // if(InsertUN(username)){
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (login,password,first_name,last_name,email) Values(?,?,?,?,?)");
        
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword,first_name,last_name,email));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
       // }
       // else return false;
    }

    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
   
    
    return false;  
    }
    
  //my code
    public String First_name(String username)
    {
    	 String Storedname = null;
    	Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select first_name from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No First_Name returned");
            return null;
        } else {
            for (Row row : rs) {
               
                Storedname = row.getString("first_name");
                              
            }
            return Storedname;
            }
        }
    
    public String Last_name(String username)
    {
    	String StoredName = null;
    	Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select last_name from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Last_Name returned");
            return null;
        } else {
            for (Row row : rs) {
               
                StoredName = row.getString("last_name");
               
               
            }
            return StoredName;
            }
        }
    
    public Set<String> Email(String username)
    {
    	Set<String> Storedname = null;
    	Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select email from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        
        if (rs.isExhausted()) {
            System.out.println("No email returned");
            return null;
        } else {
            for (Row row : rs) {
               
                Storedname =  row.getSet("email", String.class);
                              
            }
            return Storedname;
            }
        }
//my code
    
       public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    
}
