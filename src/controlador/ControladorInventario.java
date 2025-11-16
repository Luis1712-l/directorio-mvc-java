package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.DirectorioVista;
import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos; 
    private DirectorioVista vista;
    
    public ControladorInventario(BaseDeDatos baseDatos, DirectorioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }
    
    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    buscarProducto();
                    break;
                case 3:
                    mostrarTodosProductos();  
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 0:
                    vista.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);
    }
    
    private void agregarProducto() {
       
        Producto nuevoProducto = vista.pedirDatosUsuario();
        if (nuevoProducto != null) {
            boolean exito = baseDatos.agregarProducto(nuevoProducto);
            if (exito) {
                vista.mostrarMensaje("Producto agregado correctamente.");
            } else {
                vista.mostrarMensaje("Error: El SKU ya existe.");
            }
        }
    }
    
    private void buscarProducto() {
        String sku = vista.pedirSku();
       
        Producto producto = baseDatos.buscarProductoSku(sku);
        vista.mostrarProducto(producto);
    }
    
    private void mostrarTodosProductos() {
        
        List<Producto> productos = baseDatos.buscarTodos();
        vista.mostrarProductos(productos);
    }
    
    private void eliminarProducto() {
        String sku = vista.pedirSku();
        boolean exito = baseDatos.eliminarProducto(sku);
        if (exito) {
            vista.mostrarMensaje("Producto eliminado correctamente.");
        } else {
            vista.mostrarMensaje("Error: Producto no encontrado.");
        }
    }
}