package Integracion;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatos {

  public static void main(String[] args) {
	        try {
	            Class.forName("org.postgresql.Driver");
	        }
	        catch (java.lang.ClassNotFoundException e) {
	            System.out.println(e.getMessage() + "hola");
	        }
//postgres://username:password@hostname/databasename
//postgres://roxvyxky:CaCHvDgMsN8NKdbu6dvD@babar.elephantsql.com:5432/roxvyxky
	       
//"jdbc:postgresql://host:port/database"
//"jdbc:postgresql://echo.db.elephantsql.com:5432/pbfpjmdk
	        
//String url = "jdbc:postgresql://" + uri.getHost() + ":" + uri.getPort() + uri.getPath();
	        
	        String url ="jdbc:postgresql://echo.db.elephantsql.com:5432/pbfpjmdk";
	        String username = "pbfpjmdk";
	        String password = "e9C7qfGQpYjxj3UtrGHPfmehbBuO73I3";

	        try {
	        	System.out.println("daskdjkasjdsakl");
	            Connection db = DriverManager.getConnection(url, username, password);
	            Statement st = db.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM public.profesor LIMIT 100");
	            while (rs.next()) {
	                System.out.print("Column 1 returned ");
	                System.out.println(rs.getString(2));
	                System.out.print("Column 2 returned ");
	                System.out.println(rs.getString(3));	              
	            }
	           
	            rs.close();
	            st.close();
	            }
	        catch (java.sql.SQLException e) {
	            System.out.println(e.getMessage() + "adios");
	        }
	    }

	}

