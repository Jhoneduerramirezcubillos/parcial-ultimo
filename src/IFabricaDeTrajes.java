public interface IFabricaDeTrajes {
    void añadirComponenteAAlmacen() throws IdException, MuchoExtracomunitarioException, MangaException;
    void listarComponentes();
    void añadirTrajeAAlmacen() throws ColoresException, TallaException, TrajeYaExisteException;
    void listarTrajes();
    void activarDesactivarRebajas();
    void crearEnvío();

    public static class IdException extends Exception {

        public IdException() {
        }
    }

    public static class MangaException extends Exception {

        public MangaException() {
        }
    }

    public static class MuchoExtracomunitarioException extends Exception {

        public MuchoExtracomunitarioException() {
        }
    }

    public static class TallaException extends Exception {

        public TallaException() {
        }
    }

    public static class ColoresException extends Exception {

        public ColoresException() {
        }
    }

    public static class TrajeYaExisteException extends Exception {

        public TrajeYaExisteException() {
        }
    }
}