package mx.edu.utez.integradora.controller.administration.maletin;
import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//ver maletines para prestamos de maletines
@WebServlet("/viewMaletin3")
public class viewMaletin3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom= request.getParameter("name");
        String apo_pto= request.getParameter("apo_pto");
        String apo_mto= request.getParameter("apo_mto");
        String tipo= request.getParameter("tipo");
        beanPerson e = new beanPerson(nom,apo_pto,apo_mto,tipo);
        List<beanMaletin> list= DaoMaletin.getTodosMaletines();
        request.setAttribute("maletine", list);
        request.setAttribute("Prestatario",e);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_regPresMale1.jsp");
        view.forward(request,response);
    }
}
