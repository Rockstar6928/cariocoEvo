const compra = new Carrito();
const listaCompra = document.querySelector("#lista-compra tbody");
const carrito = document.getElementById('carrito');
const procesarCompraBtn = document.getElementById('procesar-compra');
const cliente = document.getElementById('cliente');
const correo = document.getElementById('correo');



cargarEventos();


function cargarEventos() {
    document.addEventListener('DOMContentLoaded', compra.leerLocalStorageCompra());

    //Eliminar productos del carrito
    carrito.addEventListener('click', (e) => { compra.eliminarProducto(e) } );

    compra.calcularTotal();
    

    //cuando se selecciona procesar Compra
    procesarCompraBtn.addEventListener('click', procesarCompra);

    carrito.addEventListener('change', (e) => { compra.obtenerEvento(e) });
    carrito.addEventListener('keyup', (e) => { compra.obtenerEvento(e) });

    
}
if (compra.obtenerProductosLocalStorage().length === 0) {
        Swal.fire({
            type: 'error',
            title: 'Oops...',
            text: 'No hay productos, selecciona alguno',
            showConfirmButton: false,
            timer: 1000
            
        }).then(function () {
            window.location = "carrito.jsp";
            
        })   
    }


function procesarCompra() {
   
    if (compra.obtenerProductosLocalStorage().length ++)  {
        //aqui se coloca el user id generado en el emailJS
        (function () {
            emailjs.init("user_ILxRAsklVz76U3doJYe37");
        })();
        

        var myform = $("form#procesar-pago");

        myform.submit( (event) => {
            event.preventDefault();

            // Change to your service ID, or keep using the default service
            document.getElementById("procesar-compra").disabled = true;
            var service_id = "default_service";
            var template_id = "template_r1qrvnr";
            
            

            const cargandoGif = document.querySelector('#cargando');
            const enviado = document.createElement('img');
          
            emailjs.sendForm(service_id, template_id, myform[0])
                .then(() => {
                    cargandoGif.style.display = 'none';
                    document.querySelector('#loaders').appendChild(enviado);
                    
                    Swal.fire({
                            title: 'Muchas gracias por su compra!',
                            text: 'En breves momentos recibiras el comprobante a su correo.',
                            imageUrl: 'img/mail.gif',
                            imageWidth: 150,
                            imageAlt: 'Custom image',
                          }).then(function () {
                         compra.vaciarLocalStorage();
                        enviado.remove();
                        window.location = "carrito.jsp";
        })

                        
                  
                }, (err) => {
                    alert("Error al enviar el email\r\n Response:\n " + JSON.stringify(err));
                   
                });

            return false;

        });

    }
}

