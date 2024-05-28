import java.util.ArrayList;

public class Traje {
    private ArrayList<Componente> piezas;
    private String nombre;

    public Traje(String nombre, Componente componente1, Componente componente2) {
        this.piezas = piezas;
        this.nombre = nombre;
    }

    Traje(blusa blusa, Chaqueta chaqueta, IFabricaDeTrajes.PantalonFalda pantalonFalda) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Componente> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Componente> piezas) {
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Traje{" + "piezas=" + piezas + ", nombre=" + nombre + '}';
    }
}