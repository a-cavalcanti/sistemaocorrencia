package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Estudante;

public class OperacaoEstudante {
	public void adicionarEstudante(Estudante estudante) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_estudante");
		sql.append(" (nome, anoCursoAtual) values (?,?)");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, estudante.getNome());
		statement.setString(2, estudante.getAnoCursoAtual());
		statement.executeUpdate();
		
	}
	public ArrayList<HashMap<String, String>> listaEstudantes() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbl_estudante");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<HashMap<String, String>> conteudo = new ArrayList<HashMap<String, String>>();				
		
		while(resultSet.next()){
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("id", String.valueOf(resultSet.getInt("id")));
			campos.put("nome",resultSet.getString("nome"));
			campos.put("anoCursoAtual",resultSet.getString("anoCursoAtual"));
			conteudo.add(campos);			
		}
		return conteudo;		
	}
	
	public void updateEstudante(int id, Estudante estudante) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_estudante SET nome = ?, anoCursoAtual = ? WHERE id = ?");		
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, estudante.getNome());
		statement.setString(2, estudante.getAnoCursoAtual());
		statement.setInt(3, id);
		statement.executeUpdate();		
	}
	
	public void deleteEstudante(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tbl_estudante WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setInt(1, id);
		statement.executeUpdate();		
	}
}
