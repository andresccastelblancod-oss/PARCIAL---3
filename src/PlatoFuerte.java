public class PlatoFuerte extends Producto {

    private static final double INCREMENTO = 0.20;
    public static final String CATEGORIA_PLATO_FUERTE = "Plato Fuerte";

    private double pesoGramos;
    private TipoPreparacion tipoPreparacion;
    private boolean coccionAprobada;

    public PlatoFuerte(int codigoUnico, String nombre, String descripcion,
                       double precioBase, String tiempoPreparacion,
                       double pesoGramos, TipoPreparacion tipoPreparacion,
                       boolean coccionAprobada) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.tipoPreparacion = tipoPreparacion;
        this.coccionAprobada = coccionAprobada;
    }

    public double calcularPrecioVenta() {
        return getPrecioBase() * (1 + INCREMENTO);
    }

    public boolean cumpleCondicionesCalidad() {
        boolean pesoValido = pesoGramos >= 200 && pesoGramos <= 900;

        // Conversión directa y básica usando Integer.parseInt sin try-catch
        int minutos = Integer.parseInt(getTiempoPreparacion());
        boolean tiempoValido = minutos >= 10 && minutos <= 60;

        return pesoValido && tiempoValido && coccionAprobada;
    }

    public String getCategoria() {
        return CATEGORIA_PLATO_FUERTE;
    }

    public String mostrarInformacion() {
        return "Código: " + getCodigoUnico() + " | Nombre: " + getNombre() + " | Descripción: " + getDescripcion()
                + "  Precio Base: $" + getPrecioBase() + "  Tiempo Prep: " + getTiempoPreparacion()
                + "  Peso: " + pesoGramos + " g"
                + "  Preparacion: " + tipoPreparacion
                + "  Coccion aprobada: " + (coccionAprobada ? "si" : "no");
    }

    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public TipoPreparacion getTipoPreparacion() {
        return tipoPreparacion;
    }

    public void setTipoPreparacion(TipoPreparacion tipoPreparacion) {
        this.tipoPreparacion = tipoPreparacion;
    }

    public boolean isCoccionAprobada() {
        return coccionAprobada;
    }

    public void setCoccionAprobada(boolean coccionAprobada) {
        this.coccionAprobada = coccionAprobada;
    }
}