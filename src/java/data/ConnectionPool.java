/* 
 * Copyright 2018 Rene Bylander at WITC
 */

package data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Rene Bylander
 * @created Nov 6, 2017
 */
public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    private ConnectionPool(){
        try{
            InitialContext ic = new InitialContext();
            dataSource = (DataSource)ic.lookup("java:/comp/env/jdbc/pet_hotel");
        }
        catch(NamingException e){
            System.out.println("ConnectionPool: " + e);
        }
    }//end of constructor
    
    public static synchronized ConnectionPool getInstance(){
    
        if(pool == null){
            pool = new ConnectionPool();
        }
        return pool;
    }
    public Connection getConnection(){
        try{
            return dataSource.getConnection();
        }
        catch(SQLException e){
            System.out.println("Connection: " + e);
            return null;
        }
    }
    public void freeConnection(Connection c){
        try{
            c.close();
        }
        catch(SQLException e){
            System.out.println("freeConnection: " + e);
        }
    }
    
    

}//end of class
