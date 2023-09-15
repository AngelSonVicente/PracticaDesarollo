package DatosBD;

public class UsuarioT3 {
    private int codigo;
    private  String nombre;
    private String Direccion;
    private String dpi;
    private String sexo;


    public UsuarioT3() {
    }

    public UsuarioT3(int codigo, String nombre, String direccion, String dpi, String sexo) {
        this.codigo = codigo;
        this.nombre = nombre;
        Direccion = direccion;
        this.dpi = dpi;
        this.sexo = sexo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
