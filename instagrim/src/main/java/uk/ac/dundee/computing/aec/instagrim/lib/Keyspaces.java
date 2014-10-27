package uk.ac.dundee.computing.aec.instagrim.lib;

import java.util.ArrayList;
import java.util.List;

import com.datastax.driver.core.*;

public final class Keyspaces {

    public Keyspaces() {

    }

    public static void SetUpKeySpaces(Cluster c) {
        try {
            //Add some keyspaces here
            String createkeyspace = "create keyspace if not exists instagrim_KJL WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
            String CreatePicTable = "CREATE TABLE if not exists instagrim_KJL.Pics ("
                    + " user varchar,"
                    + " picid uuid, "
                    + " interaction_time timestamp,"
                    + " title varchar,"
                    + " image blob,"
                    + " thumb blob,"
                    + " processed blob,"
                    + " imagelength int,"
                    + " thumblength int,"
                    + "  processedlength int,"
                    + " type  varchar,"
                    + " name  varchar,"
                    + " PRIMARY KEY (picid)"
                    + ")";
            String Createuserpiclist = "CREATE TABLE if not exists instagrim_KJL.userpiclist (\n"
                    + "picid uuid,\n"
                    + "user varchar,\n"
                    + "pic_added timestamp,\n"
                    + "PRIMARY KEY (user,pic_added)\n"
                    + ") WITH CLUSTERING ORDER BY (pic_added desc);";
//my code
            String CreatePhotoTable = "CREATE TABLE if not exists instagrim_KJL.Photo ("
                    + " user varchar,"
                    + " photoid uuid, "
                    + " interaction_time timestamp,"
                    + " title varchar,"
                    + " image blob,"
                    + " thumb blob,"
                    + " processed blob,"
                    + " imagelength int,"
                    + " thumblength int,"
                    + "  processedlength int,"
                    + " type  varchar,"
                    + " name  varchar,"
                    + " PRIMARY KEY (photoid)"
                    + ")";
            String Createuserphotolist = "CREATE TABLE if not exists instagrim_KJL.userphotolist (\n"
                    + "photoid uuid,\n"
                    + "user varchar,\n"
                    + "pic_added timestamp,\n"
                    + "PRIMARY KEY (user,pic_added)\n"
                    + ") WITH CLUSTERING ORDER BY (pic_added desc);";
            /*String Createusernamelist = "CREATE TABLE if not exists instagrim_KJL.usernamelist (\n"
                   
                    + "username text PRIMARY KEY,\n";*/
            String CreateCommentTable = "CREATE TABLE if not exists instagrim_KJL-KJL.Comment ("
//                    + " user varchar,"
                    + " picid uuid, "
                    + " comment text,"
                    + " PRIMARY KEY (picid)"
                    + ")";

//my code
            String CreateAddressType = "CREATE TYPE if not exists instagrim_KJL-KJL.address (\n"
                    + "      street text,\n"
                    + "      city text,\n"
                    + "      zip int\n"
                    + "  );";
            String CreateUserProfile = "CREATE TABLE if not exists instagrim_KJL-KJL.userprofiles (\n"
                    + "      login text PRIMARY KEY,\n"
                     + "     password text,\n"
                    + "      first_name text,\n"
                    + "      last_name text,\n"
                    + "      email set<text>,\n"
                    + "      addresses  map<text, frozen <address>>\n"
                    + "  );";
            Session session = c.connect();
            try {
                PreparedStatement statement = session
                        .prepare(createkeyspace);
                BoundStatement boundStatement = new BoundStatement(
                        statement);
                ResultSet rs = session
                        .execute(boundStatement);
                System.out.println("created instagrim_KJL ");
            } catch (Exception et) {
                System.out.println("Can't create instagrim_KJL " + et);
            }

            //now add some column families 
            
            System.out.println("" + CreatePicTable);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreatePicTable);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create tweet table " + et);
            }
            
            System.out.println("" + Createuserpiclist);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(Createuserpiclist);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create user pic list table " + et);
            }
// my code           
            System.out.println("" + CreatePhotoTable);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreatePhotoTable);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create tweet table " + et);
            }
            
            System.out.println("" + Createuserphotolist);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(Createuserphotolist);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create user photo list table " + et);
            }
            
            System.out.println("" + CreateCommentTable);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateCommentTable);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create tweet table " + et);
            }
            
           /* System.out.println("" + Createusernamelist);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(Createusernamelist);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create username list table " + et);
            }*/
//my code            
            
            System.out.println("" + CreateAddressType);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateAddressType);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create Address type " + et);
            }
            
            System.out.println("" + CreateUserProfile);
            try {
                SimpleStatement cqlQuery = new SimpleStatement(CreateUserProfile);
                session.execute(cqlQuery);
            } catch (Exception et) {
                System.out.println("Can't create Address Profile " + et);
            }
            session.close();

        } catch (Exception et) {
            System.out.println("Other keyspace or coulm definition error" + et);
        }

    }
}
