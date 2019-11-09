package com.unapec.jsp.core;

import java.sql.*;  
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// https://www.oscarblancarteblog.com/2016/12/19/web-services-con-java-jax-ws/

// jnds
// https://www.codejava.net/servers/tomcat/configuring-jndi-datasource-for-database-connection-pooling-in-tomcat
// http://www.servlets.com/archive/servlet/ReadMsg?msgId=589907&listName=tomcat-dev
// https://stackoverflow.com/questions/15410804/how-to-get-the-resource-elements-through-context-object
// https://www.journaldev.com/2513/tomcat-datasource-jndi-example-java
public class DBManager {
     /**
     * Connect to a sample database
     */
    
        // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
    Statement stmt = null;
    Context ctx;
    Connection con;
    ResultSet rs;
    DataSource ds;
    
    public void setup() throws NamingException, SQLException {
//        System.out.println("Connecting to database "+DB_URL+" as "+USER+"/"+PASS+"...");
//        Context initContext = new InitialContext();
//        Context envContext = (Context) initContext.lookup("java:comp/env");
//        DataSource ds = (DataSource) envContext.lookup("jdbc/unapec_jsp");
//        Connection conn = ds.getConnection();
        
//        ctx = new InitialContext();
//        Context environmentContext = (Context)ctx.lookup("java:comp/env");
//        ds = (DataSource) environmentContext.lookup("jdbc/MyDB");
        ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");

        con = ds.getConnection();
        stmt = con.createStatement();
    }
    
    public boolean isUserValid(String user, String password) {
        System.out.println("Trying to find valid user!");
        try{
           // iterates over the result set...
            
           //STEP 2: Register JDBC driver
           //Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           //conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Execute a query
                        
           System.out.println("Creating statement...");
           stmt = con.createStatement();
           String sql;
           sql = "SELECT id, username, password FROM `usuarios` WHERE "
                   + "username='" + user + "' AND password='" + password + "'";
			System.out.println(sql);
           rs = stmt.executeQuery(sql);

           //STEP 5: Extract data from result set
           if(rs.next()){
              //Retrieve by column name
              int id  = rs.getInt("id");
              String first = rs.getString("username");
              String last = rs.getString("password");

              //Display values
//              System.out.print("ID: " + id);
//              System.out.print(", First: " + first);
//              System.out.println(", Last: " + last);
              return true;
           }
           //STEP 6: Clean-up environment
           rs.close();
           stmt.close();
           con.close();
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(con!=null)
                 con.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return false;
    }

    public int doMakeUser(String user, String password) {
        System.out.println("Trying to make new user!");
        try{
//           //STEP 2: Register JDBC driver
//           Class.forName("com.mysql.jdbc.Driver");
//
//           //STEP 3: Open a connection
//           System.out.println("Connecting to database...");
//           conn = DriverManager.getConnection(DB_URL,USER,PASS);
//
//           //STEP 4: Execute a query
//           System.out.println("Creating statement...");
           stmt = con.createStatement();
           String sql;
           sql = "SELECT id, username, password FROM `usuarios` WHERE "
                   + "username='" + user + "'";
           ResultSet rs = stmt.executeQuery(sql);

           //STEP 5: Extract data from result set
           if(!rs.next()){
                System.out.println("Trying to make new account...");
                sql = "INSERT INTO `usuarios` (`id`, `username`, `password`) VALUES (NULL, '"+user+"', '"+password+"'); ";
                System.out.println(sql);
                stmt.executeUpdate(sql);
                rs.close();
                stmt.close();
                con.close();
                return 2;
           } else {
                System.out.println("Account name already exists...");
                rs.close();
                stmt.close();
                con.close();
                return 1;
           }
           
           //STEP 6: Clean-up environment
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(con!=null)
                 con.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        System.out.println("Goodbye!");
        return 0;
    }

}
