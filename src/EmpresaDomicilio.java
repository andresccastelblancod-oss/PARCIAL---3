public interface EmpresaDomicilio {

    String getNombre();

  
    boolean aceptaDistancia(double distanciaKm);

   
    double calcularCosto(double distanciaKm);
}
