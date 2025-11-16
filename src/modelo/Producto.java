package modelo;

public class Producto {
    private String sku;
    private String nombre;
    private int cantidad;
    private double precio;
    
    public Producto(String sku, String nombre, int cantidad, double precio) {
        this.sku = sku;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    // Getters y Setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    @Override
    public String toString() {
        return "SKU: " + sku + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: $" + precio;
    }
}