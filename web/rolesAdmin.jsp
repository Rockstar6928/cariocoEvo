<%-- 
    Document   : rolesAdmin
    Created on : 30-ago-2021, 1:04:48
    Author     : Leonardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Roles</title>
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
            <h1 class="title-content">Roles</h1>
            <div id="opcionesContent" class="col-lg-12 d-flex">
                <form class="form-inline col-lg-6 justify-content-center" action="ControladorPerfil?menu=perfil" method="POST">
                    <input class="form-control me-2 mr-3 col-lg-6" type="search" value="${desperf}" name="perfilBuscado" placeholder="Filtra por nombre" aria-label="Search">
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Estado</label>
                                <select class="form-select" name="estadoPerfil" id="floatingSelectGrid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                    <!--El atributo recibido es 1,2? seleccionate-->
                                    <option value="1"${perfEstado=='1' ? 'selected':''}>Habilitado</option>
                                    <option value="2"${perfEstado=='2' ? 'selected':''}>Deshabilitado</option>
                                </select>

                            </div>
                        </div>
                    </div>
                    <button class="btn btn-outline-success" name="accion" value="Buscar" type="submit">Buscar</button>
                </form>
                <div class="col-lg-6 "> 
                    <a class="btn align-self-center float-right mr-2" id="addElement" onclick="abrirAddRol()">Agregar nuevo</a>
                </div>
            </div>
            <table class="table table-hover mt-5 col-lg-10" id="tablaCategorias">
                <thead class="text-center">
                <th scope="col">#</th>
                <th scope="col">Perfil</th>
                <th scope="col"># Usuarios</th>
                <th scope="col">Estado</th>
                <th scope="col">Acciones</th>
                </thead>
                <tbody class="text-center">
                    <c:forEach var="perfilElemento" items="${listaRoles}">
                        <tr>
                            <th scope="row">${perfilElemento.getIdPerfil()}</th>
                            <td>${perfilElemento.getDesPerfil()}</td>
                            <td>${perfilElemento.getContadorRoles()}</td>                                
                            <td>${perfilElemento.getPerfilEstadoDes()}</td>      
                            <td class="d-flex justify-content-center">
                                <a href="#" class="btn btn-danger mr-2" onclick="revisarEliminar(${perfilElemento.getIdPerfil()}, event)">Eliminar</a>
                                <a href="#" onclick="revisarEditar(${perfilElemento.getIdPerfil()}, event)"  class="btn btn-primary mr-2">Editar</a>
                                <c:choose>
                                    <c:when test="${perfilElemento.getPerfilEstadoDes() eq 'Deshabilitado'}">
                                        <a href="#" onclick="revisarVisible(${perfilElemento.getIdPerfil()}, event)"  class="btn btn-success mr-2">Habilitar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" onclick="revisarOcultar(${perfilElemento.getIdPerfil()}, event)"  class="btn btn-warning mr-2">Deshabilitar</a>        
                                        <a href="#" onclick="revisarAsignar(${perfilElemento.getIdPerfil()}, event)"  class="btn btn-dark mr-2">Asignar ops.</a>        
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
                        <h5 class="modal-title" id="exampleModalLabel">Agrega perfil</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalAddPerf">
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
                        <h5 class="modal-title" id="exampleModalLabel">Editar perfil</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalEditCat">
                        <h2 style="text-align: center">Editar Perfil</h2>
                        <form method="POST" action="ControladorPerfil?menu=perfil" class="form-horizontal col-lg-6" style="margin: 0 auto;">
                            <input type="text" class="form-control mb-3" name="nameperfil" id="ideditperfil" placeholder="Nombre categoría" required="">
                            <div class="text-center">
                                <input type="submit" id="btn-editperf" class="btn btn-success" name="accion" value="Editar">    
                            </div>
                        </form>
                    </div> 
                    <div class="alert alert-danger text-center d-none" id="msg-alert2" role="alert">
                        <p>${msgerror}</p>
                    </div>
                </div>
            </div>
        </div>

        <!--Hiden Form-->
        <div class="modal fade"  id="myModalAsign" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Asignar Ops</h5>
                        <button type="button" class="close" data-dismiss="modal" onclick="ocultarAlertas()" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body" id="modalEditCat">
                        <h2 style="text-align: center">Asignar Ops.</h2>
                        <form class="col-lg-6 form-horizontal" style="margin: 0 auto;" action="ControladorPerfil?menu=perfil" method="POST">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">PERFIL</span>
                                    </div>
                                    <input type="text" id="perfilAsignarid" value="" class="form-control" readonly>
                                </div>
                            </div>
                            <table style="margin-top:15px" class="table table-hover">
                                <thead class="thead-dark">
                                    <tr class="text-center">
                                        <th>Seleccionar</th>                   
                                        <th>Menú</th>                                          
                                    </tr>
                                </thead>
                                <tbody id="bodytable">

                                </tbody>
                            </table>
                            <div class="text-center">
                                <button type="submit" name="accion" value="AgregarMenu" class="btn btn-success" onclick ="return confirm('¿Está seguro?')">Agregar</button>
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
                    abrirAddRol();
                }

                if (openit2 !== null) {
                    var divAlert2 = document.getElementById("msg-alert2");
                    divAlert2.classList.remove("d-none");
                    $('#myModalEdit').modal({backdrop: 'static', keyboard: false})
                    $("#myModalEdit").modal('show');
                }
            });

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
