package mx.edu.utez.integradora.controller.administration.prestamo;

import mx.edu.utez.integradora.model.administration.prestamo.beanPrestamo;
import mx.edu.utez.integradora.service.administration.prestamo.DaoPrestamo;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
@WebServlet(name = "ServletPrestamo", value = "/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje="";
        String clase="";
        String sid= request.getParameter("disp");
        int id_disp= Integer.parseInt(sid);
        String nom= request.getParameter("nom");
        String apo_pto= request.getParameter("apo_pto");
        String apo_mto= request.getParameter("apo_mto");
            String tel= request.getParameter("tel");
            String matricula= request.getParameter("matri");
            String estatus=request.getParameter("estatus");
            String correo= request.getParameter("email");
            String fecha=request.getParameter("fecha");
        String est_disp=request.getParameter("disp_estatus");
        System.out.println(nom);
        System.out.println(est_disp);
        System.out.println(estatus);
            beanPrestamo e= new beanPrestamo(nom,apo_pto,apo_mto,correo,matricula,fecha,id_disp,estatus,est_disp,tel);
            int status= DaoPrestamo.realizarPrestamo(e);
        if(status>0){
            System.out.println("prestamo registrado con exito ");
            mensaje = "true";
        }else {
            System.out.println("Error al registrar el prestamo");
            mensaje = "false";
        }
        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }
}
