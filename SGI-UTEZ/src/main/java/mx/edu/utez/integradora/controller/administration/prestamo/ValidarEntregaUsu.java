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

@WebServlet(name = "ValidarEntregaUsu", value = "/ValidarEntregaUsu")
public class ValidarEntregaUsu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);

        beanPrestamo e=DaoPrestamo.getPrestamoId(id);

        request.setAttribute("Prestamoe", e);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/UE_EntPresUsu.jsp");
        view.forward(request, response);
    }
}
