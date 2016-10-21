package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.Usuario;
import database.Conexao;
import database.OperacaoOcorrencia;
import database.OperacaoUsuario;

/**
 * Servlet implementation class RecebeDados
 */
@WebServlet("/ListaUsuarios")
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			OperacaoUsuario ou = new OperacaoUsuario();
			ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String,String>>();
			lista = ou.listaUsuarios();
			PrintWriter writer = response.getWriter();
			
			for (int i = 0; i < lista.size(); i++) {
				writer.print("<tr>");
				writer.print("<th scope='row'>"+ lista.get(i).get("id") +"</th>");
				writer.print("<td>"+ lista.get(i).get("nome") +"</td>");
				writer.print("<td>"+ lista.get(i).get("email") +"</td> ");
				writer.print("<td class='ops'>");
				writer.print("<a class='tooltips' data-toggle='tooltip' data-placement='right' title='Ativar'>");
				writer.print("<div class='table-ops ativar bt-ativar' data-id=''></div>");
				writer.print("</a>");
				writer.print("<a class='tooltips' data-toggle='tooltip' data-placement='right' title='Desativar'>");
				writer.print("<div class='table-ops desativar bt-desativar' data-id=''></div>");
				writer.print("</a>");
				writer.print("</td>");
				writer.print("</tr>");
			}
				
				
	
			
			
			
			writer.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter imprime = response.getWriter();
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String confirmaSenha = request.getParameter("confirmaSenha");
		
		if (senha.equals(confirmaSenha)) {
			Usuario usuario = new Usuario();
			usuario.setNome(nome);
			usuario.setEmail(email);
			usuario.setSenha(senha);			
			OperacaoUsuario op = new OperacaoUsuario();
			try {
				HttpSession sessao = request.getSession();
				sessao.setAttribute("usuarios", op.listaUsuarios().get(0).get("nome"));
				response.sendRedirect("includes/gerenciarUsuarios.jsp");
				imprime.write("ok");
			} catch (InstantiationException e){
				e.printStackTrace();
				imprime.write("Erro"+e);
			}catch ( IllegalAccessException e) {
				e.printStackTrace();
			}catch( ClassNotFoundException e){
				e.printStackTrace();
			}catch( SQLException e){
				e.printStackTrace();
			}
		}else{
			imprime.write("Erro");
			imprime.write(senha);
			imprime.write(confirmaSenha);
		}
		
		
	}

}
