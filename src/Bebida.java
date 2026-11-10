public class Bebida extends Producto {

    private static final double INCREMENTO = 0.10;
    private static final double RECARGO_PREPARACION_ESPECIAL = 3000;
    public static final String CATEGORIA_BEBIDA = "Bebida";

    private double volumenMl;
    private double temperaturaServicio; // en °C
    private TipoBebida tipoBebida;
    private boolean preparacionEspecial;

    public Bebida(int codigoUnico, String nombre, String descripcion,
                  double precioBase, String tiempoPreparacion,
                  double volumenMl, double temperaturaServicio,
                  TipoBebida tipoBebida, boolean preparacionEspecial) {
        super(codigoUnico, nombre, descripcion, precioBase, tiempoPreparacion);
        this.volumenMl = volumenMl;
        this.temperaturaServicio = temperaturaServicio;
        this.tipoBebida = tipoBebida;
        this.preparacionEspecial = preparacionEspecial;
    }

    public double calcularPrecioVenta() {
        double precio = getPrecioBase() * (1 + INCREMENTO);
        if (preparacionEspecial) {
            precio = precio + RECARGO_PREPARACION_ESPECIAL;
        }
        return precio;
    }


    public boolean cumpleCondicionesCalidad() {
        boolean volumenValido = volumenMl >= 150 && volumenMl <= 1500;
        boolean temperaturaValida;
        if (tipoBebida == TipoBebida.FRIA) {
            temperaturaValida = temperaturaServicio >= 0 && temperaturaServicio <= 10;
        } else {
            temperaturaValida = temperaturaServicio >= 55 && temperaturaServicio <= 85;
        }
        return volumenValido && temperaturaValida;
    }

    public String getCategoria() {
        return CATEGORIA_BEBIDA;
    }

    public String mostrarInformacion() {
        return "Código: " + getCodigoUnico() + " | Nombre: " + getNombre() + " | Descripción: " + getDescripcion()
                + "  Precio Base: $" + getPrecioBase() + "  Tiempo Prep: " + getTiempoPreparacion()
                + "  Volumen: " + volumenMl + " ml"
                + "  Temperatura: " + temperaturaServicio + " C"
                + "  Tipo: " + tipoBebida
                + "  Preparacion especial: " + (preparacionEspecial ? "si" : "no");
    }

    public double getVolumenMl() {
        return volumenMl;
    }

    public void setVolumenMl(double volumenMl) {
        this.volumenMl = volumenMl;
    }

    public double getTemperaturaServicio() {
        return temperaturaServicio;
    }

    public void setTemperaturaServicio(double temperaturaServicio) {
        this.temperaturaServicio = temperaturaServicio;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(TipoBebida tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public boolean isPreparacionEspecial() {
        return preparacionEspecial;
    }

    public void setPreparacionEspecial(boolean preparacionEspecial) {
        this.preparacionEspecial = preparacionEspecial;
    }
}