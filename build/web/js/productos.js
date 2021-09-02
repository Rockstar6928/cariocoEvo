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

function abrirAddPro() {

    document.getElementById("modalAddPro").innerHTML = "";
    $('#myModal').modal({backdrop: 'static', keyboard: false})
    $("#myModal").modal('show');
    $("#modalAddPro").load("agregarProducto.jsp");
    $('#myModal').on('shown.bs.modal', function (e) {
        $.ajax({
            url: "ControladorProducto?menu=producto&&accion=LCats",
            method: "POST",
            success: function (data, textStatus, jqXHR) {
                let obj = $.parseJSON(data);
                $.each(obj, function (key, value) {
                    const $select = document.querySelector("#listCatsid2");
                    const option = document.createElement('option');
                    option.value = value.idCat;
                    option.text = value.desCat;
                    $select.appendChild(option);
                })
            }
        });
    })
}
;

function revisarOcultar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de ocultarla?",
        message: "Cuando confirmes este producto, no será mostrado para el cliente!",
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
                window.location.href = 'ControladorProducto?menu=producto&&accion=Ocultar&&id=' + i + '';
            }
        }
    });
}
;

function revisarVisible(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de mostrarla?",
        message: "Cuando confimes este producto, será mostrado para el cliente!",
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
                window.location.href = 'ControladorProducto?menu=producto&&accion=Visible&&id=' + i + '';
            }
        }
    });
}
;

function revisarEliminar(i, event) {
    event.preventDefault();
    bootbox.confirm({
        title: "¿Seguro de eliminarla?",
        message: "Cuando confimes este producto, será eliminado del registro general!",
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
                window.location.href = 'ControladorProducto?menu=producto&&accion=Eliminar&&id=' + i + '';
            }
        }
    });
}
;

function revisarEditar(i, event) {
    event.preventDefault();
    var elementos = [];
    $.ajax({
        url: 'ControladorProducto?menu=producto&&accion=obtenerDatos',
        method: "POST",
        data: {id: i},
        success: function (data) {
            let obj = $.parseJSON(data);
            console.log(obj);
            $.each(obj, function (key, value) {
                elementos.push([value.idCat], [value.nomPro], [value.descPro], [value.precioPro], [value.imgPro]);
            });


            var nombrepro = document.getElementById("nombre-pro");
            var despro = document.getElementById("des-pro");
            var preciopro = document.getElementById("precio-pro");
            var imgpro = document.getElementById("imgprevious-pro");

            console.log(elementos[0].toString());
            nombrepro.value = elementos[1];
            despro.value = elementos[2];
            preciopro.value = elementos[3];
            imgpro.value = elementos[4];

            $.ajax({
                url: "ControladorProducto?menu=producto&&accion=LCats",
                method: "POST",
                success: function (data, textStatus, jqXHR) {
                    let obj = $.parseJSON(data);
                    $.each(obj, function (key, value) {
                        const $select = document.querySelector("#listCatsid3");
                        const option = document.createElement('option');
                        option.value = value.idCat;
                        option.text = value.desCat;
                        $select.appendChild(option);
                        if (option.value === elementos[0].toString()) {
                            option.selected = true;
                        }
                    })

                }
            });

            $('#myModalEdit').modal({backdrop: 'static', keyboard: false})
            $("#myModalEdit").modal('show');

        }
    });
}
;