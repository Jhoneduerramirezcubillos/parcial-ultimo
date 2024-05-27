
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GestorDeArchivosChaqueta implements IGestorDeArchivos<Chaqueta> {

    private String rutaArchivo = "src/main/resources/chaquetas.txt";

    @Override
    public void guardarObjeto(Chaqueta objeto) throws IOException {
        String texto = objeto.getId() + ";" + objeto.getNombre() + ";" + objeto.getPrecio() + "\n";
        Files.write(Paths.get(rutaArchivo), texto.getBytes());
    }

    @Override
    public List<Chaqueta> obtenerTodosLosObjetos() {
        List<Chaqueta> chaquetas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                Chaqueta chaqueta = new Chaqueta(datos[0], datos[1], Double.parseDouble(datos[2]));
                chaquetas.add(chaqueta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chaquetas;
    }

    @Override
    public Optional<Chaqueta> obtenerObjeto(Predicate<Chaqueta> criterio) {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        for (Chaqueta chaqueta : chaquetas) {
            if (criterio.test(chaqueta)) {
                return Optional.of(chaqueta);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarObjeto(Chaqueta objetoAntiguo, Chaqueta objetoNuevo) {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        for (int i = 0; i < chaquetas.size(); i++) {
            Chaqueta chaqueta = chaquetas.get(i);
            if (chaqueta.equals(objetoAntiguo)) {
                chaquetas.set(i, objetoNuevo);
                break;
            }
        }
        guardarChaquetas(chaquetas);
    }

    @Override
    public void eliminarObjeto(Chaqueta objeto) {
        List<Chaqueta> chaquetas = obtenerTodosLosObjetos();
        for (int i = 0; i < chaquetas.size(); i++) {
            Chaqueta chaqueta = chaquetas.get(i);
            if (chaqueta.equals(objeto)) {
                chaquetas.remove(i);
                break;
            }
        }
        guardarChaquetas(chaquetas);
    }

    private void guardarChaquetas(List<Chaqueta> chaquetas) {
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            for (Chaqueta chaqueta : chaquetas) {
                String texto = chaqueta.getId() + ";" + chaqueta.getNombre() + ";" + chaqueta.getPrecio() + "\n";
                Files.write(Paths.get(rutaArchivo), texto.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}