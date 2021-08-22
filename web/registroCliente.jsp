<%-- 
    Document   : registroCliente
    Created on : 22-ago-2021, 16:13:03
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Gusi Chicken | Registro</title>
        <link rel="stylesheet" href="css/stylesOwn.css">
        <link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" type="text/css">
        <link rel="icon" type="image/x-icon" href="img/carioco.png">
    </head>
    <body style="background-color: #23282B">
        <form method="POST" action="controladorValidar">
            <div id="logo-login">
                <img src="img/carioco.png">
            </div>
            <div class="alert alert-danger d-none" id="msg-alert" role="alert">
                <p>${msgerror}</p>
            </div>
            <div id="box-register" class="row justify-content-center">
                <div class="col-lg-6 col-sm-6">
                    <div class="mb-3 d-flex">
                        <div class="col-lg-5">
                            <label for="exampleInputEmail1" class="form-label mr-2">Correo</label>
                            <input type="email" name="emailClienteRegistro" class="form-control" id="email-register" aria-describedby="emailHelp" required="required">
                        </div>

                        <div class="col-lg-6">
                            <label for="exampleInputPassword1" class="form-label mr-2">Nombres</label>
                            <input type="text" name="nombreClienteRegistro" class="form-control" id="nombre-register" required="required">
                        </div>

                        <div class="col-lg-6">
                            <label for="exampleInputPassword1" class="form-label mr-2">Dirección</label>
                            <input type="text" name="direccionClienteRegistro" class="form-control" id="direccion-register" required="required">
                        </div>
                    </div>

                    <div class="mb-3 d-flex">
                        <div class="col-lg-5">
                            <label for="exampleInputEmail1" class="form-label mr-2">Apellidos</label>
                            <input type="text" name="apellidosClienteRegistro" class="form-control" id="apellidos-register" aria-describedby="emailHelp" required="required">
                        </div>

                        <div class="col-lg-6">
                            <label for="exampleInputPassword1" class="form-label mr-2">Celular</label>
                            <input type="text" name="celularClienteRegistro" class="form-control" id="celular-register" onkeypress="if (isNaN(String.fromCharCode(event.keyCode)))
                                        return false;" maxlength="9" required="required">
                        </div>
                    </div>

                    <div class="mb-3 d-flex">
                        <div class="col-lg-5">
                            <label for="exampleInputEmail1" class="form-label mr-2">DNI</label>
                            <input type="text" name="dniClienteRegistro" class="form-control" id="dni-register" aria-describedby="emailHelp" onkeypress="if (isNaN(String.fromCharCode(event.keyCode)))
                                        return false;" maxlength="8" required="required">
                        </div>

                        <div class="col-lg-6">
                            <label for="exampleInputPassword1" class="form-label mr-2">Fecha Nacimiento</label>
                            <input type="date" name="fechaNacimientoClienteRegistro" class="form-control" id="fechanac-register" required="required">
                        </div>

                    </div>

                    <div class="mb-3 d-flex">
                        <div class="col-lg-5">
                            <label for="exampleInputEmail1" class="form-label mr-2">Contraseña</label>
                            <input type="password" name="pass1ClienteRegistro" class="form-control" id="password1-register" aria-describedby="emailHelp" required="required">
                        </div>

                        <div class="col-lg-6">
                            <label for="exampleInputPassword1" class="form-label mr-2">Confirma Contraseña</label>
                            <input type="password" name="pass2ClienteRegistro" class="form-control" id="password2-register" required="required">
                        </div>
                    </div>

                    <input type="submit" id="btn-register" class="btn justify-content-center" name="accion" value="Registrar">
                </div>
            </div>
        </form>
        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>
        <script type="text/javascript" src="js/validandoRegistro/main.js"></script>
        <script type="text/javascript">
                                var openGet =<%=request.getAttribute("openit")%>;
                                var divAlert = document.getElementById("msg-alert");
                                if (openGet === 1) {
                                    divAlert.classList.remove("d-none");
                                }
        </script>
    </body>
</html>
