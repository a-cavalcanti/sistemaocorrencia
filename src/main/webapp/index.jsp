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