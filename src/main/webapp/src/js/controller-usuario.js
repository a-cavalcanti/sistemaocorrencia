$(document).ready(function(){ 

	carregar();


	jQuery('#form-add-usuario').submit(function(){
		loadIn();
			var dados = jQuery(this).serialize();
			jQuery.ajax({
				type: "POST",
				url: "AdicionarUsuario",
				data: dados,
				success: function(data)
				{ 
					$('#form-add-usuario').each(function(){
  					this.reset();
					});
					loadOut();
					mensagem(data);
				}
			});
			return false;
	});


	jQuery('#form-update-usuario').submit(function(){

		loadIn();
			var dados = jQuery(this).serialize();
			jQuery.ajax({
				type: "POST",
				url: "AtualizarUsuario",
				data: dados,
				success: function(data)
				{ 
					$('#form-update-usuario').each(function(){
  					this.reset();
					});
					loadOut();
					mensagem(data);
				}
			});
			return false;
	});

	jQuery('#form-excluir').submit(function(){
			loadIn();
			var dados = jQuery(this).serialize();
			jQuery.ajax({
				type: "POST",
				url: "ExcluirUsuario",
				data: dados,
				success: function(data)
				{	
					carregar();
					$('#exclusao').fadeOut(10);
					$('#form-excluir').each(function(){
  					this.reset();
					});
					loadOut();
					mensagem(data);

					
				}
			});
			
			return false;
		});

		function carregar(){
			$('#listaUsuarios').load("ListaUsuarios");
		}



});