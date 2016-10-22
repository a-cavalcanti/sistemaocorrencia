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

	$('.bt-nao').click(function(event){
		event.preventDefault();
		$('#exclusao').fadeOut(800);

	});

});

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