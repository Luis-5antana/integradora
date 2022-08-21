package mx.edu.utez.integradora.controller.administration.display;

import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.service.administration.display.DaoDisplay;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "ServletDisplay", value = "/ServletDisplay")
public class ServletDisplay extends HttpServlet {
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

            case "registrar":
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

                beanDisplay dispositivo = new beanDisplay(inven,serie,modelo,marca,estatus,observacion,tipo,categoria);
                if(new DaoDisplay().registrarDisp(dispositivo)){
                    mensaje = "true";
                    System.out.println("Dispositivo registrado correctamente.");
                }else{
                    mensaje = "false";
                    System.out.println("Error al registrar el dispositivo.");
                }
                doGet(request,response);
                break;
            default:
                break;

        }
        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }
    }

