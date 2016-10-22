package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Estudante;
import classes.Usuario;
import database.OperacaoEstudante;
import database.OperacaoUsuario;

/**
 * Servlet implementation class AdicionarEstudante
 */
public class AdicionarEstudante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarEstudante() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter imprime = response.getWriter();
		
		String nome = request.getParameter("nome");
		String ano = request.getParameter("ano-curso");
		
		
		
			Estudante estudante = new Estudante();
			estudante.setNome(nome);
			estudante.setAnoCursoAtual(ano);
			
			OperacaoEstudante op = new OperacaoEstudante();
			try {
				op.adicionarEstudante(estudante);
				imprime.write("Estudante adicionado com sucesso.");
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				imprime.write("Aconteceu um erro");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				imprime.write("Aconteceu um erro");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				imprime.write("Aconteceu um erro");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				imprime.write("Aconteceu um erro");
				e.printStackTrace();
			}
			

}
}
