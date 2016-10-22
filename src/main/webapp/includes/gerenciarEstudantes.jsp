<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="header-conteudo">
		<h2>Estudantes &rsaquo; Gerenciar</h2>
	</div>
<div class="conteudo">
	

		<section id="exclusao">
				<h3>Deseja excluir: <span></span></h3>
				<form id="form-excluir">
					<input type="hidden" id="id-exclude" name="id_estudante">
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
				<th>Ano Curso</th> 
				<th>Opções</th> 
			</tr> 
		</thead> 
		
		<tbody id='listaEstudantes' class="tabela-fotos"> 
		
			 
		
		</tbody> 
	</table>
</div>

<script src="src/js/controller-estudante.js"></script>