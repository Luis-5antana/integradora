package mx.edu.utez.integradora.controller.administration.person;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.person.DaoPerson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditPerson2")
public class EditPerson2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje="";
		String clase="";
		RequestDispatcher dispatcher=null;
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String user =request.getParameter("user");
		String nombre=request.getParameter("name");
		String apo_pto=request.getParameter("apo_pto");
		String apo_mto=request.getParameter("apo_mto");
		String pass=request.getParameter("pass");
		String matricula=request.getParameter("matri");
		String telefono=request.getParameter("tel");
		String tipo_usuario=request.getParameter("tipo_usuario");
		System.out.println("Modificando usuarios");
		System.out.println("ACT nombre: "+nombre);
		System.out.println("ACT pass: "+pass);
		System.out.println("ACT correo: "+user);
		System.out.println("ACT apo: "+apo_pto);
		System.out.println("ACT apo: "+apo_mto);
		System.out.println("ACT matricula: "+matricula);
		System.out.println("ACT tel: "+telefono);
		System.out.println("ACT usuaruo: "+tipo_usuario);
		beanPerson e=new beanPerson(id,user,pass,tipo_usuario,nombre,apo_mto,apo_pto,matricula,telefono);
		int status=DaoPerson.modificarUsuario(e);
		if(status>0){
			System.out.println("El  USUARIO ha sido modificado "+e.getId() );
			mensaje="true";
		}else {
			System.out.println("error al modificar el USUARIO");
			mensaje="false";
		}
		OutputStream os = response.getOutputStream();
		os.write(mensaje.getBytes());
		os.flush();
	}

}
