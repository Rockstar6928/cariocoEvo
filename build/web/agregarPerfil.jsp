<%-- 
    Document   : agregarPerfil
    Created on : 30-ago-2021, 17:59:43
    Author     : Leonardo
--%>

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
                <div class="col-lg-12 mt-4 text-center">
                    <h2>Nuevo Perfil</h2>

                    <div class="justify-content-center">
                        <form class="col-lg-6 form-horizontal" style="margin: 0 auto;" action="ControladorPerfil?menu=perfil" method="POST">
                            <div class="mb-3">
                                <input type="text" name="perfilagregar" class="form-control" id="nombre-perfil" aria-describedby="emailHelp" required="required">
                            </div>
                            <div class="text-center">
                                <input type="submit" id="btn-addcat" class="btn btn-success" name="accion" value="Agregar">    
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
