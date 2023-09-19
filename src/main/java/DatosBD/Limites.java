package DatosBD;

public class Limites {
    private int Codigo;
    private String Nombre;
    private float valor;

    public Limites() {
    }

    public Limites(int codigo, String nombre, float valor) {
        Codigo = codigo;
        Nombre = nombre;
        this.valor = valor;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int codigo) {
        Codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }


}
