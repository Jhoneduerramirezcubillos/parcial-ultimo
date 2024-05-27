public class Falda extends Componente {
   private boolean conCremallera;

    public Falda(String nombre, String talla, double precio) {
        super(nombre, talla, precio);
        this.conCremallera = conCremallera;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEsComunitario() {
        return esComunitario;
    }

    public void setEsComunitario(boolean esComunitario) {
        this.esComunitario = esComunitario;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Falda{" + "conCremallera=" + conCremallera + '}';
    }
}