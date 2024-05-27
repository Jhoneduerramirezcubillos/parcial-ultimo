import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
public class GestorDeArchivosBlusa implements IGestorDeArchivos<blusa> {

    private String rutaArchivo = "src/main/resources/blusas.txt";

    @Override
    public void guardarObjeto(blusa objeto) throws IOException {
        String texto = objeto.getId() + ";" + objeto.getNombre() + ";" + objeto.getPrecio() + "\n";
        Files.write(Paths.get(rutaArchivo), texto.getBytes());
    }

    @Override
    public List<blusa> obtenerTodosLosObjetos() {
        List<blusa> blusas = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                blusa blusa = new blusa(datos[0], datos[1], Double.parseDouble(datos[2]));
                blusas.add(blusa);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return blusas;
    }

    @Override
    public Optional<blusa> obtenerObjeto(Predicate<blusa> criterio) {
        List<blusa> blusas = obtenerTodosLosObjetos();
        for (blusa blusa : blusas) {
            if (criterio.test(blusa)) {
                return Optional.of(blusa);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarObjeto(blusa objetoAntiguo, blusa objetoNuevo) {
        List<blusa> blusas = obtenerTodosLosObjetos();
        for (int i = 0; i < blusas.size(); i++) {
            blusa blusa = blusas.get(i);
            if (blusa.equals(objetoAntiguo)) {
                blusas.set(i, objetoNuevo);
                break;
            }
        }
        guardarBlusas(blusas);
    }

    @Override
    public void eliminarObjeto(blusa objeto) {
        List<blusa> blusas = obtenerTodosLosObjetos();
        for (int i = 0; i < blusas.size(); i++) {
            blusa blusa = blusas.get(i);
            if (blusa.equals(objeto)) {
                blusas.remove(i);
                break;
            }
        }
        guardarBlusas(blusas);
    }

    private void guardarBlusas(List<blusa> blusas) {
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            for (blusa blusa : blusas) {
                String texto = blusa.getId() + ";" + blusa.getNombre() + ";" + blusa.getPrecio() + "\n";
                Files.write(Paths.get(rutaArchivo), texto.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
