package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Usuario;
import database.OperacaoUsuario;

/**
 * Servlet implementation class AtualizarUsuario
 */
public class AtualizarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarUsuario() {
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
		String cod = request.getParameter("id_usuario");
		int id = Integer.parseInt(cod);
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String confirmaSenha = request.getParameter("confirmaSenha");
		
		if (senha.equals(confirmaSenha)) {
			Usuario usuario = new Usuario();
			usuario.setId(id);
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			
			
			
			OperacaoUsuario op = new OperacaoUsuario();
			try {
				op.updateUsuario(id, usuario);
				imprime.write("Usuário atualizado com sucesso.");
				
				HttpSession session = request.getSession();
				session.setAttribute("idUsuario",usuario.getId());
				session.setAttribute("nomeUsuario",usuario.getNome());
				session.setAttribute("emailUsuario",usuario.getEmail());
				session.setAttribute("senhaUsuario",usuario.getSenha());
				
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
			
		}else{
			imprime.write("As senhas n�o conferem");
		}
	}

}
