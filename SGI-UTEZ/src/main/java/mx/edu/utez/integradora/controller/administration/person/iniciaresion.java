package mx.edu.utez.integradora.controller.administration.person;

import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.person.DaoPerson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "iniciaresion", urlPatterns = "/iniciaresion")
public class iniciaresion extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String mensaje="";
            HttpSession sesionLogin;
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
                        if(usuario.getTipo_usuario().equals("Administrador")){
                            mensaje="true";
                        }else{
                            mensaje="true1";
                        }

                    }else{
                        System.out.println("No se encontró en la BD!");
                        mensaje = "false";
                    }
            OutputStream os = response.getOutputStream();
            os.write(mensaje.getBytes());
            os.flush();
        }

    }


