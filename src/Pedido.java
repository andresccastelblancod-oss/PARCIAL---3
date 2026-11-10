
import java.time.LocalDate;

public class Pedido {

    private String codigo;
    private LocalDate fecha;
    private Cliente cliente;
    private ModalidadEntrega modalidad;
    private EstadoPedido estado;
    private DetallePedido[] detalles;
    private int cantidadDetalles;
    private ServicioDomicilio servicioDomicilio;

    public Pedido(String codigo, LocalDate fecha,
                  Cliente cliente, ModalidadEntrega modalidad) {

        this.codigo = codigo;
        this.fecha = fecha;
        this.cliente = cliente;
        this.modalidad = modalidad;
        this.estado = EstadoPedido.PENDIENTE;
        this.detalles = new DetallePedido[100];
        this.cantidadDetalles = 0;
        this.servicioDomicilio = null;
    }

    public void agregarBebida(Bebida producto, int cantidad) {

        if (cantidadDetalles < detalles.length) {

            DetallePedido detalle = new DetallePedido(
                    producto,
                    cantidad,
                    producto.calcularPrecioVenta(),
                    producto.cumpleCondicionesCalidad()
            );

            detalles[cantidadDetalles] = detalle;
            cantidadDetalles++;
        }
    }

    public void agregarPostre(Postre producto, int cantidad) {

        if (cantidadDetalles < detalles.length) {

            DetallePedido detalle = new DetallePedido(
                    producto,
                    cantidad,
                    producto.calcularPrecioVenta(),
                    producto.cumpleCondicionesCalidad()
            );

            detalles[cantidadDetalles] = detalle;
            cantidadDetalles++;
        }
    }

    public void agregarPlatoFuerte(PlatoFuerte producto, int cantidad) {

        if (cantidadDetalles < detalles.length) {

            DetallePedido detalle = new DetallePedido(
                    producto,
                    cantidad,
                    producto.calcularPrecioVenta(),
                    producto.cumpleCondicionesCalidad()
            );

            detalles[cantidadDetalles] = detalle;
            cantidadDetalles++;
        }
    }

    public void asociarServicioDomicilio(ServicioDomicilio servicio) {
        this.servicioDomicilio = servicio;
    }

    public double calcularTotalProductos() {

        double total = 0;

        for (int i = 0; i < cantidadDetalles; i++) {
            total = total + detalles[i].calcularSubtotal();
        }

        return total;
    }

    public double calcularCostoDomicilio() {

        if (modalidad == ModalidadEntrega.DOMICILIO
                && servicioDomicilio != null
                && servicioDomicilio.isAceptado()) {

            return servicioDomicilio.getCosto();
        }

        return 0;
    }

    public double calcularTotal() {
        return calcularTotalProductos() + calcularCostoDomicilio();
    }

    private boolean tienenCantidadesValidas() {

        for (int i = 0; i < cantidadDetalles; i++) {

            if (detalles[i].getCantidad() <= 0) {
                return false;
            }
        }

        return true;
    }

    private boolean todosCumplenCalidad() {

        for (int i = 0; i < cantidadDetalles; i++) {

            if (!detalles[i].cumpleCondicionesCalidad()) {
                return false;
            }
        }

        return true;
    }

    private boolean domicilioAceptado() {

        if (modalidad == ModalidadEntrega.DOMICILIO) {

            return servicioDomicilio != null
                    && servicioDomicilio.isAceptado();
        }

        return true;
    }

    public boolean puedeConfirmarse() {

        return estado == EstadoPedido.PENDIENTE
                && cantidadDetalles > 0
                && tienenCantidadesValidas()
                && todosCumplenCalidad()
                && domicilioAceptado();
    }

    public boolean confirmar() {

        if (!puedeConfirmarse()) {
            return false;
        }

        estado = EstadoPedido.CONFIRMADO;
        return true;
    }

    public boolean entregar() {

        if (estado != EstadoPedido.CONFIRMADO) {
            return false;
        }

        estado = EstadoPedido.ENTREGADO;
        return true;
    }

    public boolean cancelar() {

        if (estado == EstadoPedido.PENDIENTE
                || estado == EstadoPedido.CONFIRMADO) {

            estado = EstadoPedido.CANCELADO;
            return true;
        }

        return false;
    }

    public boolean contabilizaIngreso() {

        return estado == EstadoPedido.CONFIRMADO
                || estado == EstadoPedido.ENTREGADO;
    }

    public String mostrarInformacion() {

        String texto = "Pedido " + codigo
                + " | Fecha: " + fecha
                + " | Cliente: " + cliente.getNombreCompleto()
                + " | Modalidad: " + modalidad
                + " | Estado: " + estado;

        for (int i = 0; i < cantidadDetalles; i++) {

            texto = texto + "\n    - "
                    + detalles[i].mostrarInformacion();
        }

        if (modalidad == ModalidadEntrega.DOMICILIO
                && servicioDomicilio != null) {

            texto = texto + "\n    - "
                    + servicioDomicilio.mostrarInformacion();
        }

        texto = texto + "\n    Total productos: $"
                + calcularTotalProductos()
                + " | Domicilio: $" + calcularCostoDomicilio()
                + " | Total: $" + calcularTotal();

        return texto;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ModalidadEntrega getModalidad() {
        return modalidad;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public DetallePedido[] getDetalles() {
        return detalles;
    }

    public int getCantidadDetalles() {
        return cantidadDetalles;
    }

    public ServicioDomicilio getServicioDomicilio() {
        return servicioDomicilio;
    }
}
