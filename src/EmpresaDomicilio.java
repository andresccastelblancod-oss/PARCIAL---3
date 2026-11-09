public interface EmpresaDomicilio {

    String getNombre();

    /** Indica si la empresa acepta recorrer la distancia indicada. */
    boolean aceptaDistancia(double distanciaKm);

    /** Calcula lo que cobra la empresa por el recorrido. */
    double calcularCosto(double distanciaKm);
}