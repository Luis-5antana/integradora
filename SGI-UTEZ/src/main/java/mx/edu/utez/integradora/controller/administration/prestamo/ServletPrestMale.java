package mx.edu.utez.integradora.controller.administration.prestamo;

import mx.edu.utez.integradora.model.administration.prestamo.beanPrestamo;
import mx.edu.utez.integradora.service.administration.prestamo.DaoPrestamo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@WebServlet(name = "ServletPrestMale", value = "/ServletPrestMale")
public class ServletPrestMale extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje="";
        String clase="";
      /*  RequestDispatcher dispatcher=null;*/
        String sid= request.getParameter("disp");
        int id_male= Integer.parseInt(sid);
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
            beanPrestamo e= new beanPrestamo(nom,apo_pto,apo_mto,correo,matricula,fecha,estatus,id_male,est_disp,tel);
            int status= DaoPrestamo.realizarPrestamoMale(e);
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