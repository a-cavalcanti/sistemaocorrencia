console.log("Zabum Framework");

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

$(document).ready( function () { ApplicationLoad.init(); });