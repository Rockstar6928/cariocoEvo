<%-- 
    Document   : trabajadorAdmin
    Created on : 01-sep-2021, 19:38:19
    Author     : Leonardo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <h1 class="title-content">Empleados</h1> 
            <div id="opcionesContent" class="col-lg-12 d-flex">
                <form class="form-inline col-lg-8 justify-content-center" action="ControladorProducto?menu=producto" method="POST">

                    <input class="form-control me-2 mr-3 col-lg-6" type="search"  name="productoBuscado" placeholder="Filtra por mail / nombres / dni / celular" aria-label="Search">
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Perfil</label>
                                <select class="form-select" name="listPerfiles" id="listPerfilesid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                </select>

                            </div>
                        </div>
                    </div>
                    <div class="row g-2 mr-2">
                        <div class="col-md">
                            <div class="form-floating">
                                <label for="floatingSelectGrid">Estado</label>
                                <select class="form-select" name="estadoEmp" id="floatingSelectGrid" aria-label="Floating label select example">
                                    <option selected value="-1">Todos</option>
                                    <!--El atributo recibido es 1,2? seleccionate-->
                                    <option value="1"${proEstado=='1' ? 'selected':''}>Habilitado</option>
                                    <option value="2"${proEstado=='2' ? 'selected':''}>Deshabilitado</option>
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
                        <th scope="col">Mail</th>
                        <th scope="col">Nombres</th>
                        <th scope="col">Apellidos</th>
                        <th scope="col">Celular</th>
                        <th scope="col">DNI</th>
                        <th scope="col">Rol</th>
                        <th scope="col">Estado</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody class="text-center">
                    <c:forEach var="empElemento" items="${listaEmpleados}">
                        <tr>
                            <th scope="row">${empElemento.getIdUser()}</th>
                            <td>${empElemento.getMailUser()}</td>
                            <td>${empElemento.getNombreEmpleado()}</td>
                            <td>${empElemento.getApellidoEmpleado()}</td>
                            <td>${empElemento.getCelularEmpleado()}</td>
                            <td>${empElemento.getDniEmpleado()}</td>
                            <td>${empElemento.getIdPerfilString()}</td>
                            <td>${empElemento.getUsuEstadoString()}</td>
                            <td class="d-flex justify-content-center">
                                <a href="#" class="btn btn-danger mr-2" onclick="revisarEliminar(${empElemento.getIdUser()}, event)">Eliminar</a>
                                <a href="#" onclick="revisarEditar(${empElemento.getIdUser()}, event)"  class="btn btn-primary mr-2">Editar</a>
                                <c:choose>
                                    <c:when test="${empElemento.getUsuEstadoString() eq 'Oculto'}">
                                        <a href="#" class="btn btn-success mr-2" onclick="revisarVisible(${empElemento.getIdUser()}, event)">Habilitar</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" class="btn btn-dark mr-2" onclick="revisarOcultar(${empElemento.getIdUser()}, event)" >Deshabilitar</a>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>                 
        </div>
        <script type="text/javascript">
            window.addEventListener('load', function () {
                var cid = <%=request.getAttribute("perfbu")%>;
                $.ajax({
                    url: "ControladorTrabajador?menu=trabajador&&accion=LPerf",
                    method: "POST",
                    success: function (data, textStatus, jqXHR) {
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            const $select = document.querySelector("#listPerfilesid");
                            const option = document.createElement('option');
                            option.value = value.idPerfil;
                            option.text = value.desPerfil;
                            $select.appendChild(option);
                            if (option.value === cid) {
                                option.selected = true;
                            }
                        })
                    }
                });
            });
        </script>                      
        <script type="text/javascript" src="js/jquery/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.all.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.all.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.locales.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.locales.min.js"></script>
        <script type="text/javascript" src="js/bootbox/bootbox.min.js"></script>  
        <script type="text/javascript" src="js/productos.js"></script>                       
    </body>
</html>
