package database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import classes.Ocorrencia;
import database.Conexao;

public class OperacaoOcorrencia {

	
	public void adicionarOcorrencia(Ocorrencia ocorrencia) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tbl_ocorrencia");
		sql.append(" (data, horario, descricao, estudante, professor, materia) values (?,?,?,?,?,?)");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setDate(1, (Date) ocorrencia.getData());
		statement.setString(2, ocorrencia.getHorario());
		statement.setString(3, ocorrencia.getDescricao());
		statement.setInt(4, ocorrencia.getEstudante().getCodigo());
		statement.setInt(5, ocorrencia.getProfessor().getCodigo());
		statement.setInt(6, ocorrencia.getMateria().getCodigo());
		statement.executeUpdate();		
	}
	

	
	public ArrayList<HashMap<String, String>> listaOcorrencias() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{

		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM tbl_ocorrencia");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		ResultSet resultSet = statement.executeQuery();
		ArrayList<HashMap<String, String>> conteudo = new ArrayList<HashMap<String, String>>();				
		
		while(resultSet.next()){
			HashMap<String, String> campos = new HashMap<String, String>();
			campos.put("id", String.valueOf(resultSet.getInt("id")));
			campos.put("data", String.valueOf( resultSet.getDate("data")));
			campos.put("horario",resultSet.getString("horario"));
			campos.put("descricao",resultSet.getString("descricao"));
			campos.put("estudante",String.valueOf(resultSet.getInt("estudante")));
			campos.put("professor",String.valueOf(resultSet.getInt("professor")));
			campos.put("materia",String.valueOf(resultSet.getInt("materia")));
			conteudo.add(campos);			
		}
		return conteudo;		
	}
	
	public void updateOcorrencia(int id, Ocorrencia ocorrencia) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE tbl_ocorrencia SET data = ?, horario = ?, descricao = ?, estudante = ?, professor = ?, materia = ? WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());
		statement.setDate(1, (Date) ocorrencia.getData());
		statement.setString(2, ocorrencia.getHorario());
		statement.setString(3, ocorrencia.getDescricao());
		statement.setInt(4, ocorrencia.getEstudante().getCodigo());
		statement.setInt(5, ocorrencia.getProfessor().getCodigo());
		statement.setInt(6, ocorrencia.getMateria().getCodigo());
		statement.setInt(7, id);
		statement.executeUpdate();		
	}
	
	public void deleteOcorrencia(int id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Conexao conexao = new Conexao();		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM tbl_ocorrencia WHERE id = ?");
		PreparedStatement statement =  conexao.getPreparedStatement(conexao.getConnection(), sql.toString());		
		statement.setInt(1, id);
		statement.executeUpdate();		
	}
	

}
