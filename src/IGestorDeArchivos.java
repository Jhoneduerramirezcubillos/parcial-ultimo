import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
public interface IGestorDeArchivos<T> {
void guardarObjeto(T objeto) throws IOException;
List<T> obtenerTodosLosObjetos();
Optional<T> obtenerObjeto(Predicate<T> criterio);
void actualizarObjeto(T objetoAntiguo, T objetoNuevo);
void eliminarObjeto(T objeto);
}