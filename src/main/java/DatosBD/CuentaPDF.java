package DatosBD;

public class CuentaPDF {
    private int CodigoCuenta;
    private int CodigoUsuario;
    private String NombreCliente;
    private String Direccion;
    private String DPI;
    private String sexo;
    private String FechaCumple;
    private float saldo;
    private byte[] pdfdpi;

    public CuentaPDF() {
    }

    public CuentaPDF(int codigoCuenta, int codigoUsuario, String nombreCliente, String direccion, String DPI, String sexo, String fechaCumple, float saldo, byte[] pdfdpi) {
        CodigoCuenta = codigoCuenta;
        CodigoUsuario = codigoUsuario;
        NombreCliente = nombreCliente;
        Direccion = direccion;
        this.DPI = DPI;
        this.sexo = sexo;
        FechaCumple = fechaCumple;
        this.saldo = saldo;
        this.pdfdpi = pdfdpi;
    }

    public int getCodigoCuenta() {
        return CodigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        CodigoCuenta = codigoCuenta;
    }

    public int getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        CodigoUsuario = codigoUsuario;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        NombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getDPI() {
        return DPI;
    }

    public void setDPI(String DPI) {
        this.DPI = DPI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaCumple() {
        return FechaCumple;
    }

    public void setFechaCumple(String fechaCumple) {
        FechaCumple = fechaCumple;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public byte[] getPdfdpi() {
        return pdfdpi;
    }

    public void setPdfdpi(byte[] pdfdpi) {
        this.pdfdpi = pdfdpi;
    }
}
