package DatosBD;

public class Cuenta {
    private int Codigo;
    private int CodigoCliente;
    private String NombreCliente;
    private String FechaCreacion;
    private float saldo;

    public Cuenta() {
    }

    public Cuenta(int codigo, int codigoCliente, String nombreCliente, String fechaCreacion, float saldo) {
        Codigo = codigo;
        CodigoCliente = codigoCliente;
        NombreCliente = nombreCliente;
        FechaCreacion = fechaCreacion;
        this.saldo = saldo;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        CodigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
