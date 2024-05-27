import java.util.ArrayList;
import java.util.TreeSet;

public class FabricaDeTrajes implements IFabricaDeTrajes {
    private ArrayList<Componente> componentesEnAlmacen;
    private TreeSet<Traje> trajesEnAlmacen;
    private boolean sonRebajas;

    public FabricaDeTrajes() {
        componentesEnAlmacen = new ArrayList<>();
        trajesEnAlmacen = new TreeSet<>();
        sonRebajas = false;
    }

   
    public void escribirMenu() {
        System.out.println("MENU FABRICA TRAJES");
        System.out.println("1.- Añadir Componente a almacén");
        System.out.println("2.- Listar Componentes del almacén");
        System.out.println("3.- Crear traje y añadir a almacén");
        System.out.println("4.- Listar trajes del almacén");
        System.out.println("7.- Activar/Desactivar las rebajas");
        System.out.println("8.- Crear envío");
        System.out.println("9.- Crea componentes de prueba");
        System.out.println("0.- Salir");
    }

  
    public void crearDatosDePrueba() {
        // Crear componentes de prueba
    
Componente componente1 = new Componente("chaqueta", "M", 10.0) {};
Componente componente2 = new Componente("Pantalón", "L", 20.0) {};
Componente componente3 = new Componente("falda", "S", 5.0) {};
        componentesEnAlmacen.add(componente1);
        componentesEnAlmacen.add(componente2);
        componentesEnAlmacen.add(componente3);

        // Crear trajes de prueba
        Traje traje1 = new Traje("Traje 1", componente1, componente2);
        Traje traje2 = new Traje("Traje 2", componente2, componente3);
        trajesEnAlmacen.add(traje1);
        trajesEnAlmacen.add(traje2);
    }


    // Resto de métodos implementados según la interfaz IFabricadeTrajes
    // ...

    @Override
    public void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listarComponentes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void listarTrajes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void activarDesactivarRebajas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void crearEnvío() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

        }
   

 
   
