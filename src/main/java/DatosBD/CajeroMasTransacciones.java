package DatosBD;

public class CajeroMasTransacciones {
    private int codigo;
    private String Nombre;

    private int CantidadTransacciones;

    public CajeroMasTransacciones() {
    }

    public CajeroMasTransacciones(int codigo, String nombre, int cantidadTransacciones) {
        this.codigo = codigo;
        Nombre = nombre;
        CantidadTransacciones = cantidadTransacciones;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidadTransacciones() {
        return CantidadTransacciones;
    }

    public void setCantidadTransacciones(int cantidadTransacciones) {
        CantidadTransacciones = cantidadTransacciones;
    }
}
