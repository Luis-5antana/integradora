package mx.edu.utez.integradora.model.administration.person;

public class beanPerson {
    private int id;
    private String nombre;
    //email en basedatos
    private String user;
    //contrasena en bd
    private String pass;
    private String apo_mto;
    private String apo_pto;
    private String telefono;
    private String tipo_usuario;
    private String matricula;
    //constructor para login mostrar datos

    public  beanPerson (String nombre,String apo_pto,String apo_mto,String tipo_usuario){
        this.nombre=nombre;
        this.apo_pto=apo_pto;
        this.apo_mto=apo_mto;
        this.tipo_usuario=tipo_usuario;
    }
    //constructor para login xomparar
       public beanPerson(String user, String pass){
           this.user=user;
           this.pass=pass;
       }

    //constructor parar regisstrear
public  beanPerson(){

}
    public beanPerson(String nombre,String apo_pto,String apo_mto,String user, String matricula,String telefono, String pass,String tipo_usuario) {
     this.nombre=nombre;
     this.apo_pto = apo_pto;
     this.apo_mto=apo_mto;
     this.user=user;
     this.matricula=matricula;
     this.telefono=telefono;
     this.pass=pass;
     this.tipo_usuario=tipo_usuario;
    }
       //contrs para los datos del usuariop
        public beanPerson(int id,String user,String pass,String tipo_usuario,String nombre,String apo_mto,String apo_pto,String matricula,String telefono   ){
        this.id=id;
        this.user=user;
        this.pass=pass;
        this.tipo_usuario=tipo_usuario;
        this.nombre=nombre;
        this.apo_mto=apo_mto;
        this.apo_pto=apo_pto;
        this.matricula=matricula;
        this.telefono=telefono;
}
    @Override
    public String toString() {
        return "beanPerson{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", apo_mto='" + apo_mto + '\'' +
                ", apo_pto='" + apo_pto + '\'' +
                ", telefono=" + telefono +
                ", tipo_usuario='" + tipo_usuario + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }

    public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setPass(String pass) {
            this.pass = pass;
        }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getUser() {
            return user;
        }


        public String getPass() {
            return pass;
        }


    public void setApo_mto(String apo_mto) {
        this.apo_mto = apo_mto;
    }

    public String getApo_mto() {
        return apo_mto;
    }

    public void setApo_pto(String apo_pto) {
        this.apo_pto = apo_pto;
    }

    public String getApo_pto() {
        return apo_pto;
    }



    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}

