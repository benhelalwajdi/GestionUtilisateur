package com.wbh.base;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class BD {
    
    //Methode de connection 
        public static Connection getConnection() 
        {
          try  
          {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://127.0.0.1:8889/database",
                      "root","root");
               System.out.println("Database.getConnection() sucess");
              return con;
          }
          catch(ClassNotFoundException | SQLException ex) 
          {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
        }
      
        
        //methode de fermer de base de donnee 
      public static void close(Connection con) 
      {
          try  
          {
              con.close();
          }
          catch(Exception ex) 
          {
              System.out.println("Database.close() Error -->" + ex.getMessage());
          }
      }
}
