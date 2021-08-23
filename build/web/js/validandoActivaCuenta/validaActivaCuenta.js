/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

'use strict'
//Validando datos ingresados en el formulario en la vista "activaCuentaCliente"
var botonRegistro = document.querySelector("#btn-activa");
botonRegistro.addEventListener('click', function (event) {

    var codigo = document.querySelector("#codigo-activa").value;
    if (isNaN(codigo.trim())) {
        alert("Formato del código ingresado es incorrecto")
        event.preventDefault();
    }



});
