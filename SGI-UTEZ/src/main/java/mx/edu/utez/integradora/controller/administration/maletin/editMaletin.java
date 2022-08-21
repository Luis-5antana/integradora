package mx.edu.utez.integradora.controller.administration.maletin;
import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/editMaletin")
public class editMaletin extends HttpServlet  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid=request.getParameter("id");
        int id=Integer.parseInt(sid);
        beanMaletin e= DaoMaletin.getMaletinId(id);
        request.setAttribute("maletine", e);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_formModMale.jsp");
        view.forward(request, response);
    }
}

