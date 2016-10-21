	function initialize() {

  // Exibir mapa;
  var myLatlng = new google.maps.LatLng(-8.420369, -37.048186);
  var mapOptions = {
    zoom: 15,
    center: myLatlng,
    panControl: false,
    // mapTypeId: google.maps.MapTypeId.ROADMAP
    mapTypeControlOptions: {
      mapTypeIds: [google.maps.MapTypeId.ROADMAP, 'map_style']
    }
  }


  // Parâmetros do texto que será exibido no clique;
  var contentString = '<h2>CLIMEL - Climatização e Elétrica</h2>' +
  '<p>Rua Padre Roma, 373 Centro - Arcoverde - Pernambuco CEP: 56505-330 contato@climel.eng.br</p>';
  var infowindow = new google.maps.InfoWindow({
      content: contentString,
      maxWidth: 700
  });


  // Exibir o mapa na div #mapa;
  var map = new google.maps.Map(document.getElementById("mapa"), mapOptions);


  // Marcador personalizado;
  var image = 'src/img/mapa.svg';
  var marcadorPersonalizado = new google.maps.Marker({
      position: myLatlng,
      map: map,
      icon: image,
      title: 'Climel',
      animation: google.maps.Animation.DROP
  });


  // Exibir texto ao clicar no ícone;
  google.maps.event.addListener(marcadorPersonalizado, 'click', function() {
    infowindow.open(map,marcadorPersonalizado);
  });


  // Estilizando o mapa;
  // Criando um array com os estilos
  var styles = [
    {
      stylers: [
        { hue: "#121212" },
        { saturation: 60 },
        { lightness: -20 },
        { gamma: 1.51 }
      ]
    },
    {
      featureType: "road",
      elementType: "geometry",
      stylers: [
        { lightness: 100 },
        { visibility: "simplified" }
      ]
    },
    {
      featureType: "road",
      elementType: "labels"
    }
  ];

  /* crio um objeto passando o array de estilos (styles) e definindo um nome para ele;
  var styledMap = new google.maps.StyledMapType(styles, {
    name: "Mapa Style"
  });

  // Aplicando as configurações do mapa
  map.mapTypes.set('map_style', styledMap);
  map.setMapTypeId('map_style'); */

}


// Função para carregamento assíncrono
function loadScript() {
  var script = document.createElement("script");
  script.type = "text/javascript";
  script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyDgplJgMZ9rompVNR41r6pLsGzFKbB9sQE&sensor=true&callback=initialize";
  document.body.appendChild(script);
}

window.onload = loadScript;


