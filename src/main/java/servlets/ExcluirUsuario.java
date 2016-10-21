package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OperacaoUsuario;

/**
 * Servlet implementation class ExcluirUsuario
 */
public class ExcluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExcluirUsuario() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter imprime = response.getWriter();
		String id = request.getParameter("id_usuario");
		OperacaoUsuario ou = new OperacaoUsuario();
		
		int cod = Integer.parseInt(id);
		
		if(id != null){
			try {
				ou.deleteUsuario(cod);
				imprime.print("Usuário deletado com sucesso.");
				
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
		}else{
			imprime.print("Ocorreu um problema.");
		}
		imprime.flush();

	}

}
