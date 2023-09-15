package DatosBD;

public class UsuarioT2 {
    private int Codigo;
    private String Nombre;
    private String Direccion;
    private String DPI;
    private String sexo;
    private int Turno;

    public UsuarioT2() {
    }

    public UsuarioT2(int codigo, String nombre, String direccion, String DPI, String sexo, int turno) {
        Codigo = codigo;
        Nombre = nombre;
        Direccion = direccion;
        this.DPI = DPI;
        this.sexo = sexo;
        Turno = turno;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }
}
