package DatosBD;

public class NuevoCliente {
    private int codigo;
    private String nombre;
    private String temporalPass;


    public NuevoCliente() {
    }

    public NuevoCliente(int codigo, String nombre, String temporalPass) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.temporalPass = temporalPass;
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

    public String getTemporalPass() {
        return temporalPass;
    }

    public void setTemporalPass(String temporalPass) {
        this.temporalPass = temporalPass;
    }
}

