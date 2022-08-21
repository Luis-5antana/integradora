package mx.edu.utez.integradora.controller.administration.person;


import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.person.DaoPerson;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditPerson")
public class EditPerson extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		beanPerson e= DaoPerson.getUsuariosId(id);
		request.setAttribute("usuarioe", e);
		RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_formModUsu.jsp");
		view.forward(request, response);
	}
}
