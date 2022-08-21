package mx.edu.utez.integradora.service.administration.prestamo;

import mx.edu.utez.integradora.model.administration.prestamo.beanPrestamo;
import mx.edu.utez.integradora.utility.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoPrestamo {
    public static int realizarPrestamo(beanPrestamo e) {
        int status = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(" insert into prestamos_disp(nombre,apo_pto,apo_mto,correo,matricula,telefono,fechaprestamo,estatus_prestamo,dispositivo_id) values (?,?,?,?,?,?,?,?,?)");
            PreparedStatement ps2= con.prepareStatement(" update dispositivos set estatus='Prestado' where id_dispositivo=?");
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApo_pto());
            ps.setString(3, e.getApo_mto());
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getMatricula());
            ps.setString(6,e.getTelefono());
            ps.setString(7, e.getFecha_inicio());
            ps.setString(8, e.getEstatus());
            ps.setInt(9, e.getId_dispositivo());
            ps2.setInt(1,e.getId_dispositivo());
            status = ps.executeUpdate()+ps2.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
 public static List<beanPrestamo> getTodosPresDisp() {
        List<beanPrestamo> list = new ArrayList<beanPrestamo>();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from integradora.prestamos_disp;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beanPrestamo e = new beanPrestamo ();
                e.setId_prestamo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApo_pto(rs.getString(3));
                e.setApo_mto(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setMatricula(rs.getString(6));
                e.setTelefono(rs.getString(7));
                e.setFecha_inicio(rs.getString(8));
                e.setFecha_final(rs.getString(9));
                e.setEstatus(rs.getString(10));
                e.setId_dispositivo(rs.getInt(11));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(DaoPrestamo.getTodosPresDisp());

    }
    public static int entregarPrestamo(beanPrestamo e) {
        int status = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update prestamos_disp set estatus_prestamo='Entregado',fecha_devolucion=? where id_prestamo=?");
            PreparedStatement ps2= con.prepareStatement(" update dispositivos set estatus='Disponible',observaciones=? where id_dispositivo=?");
            ps.setString(1, e.getFecha_final());
            ps.setInt(2, e.getId_prestamo());
            ps2.setString(1,e.getObservaciones());
            ps2.setInt(2,e.getId_dispositivo());
            status = ps.executeUpdate()+ps2.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static beanPrestamo getPrestamoId(int id) {
        beanPrestamo e = new beanPrestamo();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from integradora.prestamos_disp where id_prestamo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId_prestamo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApo_pto(rs.getString(3));
                e.setApo_mto(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setMatricula(rs.getString(6));
                e.setTelefono(rs.getString(7));
                e.setFecha_inicio(rs.getString(8));
                e.setFecha_final(rs.getString(9));
                e.setEstatus(rs.getString(10));
                e.setId_dispositivo(rs.getInt(11));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
    public static beanPrestamo getPresMaleId(int id) {
        beanPrestamo e = new beanPrestamo();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from integradora.prestamos_male where id_prestamo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId_prestamo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApo_pto(rs.getString(3));
                e.setApo_mto(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setMatricula(rs.getString(6));
                e.setTelefono(rs.getString(7));
                e.setFecha_inicio(rs.getString(8));
                e.setFecha_final(rs.getString(9));
                e.setEstatus(rs.getString(10));
                e.setId_maletin(rs.getInt(11));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static int realizarPrestamoMale(beanPrestamo e) {
        int status = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into prestamos_male(nombre,apo_pto,apo_mto,correo,matricula,telefono,fechaprestamo,estatus_prestamo,maletin_id) values (?,?,?,?,?,?,?,?,?)");
            PreparedStatement ps2= con.prepareStatement(" update maletines set estatus='Prestado' where id_male=?");
            ps.setString(1, e.getNombre());
            ps.setString(2, e.getApo_pto());
            ps.setString(3, e.getApo_mto());
            ps.setString(4, e.getCorreo());
            ps.setString(5, e.getMatricula());
            ps.setString(6,e.getTelefono());
            ps.setString(7, e.getFecha_inicio());
            ps.setString(8, e.getEstatus());
            ps.setInt(9, e.getId_maletin());
            ps2.setInt(1,e.getId_maletin());
            status = ps.executeUpdate()+ps2.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    public static List<beanPrestamo> getTodosPresMale() {
        List<beanPrestamo> list = new ArrayList<beanPrestamo>();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from integradora.prestamos_male;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beanPrestamo e = new beanPrestamo ();
                e.setId_prestamo(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApo_pto(rs.getString(3));
                e.setApo_mto(rs.getString(4));
                e.setCorreo(rs.getString(5));
                e.setMatricula(rs.getString(6));
                e.setTelefono(rs.getString(7));
                e.setFecha_inicio(rs.getString(8));
                e.setFecha_final(rs.getString(9));
                e.setEstatus(rs.getString(10));
                e.setId_maletin(rs.getInt(11));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static int entregarPrestMale(beanPrestamo e) {
        int status = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update prestamos_male set estatus_prestamo='Entregado',fecha_devolucion=? where id_prestamo=?");
            PreparedStatement ps2= con.prepareStatement(" update maletines set estatus='Disponible',observacion=? where id_male=?");
            ps.setString(1, e.getFecha_final());
            ps.setInt(2, e.getId_prestamo());
            ps2.setString(1,e.getObservaciones());
            ps2.setInt(2,e.getId_maletin());
            status = ps.executeUpdate()+ps2.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

}
