package mx.edu.utez.integradora.controller.administration.display;


import mx.edu.utez.integradora.service.administration.display.DaoDisplay;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteDisplay")
public class DeleteDisplay extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mensaje="";
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		int status = DaoDisplay.eliminar_dispositivos(id);
		if(status>0){
			System.out.println("El Dispositivo ha sido eliminado " );
			mensaje = "true";
		}else {
			System.out.println("error al eliminar el Dispositivo");
			mensaje = "false";
		}
		OutputStream os = response.getOutputStream();
		os.write(mensaje.getBytes());
		os.flush();

	}
}
