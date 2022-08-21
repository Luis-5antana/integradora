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
import java.util.List;

@WebServlet("/viewPrestamoUsu1")
// Mostrar prestamos para entregar INTERFAZ USUARIO
public class viewPrestamoUsu1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<beanPrestamo> listMale= DaoPrestamo.getTodosPresMale();
        List<beanPrestamo> list= DaoPrestamo.getTodosPresDisp();
        request.setAttribute("prestamos", list);
        request.setAttribute("prestamosMale", listMale);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/UE_Pres_Act.jsp");
        view.forward(request,response);

    }
}
