$(document).ready(function(){ 

	carregar();


	jQuery('#form-add-estudante').submit(function(){
		loadIn();
			var dados = jQuery(this).serialize();
			jQuery.ajax({
				type: "POST",
				url: "AdicionarEstudante",
				data: dados,
				success: function(data)
				{ 
					$('#form-add-estudante').each(function(){
  					this.reset();
					});
					loadOut();
					mensagem(data);
				}
			});
			return false;
	});


	jQuery('#form-update-estudante').submit(function(){

		loadIn();
			var dados = jQuery(this).serialize();
			jQuery.ajax({
				type: "POST",
				url: "AtualizarEstudante",
				data: dados,
				success: function(data)
				{ 
					$('#form-update-estudante').each(function(){
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
				url: "ExcluirEstudante",
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
			$('#listaEstudantes').load("ListaEstudantes");
		}



});