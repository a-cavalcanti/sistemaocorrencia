ApplicationLoad = {
  init: function () {
    this.load_page();
  },

  load_page: function(){
    $(window).load(function(){
      $("#load").fadeOut(500).delay(500);
    });

  },

}

$(document).ready(function(){ 

	$('.tooltips').tooltip();

	ApplicationLoad.init();

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

$('.bt-nao').click(function(event){
				event.preventDefault();
				$('#exclusao').fadeOut(800);

			});

});

	function carregar(){
		$('#listaUsuarios').load("ListaUsuarios");
	}

	function mensagem(html){
    $('.ajax-html').html(html);
    $('#modal').modal('show');
}

function loadIn(){
    $("#load").fadeIn(500).delay(500);
}
function loadOut(){
    $("#load").fadeOut(500).delay(500);
}