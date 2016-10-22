package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.OperacaoEstudante;

/**
 * Servlet implementation class ListaEstudantes
 */
public class ListaEstudantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEstudantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		OperacaoEstudante oe = new OperacaoEstudante();
		ArrayList<HashMap<String, String>> lista = new ArrayList<HashMap<String,String>>();
		try {
			lista = oe.listaEstudantes();
			PrintWriter writer = response.getWriter();
			
			for (int i = 0; i < lista.size(); i++) {
				writer.print("<tr>");
				writer.print("<th scope='row'>"+ lista.get(i).get("id") +"</th>");
				writer.print("<td>"+ lista.get(i).get("nome") +"</td>");
				writer.print("<td>"+ lista.get(i).get("anoCursoAtual") +"</td> ");
				writer.print("<td class='ops'>");
				writer.print("<a class='tooltips' data-toggle='tooltip' href='ListarEstudanteId?id="+ lista.get(i).get("id") +"' data-placement='right' title='Editar'>");
				writer.print("<div class='table-ops ativar bt-ativar' data-id=''></div>");
				writer.print("</a>");
				writer.print("<div class='table-ops excluir bt-excluir' data-id='"+ lista.get(i).get("id") +"' data-info='"+ lista.get(i).get("nome") +"'></div>");
				writer.print("</td>");
				writer.print("</tr>");
			}
			
			writer.println("<script type='text/javascript'>jQuery(document).ready(function(){$('.tooltips').tooltip();$('.bt-excluir').click(function(event){event.preventDefault();var id=$(event.target).attr('data-id');var nome=$(event.target).attr('data-info');console.log(event.target);$('#exclusao h3 span').text(nome);$('#id-exclude').attr('value', id);$('#exclusao').fadeIn(800);});});</script>");
				
	
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
