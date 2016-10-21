<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="header-conteudo">
		<h2>Usuários </h2>
	</div>
<div class="conteudo">
	

		<section id="exclusao">
				<h3>Deseja excluir: <span></span></h3>
				<form id="form-excluir">
					<input type="hidden" id="id-exclude" name="id_usuario">
					<input type="submit" value="SIM" class="bt-sim">
					<button class="bt-nao"> NÃO </button>
				</form>
	</section>

	<section id="load-form"></section>


	<table class="table table-hover table-striped"> 
		<thead class="tabela-fotos"> 
			<tr> 
				<th>Código</th> 
				<th>Nome</th> 
				<th>E-mail</th> 
				<th>Opções</th> 
			</tr> 
		</thead> 
		<% String array = (String)  request.getSession().getAttribute("usuarios"); %>
		<tbody id='listaUsuarios' class="tabela-fotos"> 
		
			 <tr> 
				<th scope="row"></th> 
				<td>${array}</td> 
				<td></td> 
				<td class="ops">
					<a class="tooltips" data-toggle="tooltip" data-placement="right" title="Ativar">
						<div class="table-ops ativar bt-ativar" data-id=""></div>
					</a>
					<a class="tooltips" data-toggle="tooltip" data-placement="right" title="Desativar">
						<div class="table-ops desativar bt-desativar" data-id=""></div>
					</a>
				</td> 
			</tr>
		
		</tbody> 
	</table>
</div>