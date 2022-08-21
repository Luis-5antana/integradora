<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
    String user =(String) (session.getAttribute("user"));
    String pass =(String) (session.getAttribute("pass"));
    String tipo = (String) (session.getAttribute("tipo_usuario"));
    String nombre =(String) (session.getAttribute("nombre"));
    String apo_pto =(String) (session.getAttribute("apo_pto"));
    String apo_mto = (String) (session.getAttribute("apo_mto"));
    String matricula =(String) (session.getAttribute("matricula"));
    String telefono= (String) (session.getAttribute("telefono"));

    if(user != null && pass !=null && tipo.equals("Administrador")){
        System.out.println("sesion exitosa");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>MI PERFIL ADMINISTRADOR</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
        integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
        integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
        crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
        integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
        crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

</head>
<body>
    <div class="wrapper">
        <div class="wrapper">
            <!-- Sidebar  -->
            <nav id="sidebar">
                <div id="headerperfil">
                    <img id="headerperfil" src="img/utez.png" alt="">
                </div>
                <ul class="list-unstyled components">
                    <p>${user}</p>
                    <p>Administrador</p>
                    <li>
                        <a href="AD_Perfil.jsp"><i class="fas fa-user-alt"></i> Mi perfil</a>

                    </li>
                    <li>
                        <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                                class="fas fa-file"></i> Préstamos</a>
                        <ul class="collapse list-unstyled" id="homeSubmenu">
                            <li>
                                <a href="AD_regPres.jsp"><i class="fas fa-plus"></i> Prestar dispositivo</a>
                            </li>
                            <li>
                                <a href="AD_regPresMale.jsp"><i class="fas fa-plus"></i> Prestar maletín</a>
                            </li>
                            <li>
                                <a href="viewPrestamo"><i class="fa fa-table"></i><i class="fa-solid fa-check"></i> Historial de préstamos</a>
                            </li>
                            <li>
                                <a href="viewPrestamo1"><i class="fa fa-table"></i> Préstamos activos</a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                                class="fas fa-users"></i> Usuarios</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a href="AD_regUsu.jsp"><i class="fas fa-user-plus"></i></i> Agregar</a>
                            </li>
                            <li>
                                <a href="ViewPerson"><i class="fas fa-user-edit"></i> Modificar</a>
                            </li>
                            <li>
                                <a href="ViewPerson"><i class="fas fa-user-times"></i> Eliminar</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pageSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                                class="fas fa-desktop"></i></i> Dispositivos</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu1">
                            <li>
                                <a href="AD_regDisp.jsp"><i class="fas fa-plus"></i> Agregar</a>
                            </li>
                            <li>
                                <a href="viewDisplay"><i class="fas fa-edit"></i> Modificar</a>
                            </li>
                            <li>
                                <a href="viewDisplay"><i class="fas fa-trash-alt"></i> Eliminar</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pageSubmenu4" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                                class="fas fa-briefcase"></i></i> Maletines</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu4">
                            <li>
                                <a href="AD_regMale.jsp"><i class="fas fa-plus"></i> Agregar</a>
                            </li>
                            <li>
                                <a href="viewMaletin"><i class="fas fa-edit"></i> Modificar</a>
                            </li>
                            <li>
                                <a href="viewMaletin"><i class="fas fa-trash-alt"></i> Eliminar</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle"><i
                                class="fas fa-eye"></i> Consultar</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu2">
                            <li>
                                <a href="ViewPerson1"><i class="fas fa-user-alt"></i> Usuarios</a>
                            </li>
                            <li>
                                <a href="viewConsultarDispo"><i class="fas fa-desktop"></i> Dispositivos</a>
                            </li>
                            <li>
                                <a href="viewMaletin1"><i class="fas fa-briefcase"></i> Maletines</a>
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
                   Mi Perfil
                </div>
                <div class="card-body">

                    <div class="form-row">
                        <div class="form-group col-md-4">
                            <label >Nombre:</label>
                            <input type="text" class="form-control"  placeholder="${nombre}" disabled readonly>
                        </div>
                        <div class="form-group col-md-4">
                            <label >Apellido Paterno:</label>
                            <input type="text" class="form-control"  placeholder="${apo_pto}" disabled readonly>
                        </div>
                        <div class="form-group col-md-4">
                            <label >Apellido Materno:</label>
                            <input type="text" class="form-control" placeholder="${apo_mto}" disabled readonly>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label >Número Teléfono:</label>
                            <input type="number" class="form-control"  placeholder="${telefono}" disabled readonly>
                        </div>
                        <div class="form-group col-md-6">
                            <label >Matrícula</label>
                            <input type="text" class="form-control"  placeholder="${matricula}" disabled readonly>
                        </div>
                    </div>

                    <div class="form-group">

                        <label >Correo Electrónico</label>
                        <input type="email" class="form-control"  placeholder="${user}" disabled readonly>
                    </div>

                        <div class="form-row">
                       
                        <div class="form-group col-md-6">
                          <label >Usuario</label>
                          <input disabled class="form-control" placeholder="Administrador" readonly>
                        </div> 

</div>
 </div>
        </div>
    </div>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
        integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
        crossorigin="anonymous"></script>
        <script src="js/alertaRegMod.js"></script>
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
        System.out.println("no hay sesion iniciada o tipo usuario incorrecto");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>