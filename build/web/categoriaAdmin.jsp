<%-- 
    Document   : categoriaAdmin
    Created on : 26-ago-2021, 15:26:33
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
            <h1 class="title-content">Categorias</h1>
            <div id="opcionesContent" class="col-lg-12 d-flex">
                <form class="form-inline col-lg-6 justify-content-center" action="ControladorCategoria?menu=categoria" method="POST">

                    <input class="form-control me-2 mr-3 col-lg-6" type="search" value="${catBuscada}" name="categoriaBuscada" placeholder="Filtra por nombre" aria-label="Search">
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Estado</label>
                                <select class="form-select" name="estadoCate" id="floatingSelectGrid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                    <!--El atributo recibido es 1,2? seleccionate-->
                                    <option value="1"${catEstado=='1' ? 'selected':''}>Visible</option>
                                    <option value="2"${catEstado=='2' ? 'selected':''}>Oculta</option>
                                </select>

                            </div>
                        </div>
                    </div>


                    <button class="btn btn-outline-success" name="accion" value="Buscar" type="submit">Buscar</button>
                </form>
                <div class="col-lg-6 "> 
                    <a class="btn align-self-center float-right" id="addElement" onclick="abrirAddCat()">Agregar nueva</a>                    
                </div>
            </div>
            <table class="table table-hover mt-5 col-lg-10" id="tablaCategorias">
                <thead class="text-center">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                    <c:forEach var="catElemento" items="${listaCategorias}">
                        <tr>
                            <th scope="row" id="idCategoria">${catElemento.getIdCat()}</th>
                            <td>${catElemento.getDesCat()}</td>
                            <td>${catElemento.getCatEstadoDes()}</td>
                            <td class="d-flex justify-content-center">
                                <a href="#" class="btn btn-danger mr-2" onclick="revisarEliminar(${catElemento.getIdCat()}, event)">Eliminar</a>
                                <a href="#" onclick="revisarEditar(${catElemento.getIdCat()}, event)"  class="btn btn-primary mr-2">Editar</a>
                                <c:choose>
                                    <c:when test="${catElemento.getCatEstadoDes() eq 'Oculta'}">
                                        <a href="#" class="btn btn-success mr-2" onclick="revisarVisible(${catElemento.getIdCat()}, event)">Visible</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" class="btn btn-dark mr-2" onclick="revisarOcultar(${catElemento.getIdCat()}, event)" >Ocultar</a>
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
        <!--Modal para agregar Categoria-->

        <div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Agrega categoría</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalAddCat">
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
                        <h5 class="modal-title" id="exampleModalLabel">Editar categoría</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalEditCat">
                        <h2 style="text-align: center">Editar Categoría</h2>
                        <form method="POST" action="ControladorCategoria?menu=categoria" class="form-horizontal col-lg-6" style="margin: 0 auto;">
                            <input type="text" class="form-control mb-3" name="namecate" id="ideditcate" placeholder="Nombre categoría" required="">
                            <div class="text-center">
                                <input type="submit" id="btn-editcat" class="btn btn-success" name="accion" value="Editar">    
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

            window.addEventListener('load', function () {

                var openit =<%=request.getAttribute("openit")%>;
                var openit2 =<%=request.getAttribute("openit2")%>;

                if (openit !== null) {
                    var divAlert = document.getElementById("msg-alert");
                    divAlert.classList.remove("d-none");
                    abrirAddCat();
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
