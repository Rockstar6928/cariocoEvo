<%-- 
    Document   : Carrito
    Created on : 27/08/2021, 03:01:55 PM
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
        <script src="js/popper.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
        <link rel="stylesheet" href="css/bootstrap/css/estilo.css">
        <link rel="stylesheet" href="css/bootstrap/css/sweetalert2.min.css">
        <title>Carrito | Carioco</title>
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>

    <body>
        <header>
            <div class="container">
                <div class="row align-items-stretch justify-content-between">
                    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">

                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse"
                                aria-controls="navbarCollapse" aria-expanded="true" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span></button> 

                        <a title="Logo" href="carrito.jsp"><img src="img/CariocoRectangulo.png" width="300" height="76" alt="LOGO" /></a>

                        <!--el carrito-->
                        <c:set var = "perfil" scope = "session" value = "${username}"/>
                        <c:choose>
                            <c:when test="${perfil!=null}">
                                <div   id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span  id="contadorCarrito" class="p1 fa-stack fa-2x has-badge" data-count="0">
                                        <i  class="p3 fa fa-shopping-cart fa-stack-1x xfa-inverse" data-count="4b"></i>
                                    </span>
                                </div>
                            </c:when>
                        </c:choose>
                        <div class="collapse navbar-collapse" id="navbarCollapse ">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item dropdown">

                                    <div id="carrito" class="dropdown-menu" aria-labelledby="navbarCollapse">
                                        <table id="lista-carrito" class="table">
                                            <thead>
                                                <tr>
                                                    <th>Imagen</th>
                                                    <th>Nombre</th>
                                                    <th>Precio</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                        <a href="#" id="vaciar-carrito" class="btn btn-primary btn-block">Vaciar Carrito</a>
                                        <a href="#" id="procesar-pedido" class="btn btn-danger btn-block">ProcesarCompra</a>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </header>

        <br><br>

        <main>

            <div class="pricing-header px-3 py-3 pt-md-5 pb-md-4 my-4 mx-auto text-center">
                <h1 class="display-4 mt-4">Lista de Productos</h1>
                <p class="lead">Selecciona uno de nuestros productos y accede a un descuento</p>
            </div>

            <div class="row col-lg-12 text-center mb-4">
                <div class="u-container-style u-list-item u-repeater-item col-lg-12">
                    <div class="u-container-layout u-similar-container u-container-layout-1" id="catsList">
                    </div>
                </div>
            </div>

            <div class="container" id="lista-productos">
                <div class="card-deck mb-3 text-center col-lg-12 d-flex">
                    <c:forEach var="proElemento" items="${listaProductos}" varStatus="theCount">
                        <div class="card mb-4 shadow-sm ">

                            <div class="card-header">
                                <h4 class="my-0 font-weight-bold">${proElemento.getNomPro()}</h4>
                                <p>${proElemento.getDesCat()}</p>
                            </div>
                            <div class="card-body">
                                <img src="img/productos/${proElemento.getImgPro()}" class="card-img-top">
                                <h1 class="card-title pricing-card-title precio">S/. <span class="">${proElemento.getPrecioPro()}</span></h1>

                                <ul class="list-unstyled mt-3 mb-4">
                                    <li></li>
                                    <li>${proElemento.getDescPro()}</li>
                                </ul>
                                <!--op comprar-->
                                <c:set var = "perfil" scope = "session" value = "${username}"/>
                                <c:choose>
                                    <c:when test="${perfil!=null}">
                                        <a href="" class="btn btn-block btn-primary agregar-carrito" data-id="${theCount.index}">Comprar</a>
                                    </c:when>
                                </c:choose>
                            </div>

                        </div>
                    </c:forEach>
                </div>


            </div>
        </main>
        <script type="text/javascript">
            window.addEventListener('load', function () {
                $.ajax({
                    url: "ControladorProducto?menu=producto&&accion=LCats",
                    method: "POST",
                    success: function (data, textStatus, jqXHR) {
                        let obj = $.parseJSON(data);
                        $.each(obj, function (key, value) {
                            const $tagdiva = document.querySelector("#catsList");
                            const taga = document.createElement('a');
                            taga.textContent = value.desCat;
                            taga.setAttribute("class", "btn btn-dark mr-2");
                            taga.setAttribute("href", "controladorVistasCliente?menu=vistasCliente&&accion=sProbCat&&id=" + value.idCat + "");
                            $tagdiva.appendChild(taga);

                        })
                    }
                });
            });


        </script>
        <script src="js/jquery-3.4.1.min.js"></script>
        <script src="css/bootstrap/js/bootstrap.min.js"></script>
        <script src="js/sweetalert2.min.js"></script>
        <script src="js/carrito.js"></script>
        <script src="js/pedido.js"></script>

    </body>

</html>
