
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
public class GestorDeArchivosFalda implements IGestorDeArchivos<Falda> {

    private String rutaArchivo = "src/main/resources/faldas.txt";

    @Override
    public void guardarObjeto(Falda objeto) throws IOException {
        String texto = objeto.getId() + ";" + objeto.getNombre() + ";" + objeto.getPrecio() + "\n";
        Files.write(Paths.get(rutaArchivo), texto.getBytes());
    }

    @Override
    public List<Falda> obtenerTodosLosObjetos() {
        List<Falda> faldas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                Falda falda = new Falda(datos[0], datos[1], Double.parseDouble(datos[2]));
                faldas.add(falda);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return faldas;
    }

    @Override
    public Optional<Falda> obtenerObjeto(Predicate<Falda> criterio) {
        List<Falda> faldas = obtenerTodosLosObjetos();
        for (Falda falda : faldas) {
            if (criterio.test(falda)) {
                return Optional.of(falda);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarObjeto(Falda objetoAntiguo, Falda objetoNuevo) {
        List<Falda> faldas = obtenerTodosLosObjetos();
        for (int i = 0; i < faldas.size(); i++) {
            Falda falda = faldas.get(i);
            if (falda.equals(objetoAntiguo)) {
                faldas.set(i, objetoNuevo);
                break;
            }
        }
        guardarFaldas(faldas);
    }

    @Override
    public void eliminarObjeto(Falda objeto) {
        List<Falda> faldas = obtenerTodosLosObjetos();
        for (int i = 0; i < faldas.size(); i++) {
            Falda falda = faldas.get(i);
            if (falda.equals(objeto)) {
                faldas.remove(i);
                break;
            }
        }
        guardarFaldas(faldas);
    }

    private void guardarFaldas(List<Falda> faldas) {
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            for (Falda falda : faldas) {
                String texto = falda.getId() + ";" + falda.getNombre() + ";" + falda.getPrecio() + "\n";
                Files.write(Paths.get(rutaArchivo), texto.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}