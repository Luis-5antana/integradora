package mx.edu.utez.integradora.controller.administration.display;


import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.service.administration.display.DaoDisplay;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//ConsultarDispositivosAdmin

@WebServlet("/viewConsultarDispo")
public class viewConsultarDispo extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<beanDisplay> list= DaoDisplay.getTodosDispositivos();
        request.setAttribute("dispositivo", list);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_consDisp.jsp");
        view.forward(request,response);
    }
}
