package mx.edu.utez.integradora.controller.administration.maletin;
import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteMaletin")
public class deleteMaletin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        String mensaje="";
        int id = Integer.parseInt(sid);
        int status=DaoMaletin.borrarMale(id);
//Mover a todos los serlets de modificar e iliminar
        if(status>0){
            System.out.println("El  MALETIN ha sido eliminado " );
            mensaje = "true";

        }else{
            System.out.println("error al eliminar el MALETIN");
            mensaje = "false";
        }

        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }
}