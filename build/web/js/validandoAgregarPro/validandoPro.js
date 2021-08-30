/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var botonRegistro = document.querySelector("#btn-addpro");
botonRegistro.addEventListener('click', function (event) {
    var preciopro = document.querySelector("#precio-pro").value;
    if (!isNaN(preciopro.trim())) {
        alert("Precio incorrecto");
        event.preventDefault();
    }
    else if(!isNaN(preciopro.trim()) && preciopro=="."){
        
    }
});

