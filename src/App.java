import modelo.BaseDeDatos;
import vista.DirectorioVista;
import controlador.ControladorInventario;

public class App {
    public static void main(String[] args) {
        // Crear instancias del Modelo, Vista y Controlador
        BaseDeDatos modelo = new BaseDeDatos();
        DirectorioVista vista = new DirectorioVista();
        ControladorInventario controlador = new ControladorInventario(modelo, vista);
        
        // Iniciar la aplicación
        controlador.iniciar();
    }
}
