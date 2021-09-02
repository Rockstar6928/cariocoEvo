/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function ocultarAlertas() {
    var divAlert = document.getElementById("msg-alert");
    var divAlert2 = document.getElementById("msg-alert2");
    divAlert.setAttribute("style", "display:none;");
    divAlert2.setAttribute("style", "display:none;");
}
;
function revisarEditar(i, event) {
    event.preventDefault();
    var elementos = [];
    $.ajax({
        url: 'ControladorCategoria?menu=categoria&&accion=obtenerDatos',
        method: "POST",
        data: {id: i},
        success: function (data) {
            let obj = $.parseJSON(data);
            $.each(obj, function (key, value) {
                elementos.push([value.desCat]);
            });
            var input = document.getElementById("ideditcate");
            input.value = elementos[0];
            $('#myModalEdit').modal({backdrop: 'static', keyboard: false})
            $("#myModalEdit").modal('show');
        }
    })
}
;
function abrirAddCat() {
    document.getElementById("modalAddCat").innerHTML = "";
    $('#myModal').modal({backdrop: 'static', keyboard: false})
    $("#myModal").modal('show');
    $("#modalAddCat").load("agregarCategoria.jsp");
}
;
function revisarOcultar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de ocultarla?",
        message: "Cuando confirmes esta categoría, no será mostrada para el cliente!",
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
                window.location.href = 'ControladorCategoria?menu=categoria&&accion=Ocultar&&id=' + i + '';
            }
        }
    });
}
;
function revisarVisible(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de mostrarla?",
        message: "Cuando confimes esta categoría, será mostrada para el cliente!",
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
                window.location.href = 'ControladorCategoria?menu=categoria&&accion=Visible&&id=' + i + '';
            }
        }
    });
}
;
function revisarEliminar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de eliminarla?",
        message: "Cuando confimes esta categoría, será eliminada del registro general!",
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
                window.location.href = 'ControladorCategoria?menu=categoria&&accion=Eliminar&&id=' + i + '';
            }
        }
    });
}
;



