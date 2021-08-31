<%-- 
    Document   : productosAdmin
    Created on : 29-ago-2021, 14:43:13
    Author     : Leonardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Categorias</title>
        <link rel="stylesheet" href="css/stylesLayout.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body>
     
        <!--Cabecera de la página-->
        <header>
            <div id="logotipo">
                <!--Logotipo Django-->
                <img src="img/carioco.jpeg">
                <h1>Pollería El Carioco</h1>
            </div>
        </header>
        <!--Barra de navegación-->
        <nav>
            <ul>
                <c:forEach var="menuLista" items="${listadoMenu}">
                    <li>
                        <a href="<c:url value="${menuLista.getRutaMenu()}"></c:url>">${menuLista.getDesMenu()}</a>
                            <!---->
                        </li>
                </c:forEach>
                <li>
                    <a href="#">Usuario: ${datosUsuario.getMailUser()}</a>
                </li>
                <li>
                    <a href="controladorValidar?accion=cerrar">Cerrar sesión</a>
                </li>
            </ul>

        </nav>
        <div class="barra">
            <span class="esquina-izquierda"></span>
            <span class="relleno-barra"></span>
            <span class="esquina-derecha"></span>      
        </div>
        <div id="contenido" class="mt-5">
            <h1 class="title-content">Productos</h1>
            <div id="opcionesContent" class="col-lg-12 d-flex">
                <form class="form-inline col-lg-8 justify-content-center" action="ControladorProducto?menu=producto" method="POST">

                    <input class="form-control me-2 mr-3 col-lg-6" type="search" value="${productoBuscado}" name="productoBuscado" placeholder="Filtra por nombre o descripción" aria-label="Search">
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Categoria</label>
                                <select class="form-select" name="listCats" id="listCatsid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                </select>

                            </div>
                        </div>
                    </div>
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Estado</label>
                                <select class="form-select" name="estadoPro" id="floatingSelectGrid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                    <!--El atributo recibido es 1,2? seleccionate-->
                                    <option value="1"${proEstado=='1' ? 'selected':''}>Visible</option>
                                    <option value="2"${proEstado=='2' ? 'selected':''}>Oculto</option>
                                </select>

                            </div>
                        </div>
                    </div>
                    <button class="btn btn-outline-success" name="accion" value="Buscar" type="submit">Buscar</button>
                </form> 
                <div class="col-lg-5 "> 
                    <a class="btn align-self-center float-right" id="addElement" onclick="abrirAddPro()">Agregar nuevo</a>                    
                </div>
            </div>
            <table class="table table-hover mt-5 col-lg-12" id="tablaProducto">
                <thead class="text-center">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Cat.</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Descrip.</th>
                        <th scope="col">Precio</th>
                        <th scope="col" id="thImagen">Img</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                    <c:forEach var="proElemento" items="${listaProductos}">
                        <tr>
                            <th scope="row">${proElemento.getIdPro()}</th>
                            <td>${proElemento.getDesCat()}</td>
                            <td>${proElemento.getNomPro()}</td>
                            <td>${proElemento.getDescPro()}</td>
                            <td>${proElemento.getPrecioPro()}</td>
                            <td id="tdImagen"><img src="img/productos/${proElemento.getImgPro()}" style="width: 100px; height: 100px;" ></td>
                            <td>${proElemento.getProEstadoDes()}</td>
                            <td class="d-flex justify-content-center">
                                <a href="#" class="btn btn-danger mr-2" onclick="revisarEliminar(${proElemento.getIdPro()}, event)">Eliminar</a>
                                <a href="#" onclick="revisarEditar(${proElemento.getIdPro()}, event)"  class="btn btn-primary mr-2">Editar</a>
                                <c:choose>
                                    <c:when test="${proElemento.getProEstadoDes() eq 'Oculto'}">
                                        <a href="#" class="btn btn-success mr-2" onclick="revisarVisible(${proElemento.getIdPro()}, event)">Visible</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" class="btn btn-dark mr-2" onclick="revisarOcultar(${proElemento.getIdPro()}, event)" >Ocultar</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>

        <!--Modal para agregar Pro-->

        <div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agrega producto</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalAddPro">
                        ...
                    </div> 
                    <div class="alert alert-danger text-center d-none" id="msg-alert" role="alert">
                        <p>${msgerror}</p>
                    </div>
                </div>
            </div>
        </div>

        <!--Hiden Form-->
        <div class="modal fade"  id="myModalEdit" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Editar producto</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalEditCat">
                        <h2 style="text-align: center">Editar Producto</h2>
                        <form method="POST" action="ControladorProducto?menu=producto" class="form-horizontal col-lg-6" style="margin: 0 auto;">
                            <div class="mb-3">
                                <div class="form-floating">
                                    <label for="floatingSelectGrid">Categoria</label>
                                    <select class="form-select" name="listCats3" id="listCatsid3" aria-label="Floating label select example">
                                        <option selected value="-1">Todos</option>
                                    </select>
                                </div>
                            </div>
                            <div class="mb-3">
                                <input type="text" name="nombrepro" class="form-control" id="nombre-pro" aria-describedby="emailHelp" required="required" placeholder="Nombre producto">
                            </div>

                            <div class="mb-3">
                                <input type="text" name="despro" class="form-control" id="des-pro" aria-describedby="emailHelp" required="required" placeholder="Descripción producto">
                            </div>

                            <div class="mb-3">
                                <input type="number" step="any" min="0" name="preciopro" pattern="[0-9.]+" class="form-control" id="precio-pro" aria-describedby="emailHelp" required="required" placeholder="Ejemplo: 54.4">
                            </div>

                            <div class="mb-3">
                                <input type="file"  name="imgpro" class="form-control" id="img-pro" aria-describedby="emailHelp" placeholder="Img">
                            </div>

                            <div class="mb-3">
                                <input type="text"  name="imgproprevious" class="form-control" id="imgprevious-pro" aria-describedby="emailHelp" readonly="" placeholder="Img">
                            </div>

                            <div class="text-center">
                                <input type="submit" id="btn-addpro" class="btn btn-success" name="accion" value="Editar">    
                            </div>
                        </form>
                    </div> 
                    <div class="alert alert-danger text-center d-none" id="msg-alert2" role="alert">
                        <p>${msgerror}</p>
                    </div>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            //Cargar Categorias

            window.addEventListener('load', function () {
                var openit =<%=request.getAttribute("openit")%>;
                var openit2 =<%=request.getAttribute("openit2")%>;

                var cid = <%=request.getAttribute("catbu")%>;
                $.ajax({
                    url: "ControladorProducto?menu=producto&&accion=LCats",
                    method: "POST",
                    success: function (data, textStatus, jqXHR) {
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            const $select = document.querySelector("#listCatsid");
                            const option = document.createElement('option');
                            option.value = value.idCat;
                            option.text = value.desCat;
                            $select.appendChild(option);
                            if (option.value === cid) {
                                option.selected = true;
                            }
                        })
                    }
                });

                if (openit !== null) {
                    var divAlert = document.getElementById("msg-alert");
                    divAlert.classList.remove("d-none");
                    abrirAddPro();
                }

                if (openit2 !== null) {
                    var divAlert2 = document.getElementById("msg-alert2");
                    divAlert2.classList.remove("d-none");
                    $('#myModalEdit').modal({backdrop: 'static', keyboard: false})
                    $("#myModalEdit").modal('show');
                }

            });

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

        </script>                     
        <script type="text/javascript" src="js/jquery/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.all.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.all.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.locales.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.locales.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.min.js"></script>                        
    </body>
</html>

