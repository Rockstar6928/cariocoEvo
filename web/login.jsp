<%-- 
    Document   : login
    Created on : 22-ago-2021, 1:42:26
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Carioco Chicken | Login</title>
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
            <div id="box-login" class="row justify-content-center">
                <div class="col-lg-3 col-sm-6 col-xs-6">
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Correo</label>
                        <input type="email" name="email" class="form-control" id="email-login" aria-describedby="emailHelp" required="required">
                        <div id="emailHelp" class="form-text">Nosotros nunca compartiremos tú email con alguien mas...</div>
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputPassword1" class="form-label">Contraseña</label>
                        <input type="password" name="password" class="form-control" id="pass-login" required="required">
                    </div>
                    <div id="links-extra">
                        <a href="registroCliente.jsp" id="link-register" >¿No tienes cuenta? Registrate</a>
                        <br>
                        <a href="#" id="link-register" >¿Olvidaste tu contraseña?</a>
                    </div>

                    <input type="submit" id="btn-login" class="btn justify-content-center" name="accion" value="Ingresar">
                </div>
            </div>
        </form>

        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>

        <script type="text/javascript">
            var openGet =<%=request.getAttribute("openit")%>;
            var divAlert = document.getElementById("msg-alert");
            if (openGet === 1) {
                divAlert.classList.remove("d-none");
            }
        </script>
    </body>
</html>
