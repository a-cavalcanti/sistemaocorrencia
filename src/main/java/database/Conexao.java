package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao{
	
	public static Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String stringConexao ="jdbc:mysql://127.0.0.1/ocorrencia?user=root&password=";
		Connection connection = DriverManager.getConnection(stringConexao);		
		return connection;
	}
	
	public static ResultSet getResultSet(Connection conn, String sql) throws SQLException{		
		Statement query = conn.createStatement();		
		return query.executeQuery(sql);
	}
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) throws SQLException{
		return conn.prepareStatement(sql);
	}
}