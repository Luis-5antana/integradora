package mx.edu.utez.integradora.controller.administration.maletin;

import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ServletMaletin",urlPatterns = "/ServletMaletin")
public class ServletMaletin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje = "";
        String peticion = request.getParameter("accion");
        Integer id_male    ;
        String cta_male          ;
        String descripcion    ;
        String estatus         ;
        String num_inventario ;
        String observacion;

        switch (peticion){
            case "registrar":
                cta_male =request.getParameter("categoria");
                descripcion=request.getParameter("descripcion");
                estatus=request.getParameter("estatus");
                num_inventario=request.getParameter("num_inventario");
                observacion=request.getParameter("observacion");

                System.out.println("AGREGGAR MALETIN");
                System.out.println("categoria: "+cta_male);
                System.out.println("descripcion: "+descripcion);
                System.out.println(" num_inventario: "+ num_inventario);
                System.out.println(" estatus: "+ estatus);
                System.out.println(" observacion: "+ observacion);
              beanMaletin maletin=new beanMaletin(cta_male,descripcion,estatus,observacion,num_inventario);
                if(new DaoMaletin().registrarMaletin(maletin)){
                    mensaje = "true";
                    System.out.println("El Maletin ha sido registrado");

                }else{
                    request.setAttribute("mensaje", "Error al registrar el maletin");
                    mensaje = "false";
                }
                doGet(request,response);
                break;
        }

        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }


}
