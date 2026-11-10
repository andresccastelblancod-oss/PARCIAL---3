public class Postre extends Producto {

    private static final double INCREMENTO = 0.15;
    private static final double INCREMENTO_REFRIGERADO = 0.05;
    public static final String CATEGORIA_POSTRE = "Postre";

    private double pesoGramos;
    private double temperaturaAlmacenamiento; // en °C
    private boolean requiereRefrigeracion;

    public Postre(int codigoUnico, String nombre, String descripcion,
                  double precioBase, String tiempoPreparacion,
                  double pesoGramos, double temperaturaAlmacenamiento,
                  boolean requiereRefrigeracion) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.pesoGramos = pesoGramos;
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
        this.requiereRefrigeracion = requiereRefrigeracion;
    }

    public double calcularPrecioVenta() {
        double precio = getPrecioBase() * (1 + INCREMENTO);
        if (requiereRefrigeracion) {
            precio = precio + getPrecioBase() * INCREMENTO_REFRIGERADO;
        }
        return precio;
    }


    public boolean cumpleCondicionesCalidad() {
        boolean pesoValido = pesoGramos >= 80 && pesoGramos <= 500;
        boolean temperaturaValida;
        if (requiereRefrigeracion) {
            temperaturaValida = temperaturaAlmacenamiento >= 0 && temperaturaAlmacenamiento <= 6;
        } else {
            temperaturaValida = temperaturaAlmacenamiento >= 15 && temperaturaAlmacenamiento <= 30;
        }
        return pesoValido && temperaturaValida;
    }

    public String getCategoria() {
        return CATEGORIA_POSTRE;
    }

    public String mostrarInformacion() {
        return "Código: " + getCodigoUnico() + " | Nombre: " + getNombre() + " | Descripción: " + getDescripcion()
                + "  Precio Base: $" + getPrecioBase() + " | Tiempo Prep: " + getTiempoPreparacion()
                + "  Peso: " + pesoGramos + " g"
                + "  Temperatura de almacenamiento: " + temperaturaAlmacenamiento + " C"
                + "  Requiere refrigeracion: " + (requiereRefrigeracion ? "si" : "no");
    }

    public double getPesoGramos() {
        return pesoGramos;
    }

    public void setPesoGramos(double pesoGramos) {
        this.pesoGramos = pesoGramos;
    }

    public double getTemperaturaAlmacenamiento() {
        return temperaturaAlmacenamiento;
    }

    public void setTemperaturaAlmacenamiento(double temperaturaAlmacenamiento) {
        this.temperaturaAlmacenamiento = temperaturaAlmacenamiento;
    }

    public boolean isRequiereRefrigeracion() {
        return requiereRefrigeracion;
    }

    public void setRequiereRefrigeracion(boolean requiereRefrigeracion) {
        this.requiereRefrigeracion = requiereRefrigeracion;
    }
}