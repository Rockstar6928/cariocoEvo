<%-- 
    Document   : vistaPrincipalAdministrativa
    Created on : 22-ago-2021, 16:42:43
    Author     : Leonardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Admin.</title>
        <link rel="stylesheet" href="css/stylesLayout.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body>
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");

            if (session.getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            }
        %>
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
        <div class="m-4">
            <h1 style="text-align: center;">RHCP</h1>
            <iframe id="iframe-musi" width="560" height="315" src="https://www.youtube.com/embed/8DyziWtkfBw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>
    </body>

</html>
