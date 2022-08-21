package mx.edu.utez.integradora.controller.administration.person;

import mx.edu.utez.integradora.service.administration.person.DaoPerson;
import mx.edu.utez.integradora.model.administration.person.beanPerson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ServletPerson", urlPatterns = "/ServletPerson")
public class ServletPerson extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String mensaje="";
            String clase="";
            String peticion=request.getParameter("accion");
            RequestDispatcher dispatcher=null;
            HttpSession sesionLogin;
            switch (peticion){
                case "inicioSesion":
                    sesionLogin =request.getSession(true);
                    beanPerson usuario = new beanPerson(request.getParameter("user"), request.getParameter("pass") );
                    DaoPerson daoUsuario=new DaoPerson();
                    usuario=daoUsuario.consultaLogin(usuario);
                    System.out.println(request.getParameter("user"));
                    System.out.println(request.getParameter("pass"));
                    if(usuario !=null){
                        sesionLogin.setAttribute("user", usuario.getUser());
                        sesionLogin.setAttribute("pass",usuario.getPass());
                        sesionLogin.setAttribute("id",usuario.getId());
                        sesionLogin.setAttribute("matricula",usuario.getMatricula());
                        sesionLogin.setAttribute("nombre", usuario.getNombre());
                        sesionLogin.setAttribute("apo_pto",usuario.getApo_pto());
                        sesionLogin.setAttribute("apo_mto",usuario.getApo_mto());
                        sesionLogin.setAttribute("telefono",usuario.getTelefono());
                        sesionLogin.setAttribute("tipo_usuario",usuario.getTipo_usuario());
                        mensaje="true";
                        if(usuario.getTipo_usuario().equals("Administrador")){
                            dispatcher =request.getRequestDispatcher("AD_Perfil.jsp");
                        }else{
                            dispatcher =request.getRequestDispatcher("UE_perfil.jsp");
                        }

                    }else{
                        System.out.println("No se encontró en la BD!");
                        mensaje = "false";
                        OutputStream os = response.getOutputStream();
                        os.write(mensaje.getBytes());
                        os.flush();
                    }
                    break;
                case "cerrarSesion":
                    sesionLogin=request.getSession();
                    sesionLogin.setAttribute("user",null);
                    sesionLogin.setAttribute("pass",null);
                    sesionLogin.setAttribute("id",null);
                    sesionLogin.setAttribute("tipo usuario",null);
                    sesionLogin.invalidate();

                    RequestDispatcher dispatcher1= getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher1.forward(request,response);
                    break;
                default:
                    break;

            }

            dispatcher.forward(request,response);

        }

    }


