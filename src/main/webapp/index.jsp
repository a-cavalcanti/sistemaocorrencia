<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">
<link rel="stylesheet" href="src/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="src/css/main.css">
<title>IFPE - Instituto Federal de Pernambuco - Campus Garanhuns - Sistema de Ocorrências</title>
</head>
<body>

		<div id="load" class="pelicula">
		<div class="sk-fading-circle">
		  <div class="sk-circle1 sk-circle"></div>
		  <div class="sk-circle2 sk-circle"></div>
		  <div class="sk-circle3 sk-circle"></div>
		  <div class="sk-circle4 sk-circle"></div>
		  <div class="sk-circle5 sk-circle"></div>
		  <div class="sk-circle6 sk-circle"></div>
		  <div class="sk-circle7 sk-circle"></div>
		  <div class="sk-circle8 sk-circle"></div>
		  <div class="sk-circle9 sk-circle"></div>
		  <div class="sk-circle10 sk-circle"></div>
		  <div class="sk-circle11 sk-circle"></div>
		  <div class="sk-circle12 sk-circle"></div>
		</div>
	</div>

	<div class="modal fade" tabindex="-1" role="dialog" id="modal">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">MENSAGEM</h4>
		      </div>
		      <div class="modal-body">
		       
		        	<div class="row">
		        		<div class="col-xs-12">
				        	<div class="ajax-html"></div>
				        </div>
		        	</div>
		       
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Ok</button>
		      </div>
		    </div>
		  </div>
		</div>
		
	<%@include file="includes/header.jsp" %>
	
	<section class="section-body main">
		<div class="container">
			<div class="row">
				<div class="col-sm-3">
					<%@include file="includes/aside.jsp" %>
				</div>
				<div class="col-sm-9">
					<%

					String section = (String) request.getParameter("section");
					String operacao = (String) request.getParameter("op"); 


					if(section != null){ 
						if(section.equals("usuarios")){
							if(operacao.equals("cadastrar")){
								%>
								<%@include file="includes/cadastroUsuario.jsp" %>
								<%
							}
							if(operacao.equals("gerenciar")){
								%>
								<%@include file="includes/gerenciarUsuarios.jsp" %>
								<%
							}
							if(operacao.equals("editar")){
								%>
								<%@include file="includes/editarUsuario.jsp" %>
								<%
							}
						}
						}else{%>
						<%@include file="includes/home.jsp" %>
						<%} %>
				</div>
			</div>
		</div>
	</section>
	
	
	<%@include file="includes/footer.jsp" %>



<script src="src/jquery/jquery-2.1.3.min.js"></script>
<script src="src/bootstrap/js/bootstrap.js"></script>
<script src="src/js/main.js"></script>
</body>
</html>