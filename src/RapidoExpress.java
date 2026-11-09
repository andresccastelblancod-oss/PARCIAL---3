public class RapidoExpress implements EmpresaDomicilio {

    private static final double TARIFA_BASE = 5000;
    private static final double TARIFA_POR_KM = 1500;
    private static final double DISTANCIA_MAXIMA = 12;

    @Override
    public String getNombre() {
        return "RapidoExpress";
    }

    @Override
    public boolean aceptaDistancia(double distanciaKm) {
        return distanciaKm > 0 && distanciaKm <= DISTANCIA_MAXIMA;
    }

    @Override
    public double calcularCosto(double distanciaKm) {
        return TARIFA_BASE + TARIFA_POR_KM * distanciaKm;
    }
}
