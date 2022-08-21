package mx.edu.utez.integradora.service.administration.maletin;

import mx.edu.utez.integradora.model.administration.maletin.beanMaletin;
import mx.edu.utez.integradora.utility.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoMaletin {
    public boolean registrarMaletin(beanMaletin maletin) {
        try (Connection con = conexion.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into maletines (num_inventario,cta_male,descripcion,estatus,observacion) values (?,?,?,?,?)")
            ) {  pstm.setString(1,maletin.getNum_inventario());
                pstm.setString(2,maletin.getCta_male());
                pstm.setString(3,maletin.getDescripcion());
                pstm.setString(4, maletin.getEstatus());
                pstm.setString(5, maletin.getObservacion());
                return pstm.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static int modMale(beanMaletin e) {
        int estatus = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update maletines set cta_male=?,descripcion=?,estatus=?,observacion=?,num_inventario=? where id_male=?");
            ps.setString(1, e.getCta_male());
            ps.setString(2, e.getDescripcion());
            ps.setString(3, e.getEstatus());
            ps.setString(4, e.getObservacion());
            ps.setString(5, e.getNum_inventario());
            ps.setInt(6, e.getId_male());

            estatus = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return estatus;
    }
//efrain
public static int borrarMale(int id) {
    int status = 0;
    try {
        Connection con = conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from maletines where id_male=?");
        ps.setInt(1, id);
        status = ps.executeUpdate();

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return status;
}
   //xonsultas
    public static beanMaletin getMaletinId(int id) {
        beanMaletin e = new beanMaletin();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from maletines  where id_male=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId_male(rs.getInt("id_male"));
                e.setEstatus(rs.getString("estatus"));
                e.setCta_male(rs.getString("cta_male"));
                e.setNum_inventario(rs.getString("num_inventario"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setObservacion(rs.getString("observacion"));

            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<beanMaletin> getTodosMaletines() {
        List<beanMaletin> list = new ArrayList<beanMaletin>();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from maletines");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beanMaletin e = new beanMaletin();
                e.setId_male(rs.getInt("id_male"));
                e.setEstatus(rs.getString("estatus"));
                e.setCta_male(rs.getString("cta_male"));
                e.setNum_inventario(rs.getString("num_inventario"));
                e.setDescripcion(rs.getString("descripcion"));
                e.setObservacion(rs.getString("observacion"));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(DaoMaletin.getTodosMaletines());

    }
}

