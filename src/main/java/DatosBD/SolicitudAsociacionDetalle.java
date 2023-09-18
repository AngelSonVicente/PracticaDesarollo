package DatosBD;

public class SolicitudAsociacionDetalle {

    private int Codigo;
    private int CodigoCliente;
    private String NombreCliente;
    private String DPI;
    private  String Fecha;
    private String Estado;


    public SolicitudAsociacionDetalle() {
    }

    public SolicitudAsociacionDetalle(int codigo, int codigoCliente, String nombreCliente, String DPI, String fecha, String estado) {
        Codigo = codigo;
        CodigoCliente = codigoCliente;
        NombreCliente = nombreCliente;
        this.DPI = DPI;
        Fecha = fecha;
        Estado = estado;
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

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }
}
