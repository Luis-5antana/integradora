<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
    String user =(String) (session.getAttribute("user"));
    String pass =(String) (session.getAttribute("pass"));
    String tipo = (String) (session.getAttribute("tipo_usuario"));
    if(user != null && pass !=null && tipo.equals("Usuario")){
        System.out.println("sesion exitosa");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Usuario-Realizar Prestamo</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
        integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
        integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
        integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
        crossorigin="anonymous"></script>
</head>

<body>
    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div id="headerperfil">
                <img id="headerperfil" src="img/utez.png" alt="" />
            </div>
            <ul class="list-unstyled components">
                <p>${user}</p>
                <p>Usuario</p>
                <li>
                    <a href="UE_perfil.jsp"><i class="fas fa-user-alt"></i> Mi perfil </a>
                </li>
                <li>
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                            class="fas fa-file"></i> Préstamos </a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li>
                            <a href="UE_regPres.jsp"><i class="fas fa-plus"></i> Prestar dispositivo </a>
                        </li>
                        <li>
                            <a href="UE_regPresMale.jsp"><i class="fas fa-plus"></i> Prestar maletín </a>
                        </li>
                        <li>
                            <a href="viewPrestamoUsu"><i class="fa fa-table"></i><i class="fa-solid fa-check"></i> Historial de
                                préstamos </a>
                        </li>
                        <li>
                            <a href="viewPrestamoUsu1"><i class="fa fa-table"></i> Préstamos activos </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                            class="fas fa-eye"></i> Consultar </a>
                    <ul class="collapse list-unstyled" id="pageSubmenu2">
                        <li>
                            <a href="ViewPerson2"><i class="fas fa-user-alt"></i> Usuarios </a>
                        </li>
                        <li>
                            <a href="viewConsultarDispo2"><i class="fas fa-desktop"></i> Dispositivos </a>
                        </li>
                        <li>
                            <a href="viewMaletin2"><i class="fas fa-briefcase"></i> Maletines</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- Page Content  -->
        <div id="content">
            <!-- HEADER DE LA PAGINA -->
            <nav class="navbar navbar-light" style="background-color: #345177">
                <div class="container-fluid">
                    <button type="button" id="sidebarCollapse" class="btn btn-info" style="background-color: #009574">
                        <i class="fas fa-bars"></i>
                        <span>Opciones</span>
                    </button>
                    <span>Sistema Gestor de Inventarios | UTEZ</span>
                    <form action="ServletPerson" method="post">
                        <input type="hidden" value="cerrarSesion" name="accion">
                        <button class="btn btn-danger " type="submit" >
                            <i class="fas fa-sign-out-alt"></i>
                        </button>
                    </form>
                </div>
            </nav>

            <div class="card border-dark mb-3">
                <div class="card-header" style="background-color: #345177;color:#fff ">
                   Realizar Prestamo
                </div>
                <div class="card-body">
                   <form  class="needs-validation" action="viewDisplay1Usu" method="post" novalidate>
                        <div class="form-group" >
                            <label>*Nombre:</label>
                            <input type="text" class="form-control" name="name" placeholder="Nombre" required>
                            <div class="invalid-feedback">
                                Por favor ingrese el nombre del usuario.
                            </div>
                        </div>
                        <div class="form-group">
                            <label >*Apellido Paterno:</label>
                            <input type="text" class="form-control" name="apo_pto" placeholder="Apellido"  required>
                            <div class="invalid-feedback">
                                Por favor ingrese el apellido paterno del usuario.
                            </div>
                        </div>
                        <div class="form-group">
                            <label >*Apellido Materno:</label>
                            <input type="text" class="form-control" name="apo_mto" placeholder="Apellido"  required>
                            <div class="invalid-feedback">
                                Por favor ingrese el apellido materno del usuario.
                            </div>
                        </div>
                        <div class="form-row">

                            <div class="form-group col-md-4">
                                <label>*Seleccionar el tipo dispositivo:</label>

                                <select  class="custom-select" name="tipo" required>
                                    <option value="">Elije un tipo dispositivo</option>
                                    <option value="Switch">Switch</option>
                                    <option value="Router">Router</option>
                                    <option value="punto Acceso">Punto Acceso</option>
                                    <option value="Laptop">Laptop</option>
                                    <option value="Pc">PC</option>
                                    <option value="Tablet">Tablet</option>
                                    <option value="Router_Inalambrico">Router Inalámbrico</option>
                                    <option value="Tester">Tester</option>
                                    <option value="Multimetro">Multímetro</option>
                                    <option value="Firewall">Firewall</option>
                                </select>

                                <div class="invalid-feedback">
                                    Por favor seleccionar la categoria.
                                </div>
                            </div>


                        </div>
                </div>
                <div class="card-footer text-center">
                    <button type="submit" class="btn btn-secondary btn-lg"
                            style="background-color: #345177;color:#fff " >Disponibilidad</button>
                    </form>
                </div>
            </div>
    </div>
                <script>
                    // Example starter JavaScript for disabling form submissions if there are invalid fields
                    (function() {
                        'use strict';
                        window.addEventListener('load', function() {
                            // Fetch all the forms we want to apply custom Bootstrap validation styles to
                            var forms = document.getElementsByClassName('needs-validation');
                            // Loop over them and prevent submission
                            var validation = Array.prototype.filter.call(forms, function(form) {
                                form.addEventListener('submit', function(event) {
                                    if (form.checkValidity() === false) {
                                        event.preventDefault();
                                        event.stopPropagation();
                                    }
                                    form.classList.add('was-validated');
                                }, false);
                            });
                        }, false);
                    })();
                </script>
  
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>

</html>
<%
    }else{
    System.out.println("no hay sesion iniciada");
    request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>