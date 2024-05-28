
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException, MuchoExtracomunitarioException, MuchoExtracomunitarioException, IdException;
    {
    }
    {
    }
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvío();

    @Override
    public String toString();

    @Override
    public boolean equals(Object obj);

    @Override
    public int hashCode();
   
   
 

    public void añadirComponenteAAlmacen() {
        // Pide al usuario qué tipo de componente desea añadir
        String tipoComponente = leerTipoComponente();
    
        // Pide los datos necesarios para construir el componente
        Componente componente = construirComponente(tipoComponente);

        // Valida que el id del componente no exista anteriormente
        if (componentesEnAlmacen.stream().anyMatch(c -> c.getId().equals(componente.getId()))) {
            try {
                throw new IdException("El id del componente ya existe");
            } catch (IdException ex) {
                Logger.getLogger(IFabricaDeTrajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

        // Valida que no se pueda añadir un componente extracomunitario si ya hay más del 50% de componentes extracomunitarios

        if (componente.isExtracomunitario() && componentesEnAlmacen.stream().filter(Componente::isExtracomunitario).count() > componentesEnAlmacen.size() / 2) {
            try {
                throw new MuchoExtracomunitarioException("No se puede añadir un componente extracomunitario");
            } catch (MuchoExtracomunitarioException ex) {
                Logger.getLogger(IFabricaDeTrajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Valida que no se pueda añadir una blusa de manga larga al almacén si no existe una blusa de manga corta del mismo color
        if ((componentesEnAlmacen.stream().anyMatch(c -> c instanceof blusa && ((blusa) c).isMangaCorta() && ((blusa) c).getColor().equals(componente.getColor())) || !((blusa) componente).isMangaLarga()) || !(componente instanceof blusa)) {
        } else {
            try {
                throw new MangaException("No se puede añadir una blusa de manga larga");
            } catch (MangaException ex) {
                Logger.getLogger(IFabricaDeTrajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Ajusta el precio del componente
        componente.setPrecio(ajustarPrecio(componente));

        // Añade el componente al almacén
        componentesEnAlmacen.add(componente);
    }

     private void listarComponentes() {
        Iterable<Componente> componentesEnAlmacen = null;
        for (Componente componente : componentesEnAlmacen) {
            System.out.println(componente.toString());
        }
    }

    private void añadirTrajeAAlmacen() {
        // Lista las blusas existentes y pide al usuario que elija una
        blusa blusa = elegirblusa();

        // Lista las chaquetas existentes y pide al usuario que elija una
        Chaqueta chaqueta = elegirChaqueta();

        // Lista las faldas y pantalones existentes y pide al usuario que elija una
        PantalonFalda pantalonFalda = elegirPantalonFalda();

        // Verifica que el traje cumpla las reglas
        if (!cumpleReglasTraje(blusa, chaqueta, pantalonFalda)) {
            try {
                throw new ColoresException("El traje no cumple las reglas de color");
            } catch (ColoresException ex) {
                Logger.getLogger(IFabricaDeTrajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Crea el traje
        Traje traje = new Traje(blusa, chaqueta, pantalonFalda);

        // Verifica que el nombre del traje no exista ya en el almacén
        if (trajesEnAlmacen.stream().anyMatch(t -> t.getNombre().equals(traje.getNombre()))) {
            try {
                throw new TrajeYaExisteException("El nombre del traje ya existe");
            } catch (TrajeYaExisteException ex) {
                Logger.getLogger(IFabricaDeTrajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Añade el traje al almacén
        trajesEnAlmacen.add(traje);

        // Elimina los componentes del almacén
        componentesEnAlmacen.remove(blusa);
        componentesEnAlmacen.remove(chaqueta);
        componentesEnAlmacen.remove(pantalonFalda);
    }

    @Override
    public void listarTrajes() {
        for (Traje traje : trajesEnAlmacen) {
            System.out.println(traje.toString());
        }
    }

    @Override
    public void activadDesactivarRebajas() {
        rebajasActivadas = !rebajasActivadas;
        if (rebajasActivadas) {
            System.out.println("Rebajas activadas");
        } else {
            System.out.println("Rebajas desactivadas");
        }
    }

    @Override
    public void crearEnvío() {
        // Lista los trajes existentes y pide al usuario que elija uno
        Traje

    public String leerTipoComponente();

    public Componente construirComponente(String tipoComponente);

    public Componente ajustarPrecio(Componente componente);

    public blusa elegirblusa();

    public Chaqueta elegirChaqueta();

    public PantalonFalda elegirPantalonFalda();

    public boolean cumpleReglasTraje(blusa blusa, Chaqueta chaqueta, PantalonFalda pantalonFalda);

    public static class IdException extends Exception {

        public IdException(String el_id_del_componente_ya_existe) {
        }
    }

    public static class MangaException extends Exception {

        public MangaException(String no_se_puede_añadir_una_blusa_de_manga_lar) {
        }
    }

    public static class MuchoExtracomunitarioException extends Exception {

        public MuchoExtracomunitarioException(String no_se_puede_añadir_un_componente_extracom) {
        }
    }

    public static class TallaException extends Exception {

        public TallaException() {
        }
    }

    public static class ColoresException extends Exception {

        public ColoresException() {
        }

        private ColoresException(String el_traje_no_cumple_las_reglas_de_color) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    public static class TrajeYaExisteException extends Exception {

        public TrajeYaExisteException(String el_nombre_del_traje_ya_existe) {
        }
    }

    public static class componentesEnAlmacen {

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static int size() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void add(Componente componente) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void remove(Chaqueta blusa) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public componentesEnAlmacen() {
        }
    }

    public static class PantalonFalda {

        public PantalonFalda() {
        }
    }

    public static class trajesEnAlmacen {

        private static Object stream() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void add(Traje traje) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public trajesEnAlmacen() {
        }
    }
}