package mx.edu.utez.integradora.controller.administration.display;
import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.service.administration.display.DaoDisplay;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    @WebServlet("/editDisplay2")
    public class editDisplay2 extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String mensaje="";
            String sid=request.getParameter("id");
            int id=Integer.parseInt(sid);
            String serie=request.getParameter("num_serie");
            String inven=request.getParameter("num_inv");
            String marca=request.getParameter("marca");
            String modelo=request.getParameter("modelo");
            String tipo=request.getParameter("tipo");
            String estatus=request.getParameter("estatus");
            String categoria=request.getParameter("categoria");
            String observacion=request.getParameter("observacion");
            System.out.println("num serie: "+serie);
            System.out.println("num inventario: "+inven);
            System.out.println("marca: "+marca);
            System.out.println("modelo: "+modelo);
            System.out.println("tipo: "+tipo);
            System.out.println("estatus: "+estatus);
            System.out.println("categoria: "+categoria);
            System.out.println("observacion: "+observacion);

            beanDisplay e= new beanDisplay(id,inven,serie,modelo,marca,estatus,observacion,tipo,categoria);

            int status= DaoDisplay.modDisp(e);
            if(status>0){
                mensaje = "false";
                System.out.println("El dispositivo ha sido modificado "+e.getId_dispositivo() );
            }else{
                System.out.println("erroe al modificar el dispositivo");
                mensaje = "true";
            }
            OutputStream oser = response.getOutputStream();
            oser.write(mensaje.getBytes());
            oser.flush();
        }

    }

