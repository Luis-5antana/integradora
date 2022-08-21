<!--Sin menu -->
<%@ page import="mx.edu.utez.integradora.model.administration.maletin.beanMaletin" %>
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    beanMaletin maletine =  (beanMaletin) request.getAttribute("maletine");

    String user =(String) (session.getAttribute("user"));
    String pass =(String) (session.getAttribute("pass"));
    String tipo = (String) (session.getAttribute("tipo_usuario"));
    if(user != null && pass !=null && tipo.equals("Administrador")){
        System.out.println("sesion exitosa");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <title>Modificar y Eliminar usuario</title>

    <!-- Bootstrap CSS CDN -->
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
            integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
            crossorigin="anonymous"
    />
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Font Awesome JS -->
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
            integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
            crossorigin="anonymous"
    ></script>
</head>
<body>
<div class="wrapper">
    <!-- Page Content  -->
    <div id="content">
        <!-- HEADER DE LA PAGINA -->
        <nav class="navbar navbar-light" style="background-color: #345177">
            <div class="container-fluid">
                <a href="viewMaletin"  style="background-color: #009574;color:#fff;   " class="btn btn-primary btn-lg" role="button" ><i class="fas fa-undo-alt"></i></a>
                <span>Sistema de Gestión De Inventarios | UTEZ</span>
                <form action="ServletPerson" method="post">
                    <input type="hidden" value="cerrarSesion" name="accion">
                    <button class="btn btn-danger " type="submit" >
                        <i class="fas fa-sign-out-alt"></i>
                    </button>
                </form>
            </div>
        </nav>
        <div class="card border-dark mb-3">
            <div class="card-header" style="background-color: #345177; color: #fff">
                Modificar Usuario
            </div>
            <div class="card-body">
<fieldset>

                                    <div class="form-group ">
                                        <input type="hidden" name="id" id="id" value="<%= maletine.getId_male() %>">
                                        <div class="form-row">
                                            <div class="form-group col-md-6">
                                                <label>*Numero de Inventario:</label>
                                                <input type="text" class="form-control" id="num_inventario" name="num_inventario" placeholder="Num serie" value="<%= maletine.getNum_inventario()%>" required>
                                                <div class="invalid-feedback">
                                                    Por favor escriba el numero de inventario.
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label >*Estatus del maletin:</label>
                                                <select class="custom-select" name="estatus"  id="estatus" >
                                                    out.print("<option selected value="<%= maletine.getEstatus() %>"><%= maletine.getEstatus() %></option>");
                                                    <option value="">Cambia el estatus</option>
                                                    <option value="Ocupado">Ocupado</option>
                                                    <option value="Disponible">Disponible</option>
                                                    <option value="Prestado">Prestado</option>
                                                </select>
                                                <div class="invalid-feedback">
                                                    Por favor seleccione el estatus del maletin.
                                                </div>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label>*Categoria del maletin:</label>
                                                <select  class="custom-select" name="categoria" id="categoria" >
                                                    <option selected value="<%= maletine.getCta_male() %>"><%= maletine.getCta_male() %></option>
                                                    <option value="">Elije otra categoria</option>
                                                    <option value="Red">Red</option>
                                                    <option value="otro">Otro</option>

                                                </select>
                                                <div class="invalid-feedback">
                                                    Por favor seleccione la categoria del dispositivo.
                                                </div>
                                            </div>

                                            <div class="form-group col-md-12">
                                                <label>*Descripcion:</label>
                                                <input type="text" class="form-control" id="descripcion" name="descripcion" value="<%= maletine.getDescripcion() %>" placeholder="Descripcion del maletin">
                                                <div class="invalid-feedback">
                                                    Por favor escribir una descripcion precisa del contenido.
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label >Observaciones (opcional):</label>
                                            <input   class="form-control" name="observacion" id="observacion" value="<%= maletine.getObservacion() %>" rows="3">
                                        </div>
                                    <div class="card-footer text-center">
                <button type="button" class="btn btn-secondary btn-lg" onclick="valModMale()" style="background-color: #345177;color:#fff " >Modificar</button>

                                        </fieldset>

    <!-- Popper.JS -->
    <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
            integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
            crossorigin="anonymous"
    ></script>
    <!-- Bootstrap JS -->
    <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
            integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
            crossorigin="anonymous"
    ></script>
                <script src="js/functionModMale.js"></script>
</body>
</html>
<%
    }else{
        System.out.println("no hay sesion iniciada");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>