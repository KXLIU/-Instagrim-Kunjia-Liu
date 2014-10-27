package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.utils.Bytes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import static org.imgscalr.Scalr.*;

import org.imgscalr.Scalr.Method;

import uk.ac.dundee.computing.aec.instagrim.lib.*;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;
//import uk.ac.dundee.computing.aec.stores.TweetStore;

public class ComModel {

    Cluster cluster;

public void ComModel() {

    }

public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
    
    
public void insertComment(String comment, java.util.UUID picid ) {
    	
    	try
    	{
    	        Session session = cluster.connect("instagrim_KJL");
    	        PreparedStatement ps = session.prepare("insert into Comment (picid, comment) Values(?,?)");
    	        
    	        BoundStatement boundStatement = new BoundStatement(ps);
    	        session.execute( 
    	                boundStatement.bind( 
    	                        picid, comment));
    	        session.close();
    	}catch (Exception ex) {
            System.out.println("Error --> " + ex);
        }
    	}
		  
 


public String UserComment(java.util.UUID pid){//////////have been changeed
    
    String Comment = null;
	Session session = cluster.connect("instagrim_KJL");
    PreparedStatement ps = session.prepare("select comment from CommentTable where picid = ?");
    ResultSet rs = null;
    BoundStatement boundStatement = new BoundStatement(ps);
    rs = session.execute( // this is where the query is executed
            boundStatement.bind( // here you are binding the 'boundStatement'
                    pid));
    if (rs.isExhausted()) {
        System.out.println("No Comments returned");
        return null;
    } else {
        for (Row row : rs) {
           
            Comment = row.getString("Comment");
                          
        }
        System.out.println("yes");
        session.close();
        return Comment;
        }
    }
}
 