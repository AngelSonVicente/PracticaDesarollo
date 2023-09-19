package DatosBD;

public class DeporsitoRetirosCajero {

    private int CodigoCajero;
    private String NombreCajero;
    private int CodigoCuenta;
    private int CodigoTransaccion;
    private String tipo;
    private String Fecha;
    private String Hora;
    private float monto;
    private float SaldoCuenta;
    private float Caja;

    public DeporsitoRetirosCajero() {
    }

    public DeporsitoRetirosCajero(int codigoCajero, String nombreCajero, int codigoCuenta, int codigoTransaccion, String tipo, String fecha, String hora, float monto, float saldoCuenta, float caja) {
        CodigoCajero = codigoCajero;
        NombreCajero = nombreCajero;
        CodigoCuenta = codigoCuenta;
        CodigoTransaccion = codigoTransaccion;
        this.tipo = tipo;
        Fecha = fecha;
        Hora = hora;
        this.monto = monto;
        SaldoCuenta = saldoCuenta;
        Caja = caja;
    }

    public int getCodigoCajero() {
        return CodigoCajero;
    }

    public void setCodigoCajero(int codigoCajero) {
        CodigoCajero = codigoCajero;
    }

    public String getNombreCajero() {
        return NombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        NombreCajero = nombreCajero;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        CodigoCuenta = codigoCuenta;
    }

    public int getCodigoTransaccion() {
        return CodigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        CodigoTransaccion = codigoTransaccion;
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
        return SaldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        SaldoCuenta = saldoCuenta;
    }

    public float getCaja() {
        return Caja;
    }

    public void setCaja(float caja) {
        Caja = caja;
    }
}
