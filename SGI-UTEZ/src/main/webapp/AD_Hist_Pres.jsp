<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--Sin menu -->
<%@ page import="mx.edu.utez.integradora.model.administration.prestamo.beanPrestamo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
    String user =(String) (session.getAttribute("user"));
    String pass =(String) (session.getAttribute("pass"));
    String tipo = (String) (session.getAttribute("tipo_usuario"));
    if(user != null && pass !=null && tipo.equals("Administrador")){
        System.out.println("sesion exitosa");
%>
<%
    List<beanPrestamo> prestamos = (List<beanPrestamo>) request.getAttribute("prestamos");
    List<beanPrestamo> prestamosMale = (List<beanPrestamo>) request.getAttribute("prestamosMale");
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Historial de préstamos</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
        integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css" />
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                   Historial de Préstamos
                </div>
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="input-group rounded">
                                <input type="search" id="search" class="form-control rounded" placeholder="Buscar Dispositivos" aria-label="Search" aria-describedby="search-addon" />
                                <span class="input-group-text border-0" id="search-addon">
    <i class="fas fa-search"></i>
  </span>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="input-group rounded">
                                <input type="search" id="searchM" class="form-control rounded" placeholder="Buscar de Maletines" aria-label="Search" aria-describedby="search-addon" />
                                <span class="input-group-text border-0" id="search-addon1">
    <i class="fas fa-search"></i>
  </span>
                            </div>
                        </div>
                    <br>
                    <lable>Dispositivos</lable>
                    <table id="mytable" class="table table-responsive table-hover table-sm table-striped table-bordered">
                        <thead  style="background-color:#345177 ; color: #fff;">
                          <tr>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Nombre del prestatario</th>
                            <th scope="col">Matrícula</th>
                            <th scope="col">Correo electrónico</th>
                            <th scope="col">Fecha del préstamo</th>
                            <th scope="col">Fecha de devolución</th>
                            <th scope="col">Estado del préstamo</th>
                            <th scope="col">Id del dispositivo</th>
                          </tr>
                          </tr>
                        </thead>
                        <tbody>
                        <%


                            for (beanPrestamo e : prestamos) {
                                if (e.getEstatus().equals("Entregado")) {
                                    out.print("<tr><td>" + e.getId_prestamo() + "</td><td>" + e.getNombre() + "</td><td>" + e.getMatricula() + "</td><td>"
                                            + e.getCorreo() + "</td><td>" + e.getFecha_inicio() + "</td><td>" + e.getFecha_final() + "</td><td>" + e.getEstatus() + "</td><td> " + e.getId_dispositivo() + "</td></tr>");
                                }
                            }
                        %>
                        </tbody>
                      </table>
                    <lable>Maletines</lable>
                    <table id="mytable1" class="table table-hover table-sm table-striped table-responsive-sm table-bordered">
                        <thead  style="background-color:#345177 ; color: #fff;">
                        <tr>
                        <tr>
                           <th scope="col">#</th>
                            <th scope="col">Nombre del prestatario</th>
                            <th scope="col">Matrícula</th>
                            <th scope="col">Correo electrónico</th>
                            <th scope="col">Fecha del préstamo</th>
                            <th scope="col">Fecha de devolución</th>
                            <th scope="col">Estado del préstamo</th>
                            <th scope="col">Id del maletín</th>

                        </tr>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            int contador=1;
                            for (beanPrestamo e : prestamosMale) {
                                if (e.getEstatus().equals("Entregado")) {
                                    out.print("<tr><td>" + contador+ "</td><td>" + e.getNombre() + "</td><td>" + e.getMatricula() + "</td><td>"
                                            + e.getCorreo() + "</td><td>" + e.getFecha_inicio() + "</td><td>" + e.getFecha_final() + "</td><td>" + e.getEstatus() + "</td><td> " + e.getId_maletin() + "</td></tr>");
                                            contador++;
                                }
                            }
                        %>
                        </tbody>
                    </table>

                  </div>
                <div class="card-footer text-center">
                  

                </div>
            </div>

        </div>
    </div>
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
        <script>
            $(function(){
                $('#mytable').tablesorter();
            });
            // Write on keyup event of keyword input element
            $(document).ready(function(){
                $("#search").keyup(function(){
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#mytable tbody tr"), function() {
                        if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });
        </script>
            <script>
                $(function(){
                    $('#mytable1').tablesorter();
                });
                // Write on keyup event of keyword input element
                $(document).ready(function(){
                    $("#searchM").keyup(function(){
                        _this = this;
                        // Show only matching TR, hide rest of them
                        $.each($("#mytable1 tbody tr"), function() {
                            if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                                $(this).hide();
                            else
                                $(this).show();
                        });
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