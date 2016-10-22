package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Usuario;
import database.OperacaoUsuario;

/**
 * Servlet implementation class ListarUsuarioId
 */
public class ListarUsuarioId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuarioId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		int cod = Integer.parseInt(id);
		
		OperacaoUsuario ou = new OperacaoUsuario();
		
		Usuario usuario = new Usuario();
		
		try {
			usuario = ou.listaUsuarioId(cod);
			
			HttpSession session = request.getSession();
			session.setAttribute("idUsuario",usuario.getId());
			session.setAttribute("nomeUsuario",usuario.getNome());
			session.setAttribute("emailUsuario",usuario.getEmail());
			session.setAttribute("senhaUsuario",usuario.getSenha());
			
			response.sendRedirect("index.jsp?section=usuarios&op=editar");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
