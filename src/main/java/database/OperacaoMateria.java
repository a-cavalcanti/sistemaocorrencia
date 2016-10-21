package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Materia;

public class OperacaoMateria {
	public void adicionarMateria(Materia materia) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_materia");
		sql.append(" (serie, nome) values (?,?)");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, materia.getSerie());
		statement.setString(2, materia.getNome());		
		statement.executeUpdate();		
	}
	
	public ArrayList<HashMap<String, String>> listaMaterias() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbl_materia");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<HashMap<String, String>> conteudo = new ArrayList<HashMap<String, String>>();				
		
		while(resultSet.next()){
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("id", String.valueOf(resultSet.getInt("id")));
			campos.put("nome",resultSet.getString("nome"));
			campos.put("serie",resultSet.getString("serie"));
			conteudo.add(campos);			
		}
		return conteudo;		
	}
	

	public void updateMateria(int id, Materia materia) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_materia SET serie = ?, nome = ? WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, materia.getSerie());
		statement.setString(2, materia.getNome());
		statement.setInt(3, id);
		statement.executeUpdate();		
	}
	
	public void deleteMateria(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tbl_materia WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setInt(1, id);
		statement.executeUpdate();		
	}
}
