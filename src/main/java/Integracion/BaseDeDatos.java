package Integracion;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDatos {
	
	public static final String url ="jdbc:postgresql://echo.db.elephantsql.com:5432/pbfpjmdk";
	public static final String username = "pbfpjmdk";
	public static final String password = "e9C7qfGQpYjxj3UtrGHPfmehbBuO73I3";

	
	public void select(String query){//selects
	       	try {
	            Class.forName("org.postgresql.Driver");
	        }
	        catch (java.lang.ClassNotFoundException e) {
	            System.out.println(e.getMessage() + "hola");
	        }
	        try {
	        	System.out.println("daskdjkasjdsakl");
	            Connection db = DriverManager.getConnection(url, username, password);
	            Statement st = db.createStatement();
	            ResultSet rs = st.executeQuery(query);
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
	
	public void insertDelete(String query){
       	try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage() + "hola");
        }
       	
       	try{
       		System.out.println("daskdjkasjdsakl");
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            st.executeUpdate(query);  
            st.close();
       	}
       	catch(java.sql.SQLException e){
       		System.out.println(e.getMessage() + "adios");
       	}
	}
	
	public void update(String query){
		
	}
  
  	public static void main(String[] args) {
	
  	}
}
