public class EntregaSegura implements EmpresaDomicilio {

    private static final double TARIFA_BASE = 7000;
    private static final double TARIFA_POR_KM = 1000;
    private static final double RECARGO_POR_DISTANCIA = 3000;
    private static final double DISTANCIA_PARA_RECARGO = 5;
    private static final double DISTANCIA_MAXIMA = 20;

    @Override
    public String getNombre() {
        return "EntregaSegura";
    }

    @Override
    public boolean aceptaDistancia(double distanciaKm) {
        return distanciaKm > 0 && distanciaKm <= DISTANCIA_MAXIMA;
    }

    @Override
    public double calcularCosto(double distanciaKm) {
        double costo = TARIFA_BASE + TARIFA_POR_KM * distanciaKm;
        if (distanciaKm > DISTANCIA_PARA_RECARGO) {
            costo = costo + RECARGO_POR_DISTANCIA;
        }
        return costo;
    }
}