package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class DirectorioVista {
    private Scanner scanner;
    
    public DirectorioVista() {
        this.scanner = new Scanner(System.in);
    }
    
    public int mostrarMenu() {
        System.out.println("\n=== INVENTARIO DE PRODUCTOS ===");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public Producto pedirDatosUsuario() {
        System.out.print("Ingrese SKU: ");
        String sku = scanner.nextLine();
        
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese precio unitario: ");
        try {
            double precio = Double.parseDouble(scanner.nextLine());
            return new Producto(sku, nombre, cantidad, precio);
        } catch (NumberFormatException e) {
            System.out.println("Error: Precio debe ser un número válido");
            return null;
        }
    }
    
    public String pedirSku() {
        System.out.print("Ingrese SKU del producto: ");
        return scanner.nextLine();
    }
    
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("\n=== PRODUCTO ENCONTRADO ===");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
        System.out.println("Total: " + productos.size() + " productos");
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}