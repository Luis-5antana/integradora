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

@WebServlet(name = "EntregarPrestamo", value = "/EntregarPrestamo")
public class EntregarPrestamo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mensaje="";
        String clase="";

        String sid= request.getParameter("disp");
        String pid= request.getParameter("id");
        int id_pres= Integer.parseInt(pid);
        int id_disp= Integer.parseInt(sid);
            String estatus=request.getParameter("estatus");
            String observaciones= request.getParameter("obser");
            String fecha=request.getParameter("fecha");
        String est_disp=request.getParameter("disp_estatus");
        System.out.println(estatus);
        System.out.println(id_pres);
        System.out.println(id_disp);
        System.out.println(observaciones);
        System.out.println(est_disp);
        System.out.println(fecha);
            beanPrestamo e= new beanPrestamo(id_disp,id_pres,estatus,observaciones,fecha,est_disp);
            int status= DaoPrestamo.entregarPrestamo(e);
        System.out.println("status " +status);
        if(status>0){
            mensaje = "true";
            System.out.println("prestamo entregdo con exito ");
        }else {
            System.out.println("Error al registrar el prestamo");
            mensaje = "false";
        }
        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }

}
