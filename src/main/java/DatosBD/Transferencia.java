package DatosBD;

public class Transferencia {
    private int CuentaDebito;
    private int CuentaCredito;
    private int Codigotransaccion;
    private  TipoTransferencia Tipo;
    private String fecha;
    private String hora;
    private float monto;
    private int codigoCajero;
    private float saldoCuenta;


    public Transferencia() {
    }

    public Transferencia(int cuentaDebito, int cuentaCredito, int codigotransaccion, TipoTransferencia tipo, String fecha, String hora, float monto, int codigoCajero, float saldoCuenta) {
        CuentaDebito = cuentaDebito;
        CuentaCredito = cuentaCredito;
        Codigotransaccion = codigotransaccion;
        Tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.monto = monto;
        this.codigoCajero = codigoCajero;
        this.saldoCuenta = saldoCuenta;
    }

    public int getCuentaDebito() {
        return CuentaDebito;
    }

    public void setCuentaDebito(int cuentaDebito) {
        CuentaDebito = cuentaDebito;
    }

    public int getCuentaCredito() {
        return CuentaCredito;
    }

    public void setCuentaCredito(int cuentaCredito) {
        CuentaCredito = cuentaCredito;
    }

    public int getCodigotransaccion() {
        return Codigotransaccion;
    }

    public void setCodigotransaccion(int codigotransaccion) {
        Codigotransaccion = codigotransaccion;
    }

    public TipoTransferencia getTipo() {
        return Tipo;
    }

    public void setTipo(TipoTransferencia tipo) {
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
