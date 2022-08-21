package mx.edu.utez.integradora.controller.administration.display;
import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.display.DaoDisplay;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/viewDisplay1")
public class viewDisplay1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom= request.getParameter("name");
        String apo_pto= request.getParameter("apo_pto");
        String apo_mto= request.getParameter("apo_mto");
        String tipo= request.getParameter("tipo");
        beanPerson e = new beanPerson(nom,apo_pto,apo_mto,tipo);
       //solo listar s
        List<beanDisplay> list= DaoDisplay.getTodosDispositivos();
        request.setAttribute("dispositivo", list);
        request.setAttribute("prestatario",e);
        RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_regPres1.jsp");
        view.forward(request,response);
    }
}
