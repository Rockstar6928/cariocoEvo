<%-- 
    Document   : indexGusi
    Created on : 22-ago-2021, 1:02:10
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Carioco Chicken | Home</title>

        <!--OB-->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <!---->

        <link rel="stylesheet" type="text/css" href="fonts/font-awesome/css/font-awesome.css">


        <script type="text/javascript" src="js/jquery/jquery-3.5.1.min.js"></script>
        <script type="text/javascript" src="css/bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link rel="stylesheet" type="text/css" href="css/nivo-lightbox/nivo-lightbox.css">
        <link rel="stylesheet" type="text/css" href="css/nivo-lightbox/default.css">
        <link href="https://fonts.googleapis.com/css?family=Raleway:300,400,500,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script:400,700" rel="stylesheet">
        <link rel="icon" type="image/x-icon" href="img/carioco.png">

    </head>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!--Inicio Barra de navegación-->
    <nav id="menu" class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                <a class="navbar-brand page-scroll" href="#page-top">Carioco Chicken</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">

                    <!--<li><a href="#about" onclick="Abrirabout()" data-name="about" class="page-scroll about-text menulink">Nosotros</a></li>-->
                    <li><a href="#about" class="page-scroll">Nosotros</a></li>
                    <li><a href="#team" class="page-scroll">Protocolo</a></li>
                    <!--<li><a href="ControladorVistas?menu=vistas&&accion=listarproducto" onclick="Buscar()" target="myFrame" class="page-scroll">Menu</a></li>-->
                    <li><a href="#call-reservation" class="page-scroll">Ordena</a></li>
                    <li><a href="login.jsp" >Login</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!--Fin Barra de navegación-->

    <!--Inicio Cabecera-->
    <header id="header">
        <div class="intro">
            <div class="overlay">
                <div class="container">
                    <div class="row">
                        <div class="intro-text">
                            <h1>Carioco</h1>
                            <p>Disfrutarás como no te imaginas</p>
                            <a href="#about" class="btn btn-custom btn-lg page-scroll">Nuestra historia</a> </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!--Fin Cabecera-->


    <!--Acerca de-->
    <div id="about">
        <div class="container">
            <div class="row">
                <div class="col-xs-12 col-md-6">
                    <div class="about-img" id="about-carioco"><img src="img/carioco.png" class="img-responsive" alt=""></div>
                </div>
                <div class="col-xs-12 col-md-6">
                    <div class="about-text">
                        <h2>Nuestra pollería</h2>
                        <hr>
                        <p>Polleria El Carioco se preocupa por su satisfacción brindándoles el mejor producto: Un jugoso pollo y doradito.</p>
                        <h3>¿Por qué elegirnos?</h3>
                        <p>Porque aseguramos el cumplimiento de los protocolos de seguridad.</p>
                        <p>Porque tratamos a cada cliente como si fuera el único.</p>
                        <p>Porque nuestros clientes son importantes para nosotros.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <!-- Call Reservation Section -->
    <div id="call-reservation" class="text-center">
        <div class="container">
            <h2>¿Quieres hacer tu pedido? <strong>Logueate y ordena</strong></h2>
        </div>
    </div>

    <!-- Team Section -->
    <div id="team" class="text-center">
        <div class="overlay">
            <div class="container">
                <div class="col-md-10 col-md-offset-1 section-title">
                    <h2>Protocolos de seguridad</h2>
                    <hr>
                    <p>Nos aseguramos de cumplir con todos los protocolos de seguridad para brindarles un producto de calidad.</p>
                </div>
                <div id="row">
                    <div class="col-md-4 team">
                        <div class="thumbnail">
                            <div class="team-img"><img src="img/team/01.jpg" alt="..."></div>
                            <div class="caption">
                                <h3>Mike Doe</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 team">
                        <div class="thumbnail">
                            <div class="team-img"><img src="img/team/02.jpg" alt="..."></div>
                            <div class="caption">
                                <h3>Chris Doe</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 team">
                        <div class="thumbnail">
                            <div class="team-img"><img src="img/team/03.jpg" alt="..."></div>
                            <div class="caption">
                                <h3>Ethan Doe</h3>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!--Footer-->
    <div id="footer">
        <div class="container text-center">
            <div class="col-md-4">
                <h3>Dirección</h3>
                <div class="contact-item">
                    <p>556 Cercado de Lima,</p>
                    <p>Zarumulla, Lima</p>
                </div>
            </div>
            <div class="col-md-4">
                <h3>Horario de atención</h3>
                <div class="contact-item">
                    <p>Lun-Mier: 10:00 AM - 11:00 PM</p>
                    <p>Vier-Dom: 11:00 AM - 02:00 AM</p>
                </div>
            </div>
            <div class="col-md-4">
                <h3>Información de contacto</h3>
                <div class="contact-item">
                    <p>Celular: +51 123 456 1234</p>
                    <p>Correo: infopolleriacarioco@gmail.com</p>
                </div>
            </div>
        </div>
        <div class="container-fluid text-center copyrights">
            <div class="col-md-8 col-md-offset-2">
                <div class="social">
                    <ul>
                        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                    </ul>
                </div>
                <p class="text-center mt-5">&COPY; Carioco Chicken Todos los derechos reservados - 2021</p>
            </div>
        </div>
    </div>

    <!--Modal para el login-->
    <div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Logueate</h5>
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

    <script type="text/javascript" src="js/jquery.1.11.1.js"></script> 
    <script type="text/javascript" src="js/bootstrap.js"></script> 
    <script type="text/javascript" src="js/SmoothScroll.js"></script> 
    <script type="text/javascript" src="js/nivo-lightbox.js"></script> 
    <script type="text/javascript" src="js/jqBootstrapValidation.js"></script> 
    <script type="text/javascript" src="js/main.js"></script>

</body>
</html>
