document.addEventListener('DOMContentLoaded',()=>{

  
  const librosContainer = document.querySelector('#librosContainer');

  const shuffle = (array) =>{
    array.sort(()=> Math.random() - 0.5);
  }
  
  fetch('./public/data/heroes.json')
  .then(response => responde.json)
  .then(data=>{

    data.array.forEach(libros => {
      librosContainer.innerHTML += `
      <div class="wrapper">
        <div class="card front-face">
            <img src="./public/assets/${libros.id}.jpg">
        </div>
        <div class="card back-face">
            <img src="./public/assets/${libros.id}.jpg">
            <div class="info">
                <div class="title">
                    CodingLab</div>
                <p>
                    ${libros.superhero}and <br>${libros.superhero}</p>
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
    });
    console.log(data);
  })
})