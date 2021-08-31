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
                        <input class="d-none" value="${correoCli}" name="mailhide">
                    </div>
                    <input type="submit" id="btn-activa" class="btn justify-content-center" name="accion" value="Activar">
                </div>
            </div>
        </form>

        <footer>
            <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
        </footer>

        <!--Modal para activar-->

        <div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-md" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Estado de código</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body" id="modalLogin">
                        ...
                    </div> 

                </div>
            </div>
        </div>

        <script type="text/javascript" src="js/validandoActivaCuenta/validaActivaCuenta.js"></script>
        <script type="text/javascript" src="js/jquery/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript">
                            window.addEventListener('load', function () {
                                document.getElementById("modalLogin").innerHTML = "";
                                var rs =<%=request.getAttribute("rs")%>;
                                if (rs === 1) {
                                    $('#myModal').modal({backdrop: 'static', keyboard: false})
                                    document.getElementById("modalLogin").innerHTML = `
                                    <h1 style="text-align: center;">Código correcto</h1>
                                    <br>
                                    <p  style="text-align: center;">Te estamos llevando al login</p>`;
                                    $("#myModal").modal('show');

                                    setTimeout(function () {
                                        window.location.href = 'login.jsp';
                                    }, 3000);

                                }
                                if (rs === 2) {
                                    $('#myModal').modal({backdrop: 'static', keyboard: false})
                                    document.getElementById("modalLogin").innerHTML = `
                                    <h1 style="text-align: center;">Código incorrecto</h1>`;
                                    $("#myModal").modal('show');

                                }
                            });
        </script>
    </body>
</html>
