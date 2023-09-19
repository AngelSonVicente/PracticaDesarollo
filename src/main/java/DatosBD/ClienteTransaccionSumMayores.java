package DatosBD;

public class ClienteTransaccionSumMayores {

    private  int CodigoCliente;
    private String NombreCliente;
    private float Monto;

    public ClienteTransaccionSumMayores() {
    }

    public ClienteTransaccionSumMayores(int codigoCliente, String nombreCliente, float monto) {
        CodigoCliente = codigoCliente;
        NombreCliente = nombreCliente;
        Monto = monto;
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

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float monto) {
        Monto = monto;
    }
}
