public abstract class Componente implements Comparable<Componente> {
    protected int id;
    protected String nombre;
    protected String talla;
    protected String color;
    protected boolean esComunitario;
    protected double precio;
Componente componente1 = new Componente("chaqueta", "M", 10.0) {};
Componente componente2 = new Componente("Pantalón", "L", 20.0) {};
Componente componente3 = new Componente("falda", "S", 5.0) {};
    public Componente(String nombre, String talla, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.esComunitario = esComunitario;
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", talla='" + talla + '\'' +
                ", color='" + color + '\'' +
                ", esComunitario=" + esComunitario +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Componente)) return false;
        Componente that = (Componente) obj;
        return id == that.id;
    }

    @Override
    public int compareTo(Componente other) {
        return Integer.compare(this.id, other.id);
    }

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean isExtracomunitario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setPrecio(Componente componente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
