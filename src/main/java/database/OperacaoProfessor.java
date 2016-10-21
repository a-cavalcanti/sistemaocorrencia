package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Professor;

public class OperacaoProfessor {
	public void adicionarProfessor(Professor professor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_professor");
		sql.append(" (nome, formacao, siape, senha, funcao ) values (?,?,?,?,?)");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, professor.getNome());
		statement.setString(2, professor.getFormacao());
		statement.setInt(3, professor.getSiape());
		statement.setString(4, professor.getSenha());
		statement.setString(5, professor.getFuncao());
		statement.executeUpdate();		
	}
	
	public ArrayList<HashMap<String, String>> listaProfessores() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbl_professor");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<HashMap<String, String>> conteudo = new ArrayList<HashMap<String, String>>();				
		
		while(resultSet.next()){
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("id", String.valueOf(resultSet.getInt("id")));
			campos.put("nome",resultSet.getString("nome"));
			campos.put("formacao",resultSet.getString("formacao"));
			campos.put("siape",resultSet.getString("siape"));
			campos.put("senha",resultSet.getString("senha"));
			campos.put("funcao",resultSet.getString("funcao"));
			conteudo.add(campos);			
		}
		return conteudo;		
	}
	
	public void updateProfessor(int id, Professor professor) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario SET nome = ?, formacao = ?, siape = ?, senha = ?, funcao = ? WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, professor.getNome());
		statement.setString(2, professor.getFormacao());
		statement.setInt(3, professor.getSiape());
		statement.setString(4, professor.getSenha());
		statement.setString(5, professor.getFuncao());
		statement.setInt(6, id);
		statement.executeUpdate();			
	}
	
	public void deleteProfessor(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tbl_professor WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setInt(1, id);
		statement.executeUpdate();		
	}
}
