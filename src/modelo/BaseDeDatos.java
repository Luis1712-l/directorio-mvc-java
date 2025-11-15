package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDeDatos {
    private Map<String, Producto> productos;
    
    public BaseDeDatos() {
        this.productos = new HashMap<>();
        // Datos de ejemplo
        agregarProducto(new Producto("001", "Laptop", 999.99));
        agregarProducto(new Producto("002", "Mouse", 25.50));
    }
    
    public boolean agregarProducto(Producto producto) {
        if (productos.containsKey(producto.getSku())) {
            return false; // SKU ya existe
        }
        productos.put(producto.getSku(), producto);
        return true;
    }
    
    public Producto buscarProducto(String sku) {
        return productos.get(sku);
    }
    
    public List<Producto> obtenerTodosProductos() {
        return new ArrayList<>(productos.values());
    }
    
    public boolean eliminarProducto(String sku) {
        return productos.remove(sku) != null;
    }
    
    public boolean actualizarProducto(Producto producto) {
        if (!productos.containsKey(producto.getSku())) {
            return false; // Producto no existe
        }
        productos.put(producto.getSku(), producto);
        return true;
    }
}