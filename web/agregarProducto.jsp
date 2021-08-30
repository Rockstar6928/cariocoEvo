<%-- 
    Document   : agregarProducto
    Created on : 29-ago-2021, 18:06:24
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Agregar Pro.</title>
        <link rel="stylesheet" href="css/stylesLayout.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 mt-4 ">
                    <h2 class="text-center">Nuevo Producto</h2>
                    <div class="justify-content-center">
                        <form class="col-lg-6 form-horizontal" style="margin: 0 auto;" action="ControladorProducto?menu=producto" method="POST">
                            <div class="mb-3">
                                <div class="form-floating">
                                    <label for="floatingSelectGrid">Categoria</label>
                                    <select class="form-select" name="listCats2" id="listCatsid2" aria-label="Floating label select example">
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
                                <input type="file"  name="imgpro" class="form-control" id="img-pro" aria-describedby="emailHelp" required="required" placeholder="Img">
                            </div>

                            <div class="text-center">
                                <input type="submit" id="btn-addpro" class="btn btn-success" name="accion" value="Agregar">    
                            </div>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
        <!--<script type="text/javascript" src="js/validandoAgregarPro/validandoPro.js"></script>-->
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
