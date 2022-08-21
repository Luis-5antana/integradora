package mx.edu.utez.integradora.controller.administration.maletin;
import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//ver maletines INTF USUARIO
@WebServlet("/viewMaletin2")
public class viewMaletin2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        List<beanMaletin> list= DaoMaletin.getTodosMaletines();
        request.setAttribute("maletine", list);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/UE_consMale.jsp");
        view.forward(request,response);
    }
}
