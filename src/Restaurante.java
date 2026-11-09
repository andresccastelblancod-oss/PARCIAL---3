public class Restaurante {
    private String nombreComercial;
    private String NIT;
    private String direccion;

    public Restaurante(String nombreComercial, String NIT, String direccion) {
        this.nombreComercial = nombreComercial;
        this.NIT=NIT;
        this.direccion=direccion;
    }
    public String getNombreComercial() {
        return nombreComercial;
    }
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public String getNIT() {
        return NIT;
    }
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", NIT=" + NIT +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
