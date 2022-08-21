package mx.edu.utez.integradora.service.administration.display;

import mx.edu.utez.integradora.model.administration.display.beanDisplay;
import mx.edu.utez.integradora.utility.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoDisplay {
    public boolean registrarDisp(beanDisplay dispositivo) {
        try (Connection con = conexion.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into dispositivos (num_inventario,num_serie,modelo,marca,estatus,observaciones,tipo_dpo,cta_dpo) values (?,?,?,?,?,?,?,?)")
            ) {
                pstm.setString(1, dispositivo.getNum_inventario());
                pstm.setString(2, dispositivo.getNum_serie());
                pstm.setString(3, dispositivo.getModelo());
                pstm.setString(4, dispositivo.getMarca());
                pstm.setString(5, dispositivo.getEstatus());
                pstm.setString(6, dispositivo.getObservaciones());
                pstm.setString(7, dispositivo.getTipo_dpo());
                pstm.setString(8, dispositivo.getCta_dpo());
                return pstm.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
public static int modDisp(beanDisplay e) {
        int status = 0;
        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update dispositivos set num_inventario=?,num_serie=?,modelo=?,marca=?,estatus=?,observaciones=?,tipo_dpo=?,cta_dpo=? where id_dispositivo=?");
            ps.setString(1, e.getNum_inventario());
            ps.setString(2, e.getNum_serie());
            ps.setString(3, e.getModelo());
            ps.setString(4, e.getMarca());
            ps.setString(5, e.getEstatus());
            ps.setString(6, e.getObservaciones());
            ps.setString(7, e.getTipo_dpo());
            ps.setString(8, e.getCta_dpo());
            ps.setInt(9, e.getId_dispositivo());

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
    public static beanDisplay getDispID (int id) {
        beanDisplay e = new beanDisplay();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from dispositivos where id_dispositivo=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId_dispositivo(rs.getInt(1));
                e.setNum_inventario(rs.getString(2));
                e.setNum_serie(rs.getString(3));
                e.setModelo(rs.getString(4));
                e.setMarca(rs.getString(5));
                e.setEstatus(rs.getString(6));
                e.setObservaciones(rs.getString(7));
                e.setTipo_dpo(rs.getString(8));
                e.setCta_dpo(rs.getString(9));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }

    public static List<beanDisplay> getTodosDispositivos() {
        List<beanDisplay> list = new ArrayList<beanDisplay>();

        try {
            Connection con = conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from dispositivos");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beanDisplay e = new beanDisplay();
                e.setId_dispositivo(rs.getInt(1));
                e.setNum_inventario(rs.getString(2));
                e.setNum_serie(rs.getString(3));
                e.setModelo(rs.getString(4));
                e.setMarca(rs.getString(5));
                e.setEstatus(rs.getString(6));
                e.setObservaciones(rs.getString(7));
                e.setTipo_dpo(rs.getString(8));
                e.setCta_dpo(rs.getString(9));
                list.add(e);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(DaoDisplay.getTodosDispositivos());
    }


public static int eliminar_dispositivos(int id) {
		int status = 0;
		try {
			Connection con = conexion.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from dispositivos where id_dispositivo=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}


