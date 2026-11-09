public abstract class Producto {
    private int codigoUnico;
    private String nombre;
    private String descripcion;
    private double precioBase;
    private String tiempoPreparacion;

    public Producto(int codigoUnico, String nombre, String descripcion, double precioBase, String tiempoPreparacion) {
        this.codigoUnico = codigoUnico;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precioBase=precioBase;
        this.tiempoPreparacion=tiempoPreparacion;
    }
    public int getCodigoUnico() {

        return codigoUnico;
    }
    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
    public String getTiempoPreparacion() {
        return tiempoPreparacion;
    }
    public void setTiempoPreparacion(String tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
}
