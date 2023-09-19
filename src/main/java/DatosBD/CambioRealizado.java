package DatosBD;

public class CambioRealizado {

    private int Codigo;
    private int CodigoGerente;
    private int CodigoUsuarioModificafo;
    private String NombreUsuarioModificado;
    private String fecha;
    private String hora;

    public CambioRealizado() {
    }

    public CambioRealizado(int codigo, int codigoGerente, int codigoUsuarioModificafo, String nombreUsuarioModificado, String fecha, String hora) {
        Codigo = codigo;
        CodigoGerente = codigoGerente;
        CodigoUsuarioModificafo = codigoUsuarioModificafo;
        NombreUsuarioModificado = nombreUsuarioModificado;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public int getCodigoGerente() {
        return CodigoGerente;
    }

    public void setCodigoGerente(int codigoGerente) {
        CodigoGerente = codigoGerente;
    }

    public int getCodigoUsuarioModificafo() {
        return CodigoUsuarioModificafo;
    }

    public void setCodigoUsuarioModificafo(int codigoUsuarioModificafo) {
        CodigoUsuarioModificafo = codigoUsuarioModificafo;
    }

    public String getNombreUsuarioModificado() {
        return NombreUsuarioModificado;
    }

    public void setNombreUsuarioModificado(String nombreUsuarioModificado) {
        NombreUsuarioModificado = nombreUsuarioModificado;
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
}
