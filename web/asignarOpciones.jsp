<%-- 
    Document   : asignarOpciones
    Created on : 30-ago-2021, 21:41:07
    Author     : Leonardo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Perfil</title>
        <link rel="stylesheet" href="css/stylesLayout.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 mt-4 ">
                    <h2 class="text-center">Asignar perfiles</h2>
                    <div class="justify-content-center">
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
                                <tbody>
                                    
                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
