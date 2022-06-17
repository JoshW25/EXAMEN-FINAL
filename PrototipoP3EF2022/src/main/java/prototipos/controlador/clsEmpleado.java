package prototipos.controlador;



public class clsEmpleado {

    private int id;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String correo;
    private int puesto;
    private String direccion;
    private String fecha;
    private String nit;
    private String dpi;
    
         

    public clsEmpleado() {
    }

    public clsEmpleado(int id, String nombre1, String nombre2, String apellido1, String apellido2, String correo, int puesto, String direccion, String fecha, String nit, String dpi) {
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.puesto = puesto;
        this.direccion = direccion;
        this.fecha = fecha;
        this.nit = nit;
        this.dpi = dpi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getPuesto() {
        return puesto;
    }

    public void setPuesto(int puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "clsEmpleado{" + "id=" + id + ", nombre1=" + nombre1 + ", nombre2=" + nombre2 + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", puesto=" + puesto + ", direccion=" + direccion + ", fecha=" + fecha + ", nit=" + nit + ", dpi=" + dpi + '}';
    }

    
   
    
    

    
   

   
    

  

 

 
 
 
 

    


 
    
}
