<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="header-conteudo">
		<h2>Usuários &rsaquo; Gerenciar</h2>
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
		
		<tbody id='listaUsuarios' class="tabela-fotos"> 
		
			 
		
		</tbody> 
	</table>
</div>
<script src="src/js/controller-usuario.js"></script>