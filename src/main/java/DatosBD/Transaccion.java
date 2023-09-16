package DatosBD;

public class Transaccion {

    private  int codigoTransaccion;
    private  int codigoCuenta;
    private  String Tipo;
    private String fecha;
    private String hora;
    private float monto;
    private int codigoCajero;
    private float saldoCuenta;

    public Transaccion() {
    }

    public Transaccion(int codigoTransaccion, int codigoCuenta, String tipo, String fecha, String hora, float monto, int codigoCajero, float saldoCuenta) {
        this.codigoTransaccion = codigoTransaccion;
        this.codigoCuenta = codigoCuenta;
        Tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.codigoCajero = codigoCajero;
        this.saldoCuenta = saldoCuenta;
    }

    public int getCodigoTransaccion() {
        return codigoTransaccion;
    }

    public void setCodigoTransaccion(int codigoTransaccion) {
        this.codigoTransaccion = codigoTransaccion;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public int getCodigoCajero() {
        return codigoCajero;
    }

    public void setCodigoCajero(int codigoCajero) {
        this.codigoCajero = codigoCajero;
    }

    public float getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }
}
