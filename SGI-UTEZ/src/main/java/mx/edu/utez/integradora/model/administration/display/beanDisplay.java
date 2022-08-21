package mx.edu.utez.integradora.model.administration.display;

public class beanDisplay {
    private int id_dispositivo ;
    private String num_inventario ;
   private String  num_serie;
   private String modelo;
   private String marca;
   private  String estatus;
  private  String  observaciones;
private  String    tipo_dpo ;
private String    cta_dpo;

    public void setId_dispositivo(int id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public int getId_dispositivo() {
        return id_dispositivo;
    }

    public void setNum_inventario(String num_inventario) {
        this.num_inventario = num_inventario;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setTipo_dpo(String tipo_dpo) {
        this.tipo_dpo = tipo_dpo;
    }

    public void setCta_dpo(String cta_dpo) {
        this.cta_dpo = cta_dpo;
    }

    public String getNum_inventario() {
        return num_inventario;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getTipo_dpo() {
        return tipo_dpo;
    }

    public String getCta_dpo() {
        return cta_dpo;
    }

    //constructor para registro
    public beanDisplay(String num_inventario,String  num_serie,String modelo,String marca,String estatus,String observaciones,String tipo_dpo,String cta_dpo){
        this.num_inventario=num_inventario;
        this.num_serie=num_serie;
        this.modelo=modelo;
        this.marca=marca;
        this.estatus=estatus;
        this.observaciones=observaciones;
        this.tipo_dpo=tipo_dpo;
        this.cta_dpo=cta_dpo;
    }

    @Override
    public String toString() {
        return "beanDisplay{" +
                "id_dispositivo=" + id_dispositivo +
                ", num_inventario='" + num_inventario + '\'' +
                ", num_serie='" + num_serie + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", estatus='" + estatus + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", tipo_dpo='" + tipo_dpo + '\'' +
                ", cta_dpo='" + cta_dpo + '\'' +
                '}';
    }

    public beanDisplay(int id_dispositivo, String num_inventario, String num_serie, String modelo, String marca, String estatus, String observaciones, String tipo_dpo, String cta_dpo) {
        this.id_dispositivo = id_dispositivo;
        this.num_inventario = num_inventario;
        this.num_serie = num_serie;
        this.modelo = modelo;
        this.marca = marca;
        this.estatus = estatus;
        this.observaciones = observaciones;
        this.tipo_dpo = tipo_dpo;
        this.cta_dpo = cta_dpo;
    }

    public  beanDisplay (){

  }
}
