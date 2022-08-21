package mx.edu.utez.integradora.model.administration.maletin;

public class beanMaletin {
  private int id_male    ;
 private    String cta_male          ;
   private
   String descripcion    ;
  private String estatus         ;
 private   String observacion  ;
    private String num_inventario ;
public  beanMaletin(){

}
    public beanMaletin(String cta_male, String descripcion, String estatus, String observacion, String num_inventario) {
        this.cta_male = cta_male;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.observacion = observacion;
        this.num_inventario = num_inventario;
    }

    public beanMaletin(int id_male, String cta_male, String descripcion, String estatus, String observacion, String num_inventario) {
        this.id_male = id_male;
        this.cta_male = cta_male;
        this.descripcion = descripcion;
        this.estatus = estatus;
        this.observacion = observacion;
        this.num_inventario = num_inventario;
    }

    @Override
    public String toString() {
        return "beanMaletin{" +
                "id_male=" + id_male +
                ", cta_male='" + cta_male + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estatus='" + estatus + '\'' +
                ", observacion='" + observacion + '\'' +
                ", num_inventario='" + num_inventario + '\'' +
                '}';
    }

    public String getNum_inventario() {
        return num_inventario;
    }

    public void setNum_inventario(String num_inventario) {
        this.num_inventario = num_inventario;
    }

    public int getId_male() {
        return id_male;
    }

    public void setId_male(int id_male) {
        this.id_male = id_male;
    }

    public String getCta_male() {
        return cta_male;
    }

    public void setCta_male(String cta_male) {
        this.cta_male = cta_male;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
