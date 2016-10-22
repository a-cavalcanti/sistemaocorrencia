package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import classes.Usuario;

public class OperacaoUsuario {
	
	public void adicionarUsuario(Usuario usuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USUARIO");
		sql.append(" (nome, email, senha) values (?,?,?)");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.executeUpdate();		
	}
	
	public ArrayList<HashMap<String, String>> listaUsuarios() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIO");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<HashMap<String, String>> conteudo = new ArrayList<HashMap<String, String>>();				
		
		while(resultSet.next()){
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("id", String.valueOf(resultSet.getInt("id")));
			campos.put("nome",resultSet.getString("nome"));
			campos.put("email",resultSet.getString("email"));
			campos.put("senha",resultSet.getString("senha"));
			conteudo.add(campos);			
		}
		return conteudo;		
	}
	
	public Usuario listaUsuarioId(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USUARIO WHERE id = ? ");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		ArrayList<String> conteudo = new ArrayList<String>();	
		
		Usuario user = new Usuario();
		
		while(resultSet.next()){
			
			user.setEmail(resultSet.getString("email"));
			user.setNome(resultSet.getString("nome"));
			user.setSenha(resultSet.getString("senha"));
			user.setId(resultSet.getInt("id"));
			
		}
		return user;		
	}
	
	public void updateUsuario(int id, Usuario usuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.setInt(4, id);
		statement.executeUpdate();		
	}
	
	public void deleteUsuario(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM usuario WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setInt(1, id);
		statement.executeUpdate();		
	}
}
