package mx.edu.utez.integradora.controller.administration.person;
import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.person.DaoPerson;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//Servlet para ingresar a la pestaña consultar-usuarios Usuario
@WebServlet("/ViewPerson2")
public class ViewPerson2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<beanPerson> list= DaoPerson.getTodosUsuarios();
		request.setAttribute("usuario", list);
		RequestDispatcher view = getServletContext().getRequestDispatcher("/UE_consUsu.jsp");
		view.forward(request,response);
	}
}
