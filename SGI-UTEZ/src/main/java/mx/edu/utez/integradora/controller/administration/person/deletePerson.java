package mx.edu.utez.integradora.controller.administration.person;

import mx.edu.utez.integradora.service.administration.person.DaoPerson;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deletePerson")
public class deletePerson extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        int status = DaoPerson.eliminarUsuario(id);
        String mensaje = "";

        if (status > 0) {
            System.out.println("El USUARIO ha sido eliminado ");
            mensaje = "true";
        } else {
            System.out.println("error al eliminar el USUARIO");
            mensaje = "false";
        }

        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }
}
