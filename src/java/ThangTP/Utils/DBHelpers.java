/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangTP.Utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Admin
 */
public class DBHelpers implements Serializable{
    public static Connection makeConnection() 
        throws /*ClassNotFoundException*/ NamingException, SQLException{
        
        //get current context
        Context context = new InitialContext();
        
        //get container context = tomcat
        Context tomcatContext= (Context)context.lookup("java:comp/env");
        
        //get datasource
        DataSource ds = (DataSource)tomcatContext.lookup("JackCypher");
        
        //get connection
        if(ds !=null){
            Connection con= ds.getConnection();
            return con;
        }
        
        
//        // LOAD DRIVER
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        
//        // CONNECTION STRING
//        
//        String url = "jdbc:sqlserver://localhost:1433;databasename=sinhvien";
//        // OPEN CONNECTION
//        
//        Connection con = DriverManager.getConnection(url, "sa", "admin");
//        
//        return con;

        return null;
    }
}
