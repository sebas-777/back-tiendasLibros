document.addEventListener('DOMContentLoaded', (event)=>{
  console.log(window.location.search.split('=')[1]);

  const libroId = window.location.search.split('=')[1];
  const librosDetailContainer = document.querySelector('#librosDetailContainer');

  fetch('./public/data/heroes.json')
  .then(response => responde.json)
  .then(data=>{

    const libroFinded = data.find(libro => libro.id === libroId)

    console.log("Hello Word");

    if(libroFinded){
      console.log("Hello Word");
      ibrosDetailContainer.innerHTML +=
      `
      <div class="wrapper">
        <div class="card front-face">
            <img src="./public/assets/${libroFinded.id}.jpg">
        </div>
        <div class="card back-face">
            <img src="./public/assets/${libroFinded.id}.jpg">
            <div class="info">
                <div class="title">
                    CodingLab</div>
                <p>
                    ${libros.superhero}and <br>${libroFinded.superhero}</p>
            </div>
            <ul>
                <a href="./libros-detail.html?=${libros.id}">ver</i></a>
                <a href="./comprar.html?=${libros.id}">Comprar</i></a>
                // <a href="#"><i class="fab fa-instagram"></i></a>
                // <a href="#"><i class="fab fa-youtube"></i></a>
            </ul>
        </div>
    </div>
      `
    }else{
      console.log("NO hELLO wORD");
          }
  });
})