/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
'use strict'
//Validando datos ingresados en el formulario en la vista "vistaRegistroCliente"
var botonRegistro = document.querySelector("#btn-register");
botonRegistro.addEventListener('click', function (event) {
    var dniCliente = document.querySelector("#dni-register").value;
    var celularCliente = document.querySelector("#celular-register").value;
    var pass1Cliente = document.querySelector("#password1-register").value;
    var pass2Cliente = document.querySelector("#password2-register").value;
    var nombresCliente = document.querySelector("#nombre-register").value;
    var apellidosCliente = document.querySelector("#apellidos-register").value;

    //Validando la password
    if (pass1Cliente !== pass2Cliente) {
        alert("Contraseñas no coinciden")
        event.preventDefault();
    }

    //Validando el DNI
    if (dniCliente.trim().length < 8) {
        alert("DNI ingresado, tiene menos de 8 dígitos")
        event.preventDefault();
    }

    //Validando el celular

    if (celularCliente.trim().length < 9) {
        alert("Celular ingresado, tiene menos de 9 dígitos")
        event.preventDefault();
    }

    //Validando nombres

    if (!isNaN(nombresCliente.trim())) {
        alert("Nombres incorrectos")
        event.preventDefault();
    }

    //Validando apellidos

    if (!isNaN(apellidosCliente.trim())) {
        alert("Apellidos incorrectos")
        event.preventDefault();
    }

});
