package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDeDatos {
    private Map<String, Producto> productos;

    public BaseDeDatos() {
        this.productos = new HashMap<>();
        // Datos de ejemplo con cantidad
        agregarProducto(new Producto("001", "Laptop", 10, 999.99));
        agregarProducto(new Producto("002", "Mouse", 25, 25.50));
    }

    public boolean agregarProducto(Producto producto) {
        if (productos.containsKey(producto.getSku().toLowerCase())) {
            return false;
        }
        productos.put(producto.getSku().toLowerCase(), producto);
        return true;
    }

    public Producto buscarProductoSku(String sku) {
        return productos.get(sku.toLowerCase());
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos.values());
    }

    public boolean eliminarProducto(String sku) {
        return productos.remove(sku.toLowerCase()) != null;
    }

    public boolean actualizarProducto(Producto producto) {
        if (!productos.containsKey(producto.getSku().toLowerCase())) {
            return false;
        }
        productos.put(producto.getSku().toLowerCase(), producto);
        return true;
    }
}