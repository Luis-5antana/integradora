package mx.edu.utez.integradora.service.administration.person;

import mx.edu.utez.integradora.model.administration.person.beanPerson;
import mx.edu.utez.integradora.utility.conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DaoPerson {
    //funciona completamente
    public beanPerson consultaLogin(beanPerson usuario) {
        beanPerson login = null;
        try {
            Connection con = conexion.getConnection();
            String sqlLogin = "SELECT * FROM usuarios WHERE email=? AND contrasena=?";
            PreparedStatement ps = con.prepareStatement(sqlLogin);
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPass());
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                login = new beanPerson(res.getInt("id_usuario"), res.getString("email"), res.getString("contrasena"), res.getString("tipo_usuario"),res.getString("nombre"),res.getString("apo_mto"),res.getString("apo_pto"), res.getString("matricula"),res.getString("telefono"));
                System.out.println(res.getInt("id_usuario"));
                System.out.println(res.getInt("email"));
                System.out.println(res.getInt("contrasena"));
                System.out.println(res.getInt("tipo_usuario"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
    //funciona
    public boolean registrarUser(beanPerson user) {
        try (Connection con = conexion.getConnection()) {
            try (
                    PreparedStatement pstm = con.prepareStatement("insert into usuarios (nombre,apo_pto,apo_mto,email,matricula,telefono,contrasena,tipo_usuario) values (?,?,?,?,?,?,?,?)")
            ) {
                pstm.setString(1, user.getNombre());
                pstm.setString(2, user.getApo_pto());
                pstm.setString(3, user.getApo_mto());
                pstm.setString(4, user.getUser());
                pstm.setString(5, user.getMatricula());
                pstm.setString(6, user.getTelefono());
                pstm.setString(7, user.getPass());
                pstm.setString(8, user.getTipo_usuario());
                return pstm.executeUpdate() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int modificarUsuario (beanPerson user) {
      int status=0;
            try{
                    Connection con=conexion.getConnection();
                PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET nombre=?, apo_pto=?, apo_mto=? ,email=?, matricula=? ,telefono=? ,contrasena=?, tipo_usuario=? WHERE id_usuario=?");
                ps.setString(1, user.getNombre());
                ps.setString(2, user.getApo_pto());
                ps.setString(3, user.getApo_mto());
                ps.setString(4, user.getUser());
                ps.setString(5, user.getMatricula());
                ps.setString(6, user.getTelefono());
                ps.setString(7, user.getPass());
                ps.setString(8, user.getTipo_usuario());
                ps.setInt(9,user.getId());
                status = ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }

        return status;
    }
    //consultatr usuaruos
    public static beanPerson getUsuariosId(int id) {
        beanPerson e = new beanPerson();

        try {
            Connection con=conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from usuarios where id_usuario=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                e.setId(rs.getInt(1));
                e.setNombre(rs.getString(2));
                e.setApo_pto(rs.getString(3));
                e.setApo_mto(rs.getString(4));
                e.setUser(rs.getString(5));
                e.setMatricula(rs.getString(6));
                e.setTelefono(rs.getString(7));
                e.setPass(rs.getString(8));
                e.setTipo_usuario(rs.getString(9));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
//funcional
    public static List<beanPerson> getTodosUsuarios() {
        List<beanPerson> list = new ArrayList<beanPerson>();
        try {
            Connection con=conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from usuarios");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                beanPerson e = new beanPerson();
                e.setId(rs.getInt("id_usuario"));
                e.setNombre(rs.getString("nombre"));
                e.setApo_pto(rs.getString("apo_pto"));
                e.setApo_mto(rs.getString("apo_mto"));
                e.setUser(rs.getString("email"));
                e.setMatricula(rs.getString("matricula"));
                e.setTelefono(rs.getString("telefono"));
                e.setPass(rs.getString("contrasena"));
                e.setTipo_usuario(rs.getString("tipo_usuario"));
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    public static void main(String[] args) {
        System.out.println(DaoPerson.getTodosUsuarios());

    }
    //Metodo para eliminar registros
    public static int eliminarUsuario(int id) {
        int status = 0;
        try {
            Connection con=conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from usuarios where id_usuario=?");
            ps.setInt(1, id);
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    }
