package DatosBD;

public class HistorialTransaccion {
    private int CodigoTransaccion;
    private int codigoCliente;
    private String NombreCliente;
    private int CodigoCuenta;
    private int CodigoCajero;
    private String tipo;
    private String Fecha;
    private String Hora;

    private float monto;
    private float saldoCuenta;


    public HistorialTransaccion() {
    }

    public HistorialTransaccion(int codigoTransaccion, int codigoCliente, String nombreCliente, int codigoCuenta, int codigoCajero, String tipo, String fecha, String hora, float monto, float saldoCuenta) {
        CodigoTransaccion = codigoTransaccion;
        this.codigoCliente = codigoCliente;
        NombreCliente = nombreCliente;
        CodigoCuenta = codigoCuenta;
        CodigoCajero = codigoCajero;
        this.tipo = tipo;
        Fecha = fecha;
        Hora = hora;
        this.monto = monto;
        this.saldoCuenta = saldoCuenta;
    }

    public int getCodigoTransaccion() {
        return CodigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        CodigoTransaccion = codigoTransaccion;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        CodigoCuenta = codigoCuenta;
    }

    public int getCodigoCajero() {
        return CodigoCajero;
    }

    public void setCodigoCajero(int codigoCajero) {
        CodigoCajero = codigoCajero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
}
