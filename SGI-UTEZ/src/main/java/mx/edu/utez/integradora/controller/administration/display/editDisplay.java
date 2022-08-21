package mx.edu.utez.integradora.controller.administration.display;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.service.administration.display.DaoDisplay;
@WebServlet("/editDisplay")
public class editDisplay extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sid=request.getParameter("id");
            int id=Integer.parseInt(sid);

            beanDisplay e=DaoDisplay.getDispID(id);

            request.setAttribute("dispositivoe", e);
            RequestDispatcher view = getServletContext().getRequestDispatcher("/AD_formModDisp.jsp");
            view.forward(request, response);
        }
    }
