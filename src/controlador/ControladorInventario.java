package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.DirectorioVista;
import java.util.List;

public class ControladorInventario {
    private BaseDeDatos modelo;
    private DirectorioVista vista;
    
    public ControladorInventario(BaseDeDatos modelo, DirectorioVista vista) {
        this.modelo = modelo;
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
                    listarProductos();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 5:
                    actualizarProducto();
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
        Producto nuevoProducto = vista.pedirDatosProducto();
        if (nuevoProducto != null) {
            boolean exito = modelo.agregarProducto(nuevoProducto);
            if (exito) {
                vista.mostrarMensaje("Producto agregado exitosamente");
            } else {
                vista.mostrarMensaje("Error: El SKU ya existe");
            }
        }
    }
    
    private void buscarProducto() {
        String sku = vista.pedirSku();
        Producto producto = modelo.buscarProducto(sku);
        vista.mostrarProducto(producto);
    }
    
    private void listarProductos() {
        List<Producto> productos = modelo.obtenerTodosProductos();
        vista.mostrarProductos(productos);
    }
    
    private void eliminarProducto() {
        String sku = vista.pedirSku();
        boolean exito = modelo.eliminarProducto(sku);
        if (exito) {
            vista.mostrarMensaje("Producto eliminado exitosamente");
        } else {
            vista.mostrarMensaje("Error: Producto no encontrado");
        }
    }
    
    private void actualizarProducto() {
        String sku = vista.pedirSku();
        Producto productoExistente = modelo.buscarProducto(sku);
        
        if (productoExistente == null) {
            vista.mostrarMensaje("Error: Producto no encontrado");
            return;
        }
        
        vista.mostrarProducto(productoExistente);
        vista.mostrarMensaje("Ingrese los nuevos datos:");
        
        Producto productoActualizado = vista.pedirDatosProducto();
        if (productoActualizado != null) {
            boolean exito = modelo.actualizarProducto(productoActualizado);
            if (exito) {
                vista.mostrarMensaje("Producto actualizado exitosamente");
            }
        }
    }
}
