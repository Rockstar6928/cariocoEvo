<%-- 
    Document   : agregarCategoria
    Created on : 29-ago-2021, 0:07:06
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Agregar Cat.</title>
        <link rel="stylesheet" href="css/stylesLayout.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body>


        <div class="container">
            <div class="row">
                <div class="col-lg-12 mt-4 text-center">
                    <h2>Nueva Categoría</h2>
                   
                    <div class="justify-content-center">
                        <form class="col-lg-6 form-horizontal" style="margin: 0 auto;" action="ControladorCategoria?menu=categoria" method="POST">
                            <div class="mb-3">
                                <input type="text" name="categoriaagregar" class="form-control" id="nombre-categoria" aria-describedby="emailHelp" required="required">
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
