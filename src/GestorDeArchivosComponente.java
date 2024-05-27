import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class GestorDeArchivosComponente implements IGestorDeArchivos<Componente> {

    private String rutaArchivo = "src/main/resources/componentes.txt";

    @Override
    public void guardarObjeto(Componente objeto) throws IOException {
        String texto = objeto.getId() + ";" + objeto.getNombre() + ";" + objeto.getPrecio() + "\n";
        Files.write(Paths.get(rutaArchivo), texto.getBytes());
    }

    @Override
    public List<Componente> obtenerTodosLosObjetos() {
        List<Componente> componentes = new ArrayList<>();
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaArchivo));
            for (String linea : lineas) {
                String[] datos = linea.split(";");
                Componente componente = new Componente(datos[0], datos[1], Double.parseDouble(datos[2])) {};
                componentes.add(componente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return componentes;
    }

    @Override
    public Optional<Componente> obtenerObjeto(Predicate<Componente> criterio) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        for (Componente componente : componentes) {
            if (criterio.test(componente)) {
                return Optional.of(componente);
            }
        }
        return Optional.empty();
    }

    @Override
    public void actualizarObjeto(Componente objetoAntiguo, Componente objetoNuevo) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        for (int i = 0; i < componentes.size(); i++) {
            Componente componente = componentes.get(i);
            if (componente.equals(objetoAntiguo)) {
                componentes.set(i, objetoNuevo);
                break;
            }
        }
        guardarComponentes(componentes);
    }

    @Override
    public void eliminarObjeto(Componente objeto) {
        List<Componente> componentes = obtenerTodosLosObjetos();
        for (int i = 0; i < componentes.size(); i++) {
            Componente componente = componentes.get(i);
            if (componente.equals(objeto)) {
                componentes.remove(i);
                break;
            }
        }
        guardarComponentes(componentes);
    }

    private void guardarComponentes(List<Componente> componentes) {
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            for (Componente componente : componentes) {
                String texto = componente.getId() + ";" + componente.getNombre() + ";" + componente.getPrecio() + "\n";
                Files.write(Paths.get(rutaArchivo), texto.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}