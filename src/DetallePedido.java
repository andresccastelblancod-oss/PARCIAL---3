
public class DetallePedido {

    private Producto producto;
    private int cantidad;
    private double precioVenta;
    private boolean calidadValida;

    public DetallePedido(Producto producto, int cantidad,
                         double precioVenta, boolean calidadValida) {

        this.producto = producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.calidadValida = calidadValida;
    }

    public double calcularSubtotal() {
        return precioVenta * cantidad;
    }

    public boolean cumpleCondicionesCalidad() {
        return calidadValida;
    }

    public String mostrarInformacion() {
        return "Producto: " + producto.getNombre()
                + " | Cantidad: " + cantidad
                + " | Precio unitario: $" + precioVenta
                + " | Subtotal: $" + calcularSubtotal();
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
