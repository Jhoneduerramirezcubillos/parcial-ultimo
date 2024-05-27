import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GestorDeArchivosPantalon implements IGestorDeArchivos<Pantalon> {

    private String rutaArchivo = "src/main/resources/pantalones.txt";

    @Override
    public void guardarObjeto(Pantalon objeto) throws IOException {
        String texto = objeto.getId() + ";" + objeto.getNombre() + ";" + objeto.getPrecio() + "\n";
        Files.write(Paths.get(rutaArchivo), texto.getBytes());
    }

    @Override
    public List<Pantalon> obtenerTodosLosObjetos() {
        List<Pantalon> pantalones = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                Pantalon pantalon = new Pantalon(datos[0], datos[1], Double.parseDouble(datos[2]));
                pantalones.add(pantalon);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pantalones;
    }

    @Override
    public Optional<Pantalon> obtenerObjeto(Predicate<Pantalon> criterio) {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        for (Pantalon pantalon : pantalones) {
            if (criterio.test(pantalon)) {
                return Optional.of(pantalon);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarObjeto(Pantalon objetoAntiguo, Pantalon objetoNuevo) {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        for (int i = 0; i < pantalones.size(); i++) {
            Pantalon pantalon = pantalones.get(i);
            if (pantalon.equals(objetoAntiguo)) {
                pantalones.set(i, objetoNuevo);
                break;
            }
        }
        guardarPantalones(pantalones);
    }

    @Override
    public void eliminarObjeto(Pantalon objeto) {
        List<Pantalon> pantalones = obtenerTodosLosObjetos();
        for (int i = 0; i < pantalones.size(); i++) {
            Pantalon pantalon = pantalones.get(i);
            if (pantalon.equals(objeto)) {
                pantalones.remove(i);
                break;
            }
        }
        guardarPantalones(pantalones);
    }

    private void guardarPantalones(List<Pantalon> pantalones) {
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            for (Pantalon pantalon : pantalones) {
                String texto = pantalon.getId() + ";" + pantalon.getNombre() + ";" + pantalon.getPrecio() + "\n";
                Files.write(Paths.get(rutaArchivo), texto.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}