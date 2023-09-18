package DatosBD;

public class SolicitudAsociacion {

    private int codigo;
        private int CodigoCliente;
        private int CodigoCuenta;
        private String fecha;
        private String Estado;

    public SolicitudAsociacion() {
    }

    public SolicitudAsociacion(int codigo, int codigoCliente, int codigoCuenta, String fecha, String estado) {
        this.codigo = codigo;
        CodigoCliente = codigoCliente;
        CodigoCuenta = codigoCuenta;
        this.fecha = fecha;
        Estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        CodigoCliente = codigoCliente;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        CodigoCuenta = codigoCuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
