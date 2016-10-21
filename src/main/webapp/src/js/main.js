
$(document).ready(function(){ 

	carregar();


jQuery('#form-add-usuario').submit(function(){

			var dados = jQuery(this).serialize();

			jQuery.ajax({
				type: "POST",
				url: "AdicionarUsuario",
				data: dados,
				success: function(data)
				{ 
					console.log(data);
				}
			});
			return false;
			
		});

});

	function carregar(){
		$('#listaUsuarios').load("ListaUsuarios");
	}