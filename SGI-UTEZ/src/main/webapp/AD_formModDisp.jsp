<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<%@ page import="mx.edu.utez.integradora.model.administration.display.beanDisplay" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    beanDisplay dispositivoe =  (beanDisplay) request.getAttribute("dispositivoe");
    String user =(String) (session.getAttribute("user"));
    String pass =(String) (session.getAttribute("pass"));
    String tipo = (String) (session.getAttribute("tipo_usuario"));
    if(user != null && pass !=null && tipo.equals("Administrador")){
        System.out.println("Inicio de sesión exitoso");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />

    <title>Modificar o eliminar usuarios</title>

    <!-- Bootstrap CSS CDN -->
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
            integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
            crossorigin="anonymous"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css" />
    <!-- Font Awesome JS -->
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"
    ></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                <a href="viewDisplay"  style="background-color: #009574;color:#fff;   " class="btn btn-primary btn-lg" role="button" ><i class="fas fa-undo-alt"></i></a>
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
            <div class="card-header" style="background-color: #345177; color: #fff">
                Modificar usuarios
            </div>
            <div class="card-body">
<fieldset>
                                    <div class="form-group ">
                                        <input type="hidden" name="id" id="id"  value="<%= dispositivoe.getId_dispositivo() %>">
                                        <label >*Número de serie:</label>
                                        <input type="text" class="form-control" id="num_serie" name="num_serie" value="<%= dispositivoe.getNum_serie() %>" placeholder="Num serie" >

                                    </div>
                                    <div class="form-group ">
                                        <label >*Número de inventario:</label>
                                        <input type="text" class="form-control" name="num_inv" id="num_inv" value="<%= dispositivoe.getNum_inventario() %>" placeholder="Num inventario" >

                                    </div>
                                    <div class="form-group ">
                                        <label >*Marca:</label>
                                        <input type="text" class="form-control" name="marca" id="marca" value="<%= dispositivoe.getMarca() %>" placeholder="Marca" required>


                                    </div>
                                    <div class="form-group ">
                                        <label >*Modelo:</label>
                                        <input type="text" class="form-control" name="modelo" id="modelo" value="<%= dispositivoe.getModelo() %>" placeholder="Modelo" required>

                                    </div>
                                    <div class="form-group">
                                        <label>*Tipo:</label>
                                        <select  class="custom-select" name="tipo" id="tipo"  >
                                            <option selected value="<%= dispositivoe.getTipo_dpo() %>"><%= dispositivoe.getTipo_dpo() %></option>
                                            <option value="">Elije un tipo dispositivo</option>
                                            <option value="Switch">Switch</option>
                                            <option value="Router">Router</option>
                                            <option value="punto Acceso">Punto de acceso</option>
                                            <option value="Laptop">Laptop</option>
                                            <option value="Pc">PC</option>
                                            <option value="Tablet">Tablet</option>
                                            <option value="Router_Inalambrico">Router inalámbrico</option>
                                            <option value="Tester">Tester</option>
                                            <option value="Multimetro">Multímetro</option>
                                            <option value="Firewall">Firewall</option>
                                        </select>
                                    </div>
                                    <div class="form-group ">
                                        <label>*Estatus:</label>
                                        <select id="estatus" class="custom-select" id="estatus" name="estatus"  >
                                            <option selected value="<%= dispositivoe.getEstatus() %>"><%= dispositivoe.getEstatus() %></option>
                                            <option value="">Elije su Estatus</option>
                                            <option value="Ocupado">Ocupado</option>
                                            <option value="Disponible">Disponible</option>
                                            <option value="Prestado">Prestado</option>
                                        </select>

                                    </div>
                                    <div class="form-group ">
                                        <label>*Categoría:</label>
                                        <select id="categoria" class="custom-select" name="categoria" id="categoria"  >
                                            <option selected value="<%=  dispositivoe.getCta_dpo() %>"><%= dispositivoe.getCta_dpo() %></option>
                                            <option value="">Elije la Categoría</option>
                                            <option value="Dispositivo de Red">Dispositivo de red</option>
                                            <option value="Dispositivo Final">Dispositivo final</option>
                                        </select>
                                    </div>
                                    <div class="form-group ">
                                        <label >Observaciones (opcional):</label>
                                        <input class="form-control" value="<%= dispositivoe.getObservaciones() %>" id="observacion" name="observacion" rows="3">
                                    </div>
                                    <br>
                                    <div class="card-footer text-center">
                <button type="button" class="btn btn-secondary btn-lg" onclick="valModDisp()"
                        style="background-color: #345177;color:#fff " >Modificar</button>
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
                                        <script src="js/functionvalModDisp.js"></script>
</body>
</html>
<%
    }else{
        System.out.println("Error al iniciar sesión");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>