package mx.edu.utez.integradora.controller.administration.maletin;
    import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
    import mx.edu.utez.integradora.service.administration.maletin.DaoMaletin;

    import java.io.IOException;
    import java.io.OutputStream;
    import java.util.List;

    import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
    @WebServlet("/editMaletin2")
    public class editMaletin2 extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sid=request.getParameter("id");
            int id=Integer.parseInt(sid);
            String cta_male =request.getParameter("categoria");
            String descripcion=request.getParameter("descripcion");
            String estatus=request.getParameter("estatus");
            String num_inventario=request.getParameter("num_inventario");
            String observacion=request.getParameter("observacion");

            System.out.println("AGREGGAR MALETIN");
            System.out.println("categoria: "+cta_male);
            System.out.println("descripcion: "+descripcion);
            System.out.println(" num_inventario: "+ num_inventario);
            System.out.println(" estatus: "+ estatus);
            System.out.println(" observacion: "+ observacion);
            beanMaletin e=new beanMaletin(id,cta_male,descripcion,estatus,observacion,num_inventario);

            int status=DaoMaletin.modMale(e);

            String mensaje="";
            if(status>0){
                System.out.println("El  MALETIN ha sido modificado "+e.getId_male() );
                mensaje = "true";
            }else{
                System.out.println("error al modificar el MALETIN");
                mensaje = "false";
            }
            OutputStream os = response.getOutputStream();
            os.write(mensaje.getBytes());
            os.flush();
        }

    }


