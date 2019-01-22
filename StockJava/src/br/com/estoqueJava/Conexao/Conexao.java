package br.com.estoqueJava.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {


	public static Connection getConnection() throws SQLException{
		String user = "root";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc.mysql://localhost:3306/estoquejava"; 
		String password = "admin";
		
		Connection connection = DriverManager.getConnection(url, user, password); 

		return connection;

	}
}