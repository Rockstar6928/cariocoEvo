<%-- 
    Document   : activaCuentaCliente
    Created on : 22-ago-2021, 23:32:34
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Activa tu cuenta</title>
        <link rel="stylesheet" href="css/stylesOwn.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.jpeg">
    </head>
    <body style="background-color: #23282B">
        <form method="POST" action="controladorValidar">
            <div id="logo-login">
                <img src="img/carioco.jpeg">
            </div>
            <h1 id="msg-welcome-activa" class="text-center"> Bievenido/a ${nombreCliente}  </h1>
            <br>
            <h4 id="msg-welcome-activa" class="text-center"> Ingresa el código de confirmación </h4>
            <br>
            <div class="alert alert-danger d-none" id="msg-alert" role="alert">
                <p>${msgerror}</p>
            </div>
            <div id="box-login" class="row justify-content-center">
                <div class="col-lg-3 col-sm-6 col-xs-6">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Código</label>
                        <input type="text" name="codigoActiva" class="form-control mb-3" id="codigo-activa" aria-describedby="emailHelp" required="required" onkeypress="if (isNaN(String.fromCharCode(event.keyCode)))
                                    return false;" maxlength="5" >
                        <div id="emailHelp" class="form-text text-center">El código esta en tu bandeja de entrada, ve a por el!</div>
                    </div>
                    <input type="submit" id="btn-activa" class="btn justify-content-center" name="accion" value="Activar">
                </div>
            </div>
        </form>

        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>
        <script type="text/javascript" src="js/validandoActivaCuenta/validaActivaCuenta.js"></script>
    </body>
</html>
