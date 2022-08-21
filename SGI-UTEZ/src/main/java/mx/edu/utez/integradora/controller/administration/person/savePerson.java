package mx.edu.utez.integradora.controller.administration.person;
import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.service.administration.person.DaoPerson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "savePerson", urlPatterns = "/savePerson")
public class savePerson extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String user;
    String pass;
    String nombre;
    String matricula;
    String apo_mto;
    String     apo_pto;
    String tipo_usuario;
    String telefono;
    String mensaje ="";

                user=request.getParameter("user");
                nombre=request.getParameter("name");
                apo_pto=request.getParameter("apo_pto");
                apo_mto=request.getParameter("apo_mto");
                pass=request.getParameter("pass");
                matricula=request.getParameter("matri");
                telefono=request.getParameter("tel");
                tipo_usuario=request.getParameter("tipo_usuario");

                System.out.println("nombre: "+nombre);
                System.out.println("pass: "+pass);
                System.out.println("correo: "+user);
                System.out.println("apo: "+apo_pto);
                System.out.println("apo: "+apo_mto);
                System.out.println("matricula: "+matricula);
                System.out.println("tel: "+telefono);
                System.out.println("usuaruo: "+tipo_usuario);
                beanPerson usuario;
                usuario=new beanPerson(nombre,apo_pto,apo_mto,user,matricula,telefono,pass,tipo_usuario);
                if(new DaoPerson().registrarUser(usuario)){
                    System.out.println("correctamente registrado EL USUARIO");
                    mensaje ="true";
                }else{
                    System.out.println("ERRR AL registrado EL USUARIO");
                    mensaje ="false";
                }

        OutputStream os = response.getOutputStream();
        os.write(mensaje.getBytes());
        os.flush();
    }

}
