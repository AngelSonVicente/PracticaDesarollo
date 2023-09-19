package DatosBD;

public class ClientesTransaccionesMayores {
    private int CodigoTransaccion;
    private int CodigoCuenta;
    private int CodigoCliente;
    private int CodigoCajero;
    private float Monto;
    private String NombreCliente;
    private String Fecha;
    private String Hora;

    public ClientesTransaccionesMayores() {
    }

    public ClientesTransaccionesMayores(int codigoTransaccion, int codigoCuenta, int codigoCliente, int codigoCajero, float monto, String nombreCliente, String fecha, String hora) {
        CodigoTransaccion = codigoTransaccion;
        CodigoCuenta = codigoCuenta;
        CodigoCliente = codigoCliente;
        CodigoCajero = codigoCajero;
        Monto = monto;
        NombreCliente = nombreCliente;
        Fecha = fecha;
        Hora = hora;
    }

    public int getCodigoTransaccion() {
        return CodigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        CodigoTransaccion = codigoTransaccion;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        CodigoCuenta = codigoCuenta;
    }

    public int getCodigoCliente() {
        return CodigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        CodigoCliente = codigoCliente;
    }

    public int getCodigoCajero() {
        return CodigoCajero;
    }

    public void setCodigoCajero(int codigoCajero) {
        CodigoCajero = codigoCajero;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }
}
