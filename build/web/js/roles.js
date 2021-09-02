/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function revisarAsignar(i, event) {
    event.preventDefault();
    var elementos = [];
    var probar = [];
    $.ajax({
        url: 'ControladorPerfil?menu=perfil&&accion=obtenerDatos',
        method: "POST",
        data: {id: i},
        success: function (data) {
            let obj = $.parseJSON(data);
            $.each(obj, function (key, value) {
                elementos.push([value.desPerfil]);
            });
            var input = document.getElementById("perfilAsignarid");
            input.value = elementos[0];
            $('#myModalAsign').modal({backdrop: 'static', keyboard: false})
            $("#myModalAsign").modal('show');

            //Mostrar menu
            $.ajax({
                url: 'ControladorPerfil?menu=perfil&&accion=mostrarMenu',
                method: "POST",
                success: function (data, textStatus, jqXHR) {
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        probar.push([value.idMenu, value.desMenu]);
                    });
                    var tblBody = document.getElementById("bodytable");
                    $("#bodytable").empty();
                    for (var i = 0; i < obj.length; i++) {
                        var fila = document.createElement("tr");
                        fila.setAttribute("class", "text-center");
                        for (var j = 0; j < 2; j++) {
                            var celda = document.createElement("td");
                            textoCelda = document.createTextNode(probar[i][j]);
                            celda.appendChild(textoCelda);
                            fila.appendChild(celda);
                            if (j == 0)
                            {
                                celda.innerHTML = '<input type="checkbox" id="cb' + probar[i][0] + i + '" name="grupoOp" value="' + probar[i][0] + '">';
                            }
                        }
                        tblBody.appendChild(fila);
                    }
                }
            });

            //ValidarOp
            $.ajax({
                url: "ControladorPerfil?menu=perfil&&accion=obtenerOpciones",
                method: "POST",
                data: {id: i},
                success: function (data, textStatus, jqXHR) {
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        var c = document.getElementsByName("grupoOp");
                        for (var i = 0; i < c.length; i++) {
                            if (c[i].value == value.validandoMenu) {
                                c[i].checked = true;
                            }
                        }
                    });
                }
            });
        }
    });
}
;

function ocultarAlertas() {
    var divAlert = document.getElementById("msg-alert");
    var divAlert2 = document.getElementById("msg-alert2");
    divAlert.setAttribute("style", "display:none;");
    divAlert2.setAttribute("style", "display:none;");
}

function revisarOcultar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de deshabilitar?",
        message: "Cuando confirmes este perfil, los usuarios con este perfil no podrán ingresar!",
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> Cancel'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Confirm',
            }
        },
        callback: function (result) {
            if (result) {
                window.location.href = 'ControladorPerfil?menu=perfil&&accion=Ocultar&&id=' + i + '';
            }
        }
    });
}
;

function abrirAddRol() {
    document.getElementById("modalAddPerf").innerHTML = "";
    $('#myModal').modal({backdrop: 'static', keyboard: false})
    $("#myModal").modal('show');
    $("#modalAddPerf").load("agregarPerfil.jsp");
}
;

function revisarVisible(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de habilitar?",
        message: "Cuando confimes este perfil, los usuarios con este perfil podrán ingresar!",
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> Cancel'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Confirm',
            }
        },
        callback: function (result) {
            if (result) {
                window.location.href = 'ControladorPerfil?menu=perfil&&accion=Visible&&id=' + i + '';
            }
        }
    });
}
;

function revisarEliminar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de eliminar?",
        message: "Cuando confimes este perfil, se eliminarán los usuarios con este perfil!",
        buttons: {
            cancel: {
                label: '<i class="fa fa-times"></i> Cancel'
            },
            confirm: {
                label: '<i class="fa fa-check"></i> Confirm',
            }
        },
        callback: function (result) {
            if (result) {
                window.location.href = 'ControladorPerfil?menu=perfil&&accion=Eliminar&&id=' + i + '';
            }
        }
    });
}
;

function revisarEditar(i, event) {
    event.preventDefault();
    var elementos = [];
    $.ajax({
        url: 'ControladorPerfil?menu=perfil&&accion=obtenerDatos',
        method: "POST",
        data: {id: i},
        success: function (data) {
            let obj = $.parseJSON(data);
            $.each(obj, function (key, value) {
                elementos.push([value.desPerfil]);
            });
            var input = document.getElementById("ideditperfil");
            input.value = elementos[0];
            $('#myModalEdit').modal({backdrop: 'static', keyboard: false})
            $("#myModalEdit").modal('show');


        }
    })
}
;