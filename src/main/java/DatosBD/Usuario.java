package DatosBD;

public class Usuario {
    private int codigo;
    private String nombre;
    private String DPI;
    private int TipoUsuario;

    public Usuario() {
    }

    public Usuario(int codigo, String nombre, String DPI, int tipoUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.DPI = DPI;
        TipoUsuario = tipoUsuario;
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

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public int getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        TipoUsuario = tipoUsuario;
    }
}

