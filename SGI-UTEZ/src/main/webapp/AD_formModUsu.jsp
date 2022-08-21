<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--          ORTOGRAFÍA  REVISADA          -->
<!--Sin menu -->
<%@ page import="mx.edu.utez.integradora.model.administration.person.beanPerson" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=iso-8859-1" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
    beanPerson usuarioe = (beanPerson) request.getAttribute("usuarioe");
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
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="css/style.css" />
    <!-- Font Awesome JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
                <a href="ViewPerson"  style="background-color: #009574;color:#fff;   " class="btn btn-primary btn-lg" role="button" ><i class="fas fa-undo-alt"></i></a>
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
                    <div class="${clase}" role="alert">
                        <h4>${mensaje}</h4>
                    </div>
                    <div class="form-group" >
                        <input type="hidden" name="id" id="id" value="<%=usuarioe.getId()%>">
                        <label>*Nombre:</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Nombre" value="<%= usuarioe.getNombre() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese el nombre del usuario.
                        </div>
                    </div>
                    <div class="form-group">
                        <label >*Apellido paterno:</label>
                        <input type="text" class="form-control" name="apo_pto" id="apo_pto" placeholder="Apellido" value="<%= usuarioe.getApo_pto() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese el apellido paterno del usuario.
                        </div>
                    </div>
                    <div class="form-group">
                        <label >*Apellido materno:</label>
                        <input type="text" class="form-control" name="apo_mto" id="apo_mto" placeholder="Apellido" value="<%= usuarioe.getApo_mto() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese el apellido materno del usuario.
                        </div>
                    </div>
                    <div class="form-group ">
                        <label >*Número de teléfono:</label>
                        <input type="number" class="form-control" name="tel" id="tel"  placeholder="7771345606" value="<%= usuarioe.getTelefono() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese el número de teléfono del usuario.
                        </div>
                    </div>
                    <div class="form-group">
                        <label >*Matrícula:</label>
                        <input type="text" class="form-control" name="matri" id="matri" placeholder="Matricula" value="<%= usuarioe.getMatricula() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese la matrícula del usuario.
                        </div>
                    </div>
                    <div class="form-group">
                        <label >*Correo electrónico:</label>
                        <input type="text" class="form-control" name="user" id="user"  placeholder="Correo" value="<%= usuarioe.getUser() %>" required>
                        <div class="invalid-feedback">
                            Por favor, ingrese el correo electrónico institucional del usuario.
                        </div>
                    </div>
                  <div class="form-row">
                      <div class="form-group col-md-6">
                          <label>*Contraseña:</label>
                          <input type="password" class="form-control" id="pass" value="<%= usuarioe.getPass() %>" name="pass" placeholder="Contraseña" required>
                          <small  class="form-text text-muted">
                              La contraseña debe contener al menos 8 caracteres, mayúsculas y minúsculas, números y caracteres especiales como @,%,&
                          </small>
                      </div>
                      <div class="form-group col-md-6">
                          <label>*Confirmar Contraseña:</label>
                          <input type="password" class="form-control" id="pass2" value="<%= usuarioe.getPass() %>" name="pass2" placeholder="Contraseña" required>

                      </div>
                  </div>
                    <div class="form-group">
                        <label >*Tipo de Usuario</label>
                        <select class="custom-select" name="tipo_usuario" id="tipo_usuario" >
                            <option selected value="<%= usuarioe.getTipo_usuario()  %>"><%=  usuarioe.getTipo_usuario()  %></option>
                            <option value="">Elegir un tipo de usuario</option>
                            <option value="Administrador">Administrador</option>
                            <option value="Usuario">Usuario</option>
                        </select>
                        <div class="invalid-feedback">
                            Por favor, seleccione el tipo de usuario.
                        </div>
                    </div>
            </div>
                    <div class="card-footer text-center">
                        <button  type="button"  class="btn btn-secondary btn-lg"  onclick="validarCampos()"
                                style="background-color: #345177;color:#fff " >Modificar</button>
                    </fieldset>
            </div>
        </div>
    </div>
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
    <script src="js/functionValModUsu.js" ></script>
</body>
</html>
<%
    }else{
        System.out.println("Error al iniciar sesión");
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
%>