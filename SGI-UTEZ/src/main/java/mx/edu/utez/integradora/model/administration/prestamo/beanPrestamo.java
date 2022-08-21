package mx.edu.utez.integradora.model.administration.prestamo;

public class beanPrestamo {
    private int id_prestamo;
    private String nombre;
    private String apo_mto;
    private String apo_pto;
    private String correo;
    private String matricula;
    private String fecha_inicio;
    private String fecha_final;
    private int id_dispositivo;
    private int id_maletin;
    private String estatus;
    private String estatus_disp;
    private String telefono;
    private String observaciones;

    public beanPrestamo(int id_prestamo, String nombre, String apo_mto, String apo_pto, String correo, String matricula, String fecha_inicio, String fecha_final, int id_dispositivo, int id_maletin, String estatus, String telefono) {
        this.id_prestamo = id_prestamo;
        this.nombre = nombre;
        this.apo_mto = apo_mto;
        this.apo_pto = apo_pto;
        this.correo = correo;
        this.matricula = matricula;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.id_dispositivo = id_dispositivo;
        this.id_maletin = id_maletin;
        this.estatus = estatus;
        this.telefono = telefono;
    }

    //registrar solo dispositivos
    public beanPrestamo(String nombre, String apo_mto, String apo_pto, String correo, String matricula, String fecha_inicio, int id_dispositivo, String estatus,String estatus_disp, String telefono) {
        this.nombre = nombre;
        this.apo_mto = apo_mto;
        this.apo_pto = apo_pto;
        this.correo = correo;
        this.matricula = matricula;
        this.fecha_inicio = fecha_inicio;
        this.id_dispositivo = id_dispositivo;
        this.estatus = estatus;
        this.estatus_disp=estatus_disp;
        this.telefono = telefono;
    }
    public beanPrestamo(String nombre, String apo_mto, String apo_pto, String correo, String matricula, String fecha_inicio, String estatus,int id_maletin,String estatus_disp, String telefono) {
        this.nombre = nombre;
        this.apo_mto = apo_mto;
        this.apo_pto = apo_pto;
        this.correo = correo;
        this.matricula = matricula;
        this.fecha_inicio = fecha_inicio;
        this.estatus = estatus;
        this.id_maletin = id_maletin;
        this.estatus_disp=estatus_disp;
        this.telefono = telefono;
    }
public beanPrestamo (){

}

    @Override
    public String toString() {
        return "beanPrestamo{" +
                "id_prestamo=" + id_prestamo +
                ", nombre='" + nombre + '\'' +
                ", apo_mto='" + apo_mto + '\'' +
                ", apo_pto='" + apo_pto + '\'' +
                ", correo='" + correo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", fecha_inicio='" + fecha_inicio + '\'' +
                ", fecha_final='" + fecha_final + '\'' +
                ", id_dispositivo=" + id_dispositivo +
                ", id_maletin=" + id_maletin +
                ", estatus='" + estatus + '\'' +
                ", estatus_disp='" + estatus_disp + '\'' +
                ", telefono='" + telefono + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }




    public String getEstatus_disp() {
        return estatus_disp;
    }

    public void setEstatus_disp(String estatus_disp) {
        this.estatus_disp = estatus_disp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApo_mto() {
        return apo_mto;
    }

    public void setApo_mto(String apo_mto) {
        this.apo_mto = apo_mto;
    }

    public String getApo_pto() {
        return apo_pto;
    }

    public void setApo_pto(String apo_pto) {
        this.apo_pto = apo_pto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public int getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(int id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public int getId_maletin() {
        return id_maletin;
    }

    public void setId_maletin(int id_maletin) {
        this.id_maletin = id_maletin;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
//construcor para prestamos
    public beanPrestamo ( int id_dispositivo,int id_prestamo,String estatus,String observaciones,String fecha_final, String estatus_disp){
        this.id_dispositivo=id_dispositivo;
        this.id_prestamo=id_prestamo;
        this.estatus=estatus;
        this.observaciones=observaciones;
        this.fecha_final=fecha_final;
        this.estatus_disp=estatus_disp;

    }
//const prar devolver prestamo
    public beanPrestamo(String estatus, String estatus_disp, int id_maletin, int id_prestamo, String fecha_final, String observaciones){
        this.estatus=estatus;
        this.estatus_disp=estatus_disp;
        this.id_maletin=id_maletin;
        this.id_prestamo =id_prestamo;
        this.fecha_final =fecha_final;
        this.observaciones =observaciones;
    }
}

