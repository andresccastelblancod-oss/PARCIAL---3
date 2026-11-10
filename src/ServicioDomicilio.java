public class ServicioDomicilio {

    private EmpresaDomicilio empresa;
    private double distanciaKm;
    private double costo;
    private boolean aceptado;

    public ServicioDomicilio(EmpresaDomicilio empresa, double distanciaKm) {
        this.empresa = empresa;
        this.distanciaKm = distanciaKm;
        this.costo = 0;
        this.aceptado = false;
    }

    /**
     * Procedimiento común para solicitar el servicio a cualquier empresa:
     * verifica la distancia y, si la acepta, calcula el costo.
     */
    public boolean solicitarServicio() {
        if (empresa.aceptaDistancia(distanciaKm)) {
            aceptado = true;
            costo = empresa.calcularCosto(distanciaKm);
        } else {
            aceptado = false;
            costo = 0;
        }
        return aceptado;
    }

    public String mostrarInformacion() {
        String estado = aceptado ? "aceptado" : "rechazado";
        return "Domicilio con " + empresa.getNombre() + " | Distancia: " + distanciaKm
                + " km | Costo: $" + String.format("%.0f", costo) + " | Servicio " + estado;
    }

    public EmpresaDomicilio getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDomicilio empresa) {
        this.empresa = empresa;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isAceptado() {
        return aceptado;
    }
}