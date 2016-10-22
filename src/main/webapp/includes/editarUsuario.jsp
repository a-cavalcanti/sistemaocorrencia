<div class="header-conteudo">
		<h2>Usuários &rsaquo; Editar</h2>
	</div>
<div class="conteudo">
<%
	int id = (Integer) request.getSession().getAttribute("idUsuario");
	String nome = (String) request.getSession().getAttribute("nomeUsuario");
	String email = (String) request.getSession().getAttribute("emailUsuario");
	String senha = (String) request.getSession().getAttribute("senhaUsuario");	

%>

	<div class="formulario">
		<form id="form-update-usuario">
		
		<input type="hidden" name="id_usuario" value="<%=id %>"/>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="">Nome:</label>
						<input type="text" class="form-control" id="nome" name="nome" value="<%=nome %>">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="">E-mail:</label>
						<input type="email" class="form-control" id="email" name="email" value="<%= email %>">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label for="">Senha:</label>
						<input type="password" class="form-control" id="senha" name="senha" value="<%= senha %>">
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label for="">Confirme a senha:</label>
						<input type="password" class="form-control" id="senha-conf" name="confirmaSenha">
					</div>
				</div>
			</div>

			<button type="submit" class="btn bt-padrao">SALVAR ALTERAÇÕES</button>
		</form>
	</div>
</div>