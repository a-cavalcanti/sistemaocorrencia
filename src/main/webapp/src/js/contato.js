jQuery(document).ready(function(){
		
jQuery('#form-contato').submit(function(){

			if($("#nome").val() == ""){
				mensagem("<h6>Preencha o campo <b>Nome</b>!</<h6>");
				return false;
			}else
			if($("#fone").val() == ""){
				mensagem("<h6>Preencha o campo <b>Fone</b>!</<h6>");
				return false;
			}else
			if($("#email").val() == ""){
				mensagem("<h6>Preencha o campo <b>E-mail</b>!</<h6>");
				return false;
			}
			else
			if($("#mensagem").val() == ""){
				mensagem("<h6>Preencha o campo <b>Mensagem</b>!</<h6>");
				return false;
			}else{

			var dados = jQuery(this).serialize();

			jQuery.ajax({
				type: "POST",
				url: "mail/mail.php",
				data: dados,
				success: function(data)
				{ 

					$('#container-mensagem').fadeIn(800).delay(4000);
					$('#container-mensagem').html(data);
					$('#container-mensagem').fadeOut(800);
					$('#form-contato').each(function(){
  					this.reset();
					});
				}
			});
			return false;
			}
			
		});

	});

function mensagem(str){
	$('#container-mensagem').fadeIn(800).delay(4000);
	$('#container-mensagem').html(str);
	$('#container-mensagem').fadeOut(800);
}


