<!--Sin menu -->
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="mx.edu.utez.integradora.model.administration.person.beanPerson" %>
<%@ page import="mx.edu.utez.integradora.model.administration.maletin.beanMaletin" %>
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
<!DOCTYPE html>
<html>
<%
    List<beanMaletin> maletines = (List<beanMaletin>) request.getAttribute("maletine");
    beanPerson prestatario= (beanPerson) request.getAttribute("Prestatario");
%>
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Realizar Prestamo</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
</head>

<body>
    <div class="wrapper">
        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-light" style="background-color: #345177; ">
                <div class="container-fluid">
                    <a href="AD_regPresMale.jsp"  style="background-color: #009574;color:#fff;   " class="btn btn-primary btn-lg" role="button" ><i class="fas fa-undo-alt"></i></a>

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
                    <fieldset>
                        <input type="hidden"  id="nom"  name="nom" value="<%= prestatario.getNombre() %>">
                        <input type="hidden"  id="apo_pto"  name="apo_pto" value="<%= prestatario.getApo_pto() %>">
                        <input type="hidden" id="apo_mto" name="apo_mto" value="<%= prestatario.getApo_mto() %>">
                        <input type="hidden" id="tipo" name="tipo" value="<%= prestatario.getTipo_usuario()%>">
                        <input type="hidden" id="disp_estatus" name="disp_estatus" value="Prestado">
                        <input type="hidden" id="estatus" name="estatus" value="Activo">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label >*Número Teléfono:</label>
                                <input type="number" class="form-control" id="tel" name="tel" placeholder="7771345606" >
                               
                            </div>
                            <div class="form-group col-md-6">
                                <label >*Matrícula:</label>
                                <input type="text" class="form-control" id="matri" name="matri" placeholder="Matrícula" >
                             
                            </div>
                        </div>

                        <div class="form-group">

                            <label >*Correo Electrónico:</label>
                            <input type="email" class="form-control" name="email" id="email" placeholder="Correo" >

                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label>*Maletines disponibles de la categoría <%= prestatario.getTipo_usuario()%>:</label>
                                <select  class="custom-select" name="disp" id="disp" >
                                    <% int contador=0;
                                        for(beanMaletin e: maletines){
                                        if(e.getEstatus().equals("Disponible") && prestatario.getTipo_usuario().equals(e.getCta_male())){
                                            out.print("<option value="+e.getId_male()+">"+e.getCta_male()+" "+e.getDescripcion()+"</option>");
                                            contador++;
                                        }
                                        }
                                        if(contador==0){
                                    %>
                                    <option  disabled value="" selected >No hay maletines disponibles, elija otra categoria</option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label>*Fecha y hora préstamo:</label>
                                <input type="datetime-local" class="form-control" name="fecha" id="fecha" >
                            </div>
                        </div>
                </div>
                <div class="card-footer text-center">
                    <button type="button" class="btn btn-secondary btn-lg" onclick="valPresMale()"
                            style="background-color: #345177;color:#fff " >Prestar</button>
                    </fieldset>
                </div>
            </div>
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

    <script src="js/functionvalRegPresMale.js"></script>
    </script>
</body>

</html>
<%
    }else{
        System.out.println("no hay sesion iniciada");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>