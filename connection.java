package connection;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connection {
	
	Connection con; 
	public connection()
	{
		
	
		  
			
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_ecole","root","");
			
			System.out.println("connection établie");
		
		} catch (Exception e) {
			
		
			System.out.println("Base de donnee introuvable");
		}
	}
	public Connection etablirconnection() {
		return con;
	}
	//savoir l'accès à la connection
	/*public static void main(String[] args) {
		
		connection p=new connection();
	
		//System.out.println(p.etablirconnection());
	}*/
	
	}
	

