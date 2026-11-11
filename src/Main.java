import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    static PlatoFuerte[] platos = new PlatoFuerte[100];
    static int cantidadPlatos = 0;

    static Bebida[] bebidas = new Bebida[100];
    static int cantidadBebidas = 0;

    static Postre[] postres = new Postre[100];
    static int cantidadPostres = 0;

    static Cliente[] clientes = new Cliente[100];
    static int cantidadClientes = 0;

    static Pedido[] pedidos = new Pedido[100];
    static int cantidadPedidos = 0;

    public static void main(String[] args) {

        cargarDatosIniciales();

        int opcion;

        do {
            System.out.println("\n========== SABOR & TRADICION ==========");
            System.out.println("1. Registrar producto en el menu");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Calcular precio de venta de un producto");
            System.out.println("4. Verificar condiciones de calidad de los productos");
            System.out.println("5. Consultar productos disponibles");
            System.out.println("6. Registrar pedido");
            System.out.println("7. Gestionar servicio de domicilio");
            System.out.println("8. Confirmar pedido");
            System.out.println("9. Calcular valor total de un pedido");
            System.out.println("10. Consultar pedidos de un cliente");
            System.out.println("11. Actualizar y consultar estado de un pedido");
            System.out.println("12. Generar reportes de ventas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;

                case 2:
                    registrarCliente();
                    break;

                case 3:
                    calcularPrecioVenta();
                    break;

                case 4:
                    verificarCalidad();
                    break;

                case 5:
                    consultarDisponibles();
                    break;

                case 6:
                    registrarPedido();
                    break;

                case 7:
                    gestionarDomicilio();
                    break;

                case 8:
                    confirmarPedido();
                    break;

                case 9:
                    calcularTotalPedido();
                    break;

                case 10:
                    consultarPedidosCliente();
                    break;

                case 11:
                    actualizarEstado();
                    break;

                case 12:
                    generarReportes();
                    break;

                case 0:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (opcion != 0);
    }

    public static void registrarProducto() {

        System.out.println("\n--- REGISTRAR PRODUCTO ---");
        System.out.println("1. Plato fuerte");
        System.out.println("2. Bebida");
        System.out.println("3. Postre");
        System.out.print("Seleccione el tipo: ");
        int tipo = entrada.nextInt();
        entrada.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo no valido.");
        } else if (tipo == 1 && cantidadPlatos == platos.length) {
            System.out.println("No hay espacio para mas platos.");
        } else if (tipo == 2 && cantidadBebidas == bebidas.length) {
            System.out.println("No hay espacio para mas bebidas.");
        } else if (tipo == 3 && cantidadPostres == postres.length) {
            System.out.println("No hay espacio para mas postres.");
        } else {
            System.out.print("Codigo del producto (numero): ");
            int codigo = entrada.nextInt();
            entrada.nextLine();

            if (codigoProductoExiste(codigo)) {
                System.out.println("Ya existe un producto con ese codigo.");
            } else {
                System.out.print("Nombre: ");
                String nombre = entrada.nextLine();

                System.out.print("Descripcion: ");
                String descripcion = entrada.nextLine();

                System.out.print("Precio base: ");
                double precioBase = entrada.nextDouble();
                entrada.nextLine();

                System.out.print("Tiempo de preparacion en minutos (solo numero): ");
                String tiempo = entrada.nextLine();

                if (tipo == 1) {
                    System.out.print("Peso (g): ");
                    double peso = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.println("Preparacion:");
                    System.out.println("1. ASADO");
                    System.out.println("2. FRITO");
                    System.out.println("3. HORNEADO");
                    System.out.println("4. A LA PLANCHA");
                    System.out.print("Seleccione la preparacion: ");
                    int prep = entrada.nextInt();
                    entrada.nextLine();

                    TipoPreparacion tipoPreparacion = TipoPreparacion.ASADO;
                    boolean preparacionValida = true;

                    switch (prep) {
                        case 1:
                            tipoPreparacion = TipoPreparacion.ASADO;
                            break;
                        case 2:
                            tipoPreparacion = TipoPreparacion.FRITO;
                            break;
                        case 3:
                            tipoPreparacion = TipoPreparacion.HORNEADO;
                            break;
                        case 4:
                            tipoPreparacion = TipoPreparacion.A_LA_PLANCHA;
                            break;
                        default:
                            preparacionValida = false;
                            System.out.println("Preparacion no valida.");
                            break;
                    }

                    if (preparacionValida) {
                        System.out.print("Coccion aprobada? (S/N): ");
                        String respuesta = entrada.nextLine();
                        boolean coccion = respuesta.equalsIgnoreCase("S");

                        platos[cantidadPlatos] = new PlatoFuerte(
                                codigo, nombre, descripcion, precioBase,
                                tiempo, peso, tipoPreparacion, coccion
                        );
                        cantidadPlatos++;
                        System.out.println("Producto registrado correctamente.");
                    }

                } else if (tipo == 2) {
                    System.out.print("Volumen (ml): ");
                    double volumen = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.print("Temperatura de servicio (C): ");
                    double temperatura = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.println("Tipo de bebida:");
                    System.out.println("1. FRIA");
                    System.out.println("2. CALIENTE");
                    System.out.print("Seleccione: ");
                    int tipoBebidaOpcion = entrada.nextInt();
                    entrada.nextLine();

                    TipoBebida tipoBebida = TipoBebida.FRIA;
                    boolean bebidaValida = true;

                    switch (tipoBebidaOpcion) {
                        case 1:
                            tipoBebida = TipoBebida.FRIA;
                            break;
                        case 2:
                            tipoBebida = TipoBebida.CALIENTE;
                            break;
                        default:
                            bebidaValida = false;
                            System.out.println("Tipo de bebida no valido.");
                            break;
                    }

                    if (bebidaValida) {
                        System.out.print("Requiere preparacion especial? (S/N): ");
                        String respuesta = entrada.nextLine();
                        boolean especial = respuesta.equalsIgnoreCase("S");

                        bebidas[cantidadBebidas] = new Bebida(
                                codigo, nombre, descripcion, precioBase,
                                tiempo, volumen, temperatura, tipoBebida, especial
                        );
                        cantidadBebidas++;
                        System.out.println("Producto registrado correctamente.");
                    }

                } else {
                    System.out.print("Peso (g): ");
                    double peso = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.print("Temperatura de almacenamiento (C): ");
                    double temperatura = entrada.nextDouble();
                    entrada.nextLine();

                    System.out.print("Requiere refrigeracion? (S/N): ");
                    String respuesta = entrada.nextLine();
                    boolean refrigeracion = respuesta.equalsIgnoreCase("S");

                    postres[cantidadPostres] = new Postre(
                            codigo, nombre, descripcion, precioBase,
                            tiempo, peso, temperatura, refrigeracion
                    );
                    cantidadPostres++;
                    System.out.println("Producto registrado correctamente.");
                }
            }
        }
    }

    public static void registrarCliente() {

        System.out.println("\n--- REGISTRAR CLIENTE ---");

        if (cantidadClientes == clientes.length) {
            System.out.println("No hay espacio para mas clientes.");
        } else {
            System.out.print("Numero de documento: ");
            String documento = entrada.nextLine();

            if (buscarCliente(documento) >= 0) {
                System.out.println("Ya existe un cliente con ese documento.");
            } else {
                System.out.print("Nombre completo: ");
                String nombre = entrada.nextLine();

                System.out.print("Telefono: ");
                String telefono = entrada.nextLine();

                System.out.print("Correo electronico: ");
                String correo = entrada.nextLine();

                System.out.print("Direccion de residencia: ");
                String direccion = entrada.nextLine();

                clientes[cantidadClientes] = new Cliente(
                        documento, nombre, telefono, correo, direccion
                );
                cantidadClientes++;
                System.out.println("Cliente registrado correctamente.");
            }
        }
    }

    public static void calcularPrecioVenta() {

        System.out.println("\n--- CALCULAR PRECIO DE VENTA ---");

        System.out.print("Codigo del producto: ");
        int codigo = entrada.nextInt();
        entrada.nextLine();

        int indicePlato = buscarPlato(codigo);
        int indiceBebida = buscarBebida(codigo);
        int indicePostre = buscarPostre(codigo);

        if (indicePlato >= 0) {
            PlatoFuerte plato = platos[indicePlato];
            mostrarPrecio(plato.getNombre(), plato.getPrecioBase(),
                    plato.calcularPrecioVenta());
        } else if (indiceBebida >= 0) {
            Bebida bebida = bebidas[indiceBebida];
            mostrarPrecio(bebida.getNombre(), bebida.getPrecioBase(),
                    bebida.calcularPrecioVenta());
        } else if (indicePostre >= 0) {
            Postre postre = postres[indicePostre];
            mostrarPrecio(postre.getNombre(), postre.getPrecioBase(),
                    postre.calcularPrecioVenta());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void mostrarPrecio(String nombre, double precioBase, double precioVenta) {
        System.out.println(
                nombre + " | Precio base: $" + precioBase
                        + " | Precio de venta: $" + precioVenta
        );
    }

    public static void verificarCalidad() {

        System.out.println("\n--- CONDICIONES DE CALIDAD ---");

        if (cantidadPlatos + cantidadBebidas + cantidadPostres == 0) {
            System.out.println("No hay productos registrados.");
        } else {
            for (int i = 0; i < cantidadPlatos; i++) {
                imprimirCalidad(platos[i], platos[i].cumpleCondicionesCalidad());
            }

            for (int i = 0; i < cantidadBebidas; i++) {
                imprimirCalidad(bebidas[i], bebidas[i].cumpleCondicionesCalidad());
            }

            for (int i = 0; i < cantidadPostres; i++) {
                imprimirCalidad(postres[i], postres[i].cumpleCondicionesCalidad());
            }
        }
    }

    public static void imprimirCalidad(Producto producto, boolean cumple) {
        String resultado;

        if (cumple) {
            resultado = "CUMPLE";
        } else {
            resultado = "RECHAZADO";
        }

        System.out.println(
                producto.getCodigoUnico() + " - " + producto.getNombre()
                        + ": " + resultado
        );
    }

    public static void consultarDisponibles() {

        System.out.println("\n--- PRODUCTOS DISPONIBLES ---");

        int disponibles = 0;

        for (int i = 0; i < cantidadPlatos; i++) {
            if (platos[i].cumpleCondicionesCalidad()) {
                System.out.println(
                        platos[i].mostrarInformacion()
                                + "  Precio de venta: $" + platos[i].calcularPrecioVenta()
                );
                disponibles++;
            }
        }

        for (int i = 0; i < cantidadBebidas; i++) {
            if (bebidas[i].cumpleCondicionesCalidad()) {
                System.out.println(
                        bebidas[i].mostrarInformacion()
                                + "  Precio de venta: $" + bebidas[i].calcularPrecioVenta()
                );
                disponibles++;
            }
        }

        for (int i = 0; i < cantidadPostres; i++) {
            if (postres[i].cumpleCondicionesCalidad()) {
                System.out.println(
                        postres[i].mostrarInformacion()
                                + "  Precio de venta: $" + postres[i].calcularPrecioVenta()
                );
                disponibles++;
            }
        }

        if (disponibles == 0) {
            System.out.println("No hay productos disponibles.");
        }
    }

    public static void registrarPedido() {

        System.out.println("\n--- REGISTRAR PEDIDO ---");

        if (cantidadPedidos == pedidos.length) {
            System.out.println("No hay espacio para mas pedidos.");
        } else {
            System.out.print("Codigo del pedido: ");
            String codigo = entrada.nextLine();

            if (buscarPedido(codigo) >= 0) {
                System.out.println("Ya existe un pedido con ese codigo.");
            } else {
                System.out.print("Documento del cliente: ");
                String documento = entrada.nextLine();

                int indiceCliente = buscarCliente(documento);

                if (indiceCliente < 0) {
                    System.out.println("El cliente no esta registrado.");
                } else {
                    Cliente cliente = clientes[indiceCliente];

                    System.out.println("Modalidad:");
                    System.out.println("1. Consumo en restaurante");
                    System.out.println("2. Domicilio");
                    System.out.print("Seleccione la modalidad: ");
                    int opcionModalidad = entrada.nextInt();
                    entrada.nextLine();

                    ModalidadEntrega modalidad = ModalidadEntrega.CONSUMO_RESTAURANTE;
                    boolean modalidadValida = true;

                    switch (opcionModalidad) {
                        case 1:
                            modalidad = ModalidadEntrega.CONSUMO_RESTAURANTE;
                            break;
                        case 2:
                            modalidad = ModalidadEntrega.DOMICILIO;
                            break;
                        default:
                            modalidadValida = false;
                            System.out.println("Modalidad no valida.");
                            break;
                    }

                    if (modalidadValida) {
                        Pedido pedido = new Pedido(
                                codigo, LocalDate.now(), cliente, modalidad
                        );

                        String respuesta = "S";

                        while (respuesta.equalsIgnoreCase("S")) {

                            System.out.print("Codigo del producto: ");
                            int codigoProducto = entrada.nextInt();
                            entrada.nextLine();

                            int indicePlato = buscarPlato(codigoProducto);
                            int indiceBebida = buscarBebida(codigoProducto);
                            int indicePostre = buscarPostre(codigoProducto);

                            if (indicePlato < 0 && indiceBebida < 0 && indicePostre < 0) {
                                System.out.println("Producto no encontrado.");
                            } else {
                                System.out.print("Cantidad: ");
                                int cantidad = entrada.nextInt();
                                entrada.nextLine();

                                if (indicePlato >= 0) {
                                    pedido.agregarPlatoFuerte(platos[indicePlato], cantidad);
                                } else if (indiceBebida >= 0) {
                                    pedido.agregarBebida(bebidas[indiceBebida], cantidad);
                                } else {
                                    pedido.agregarPostre(postres[indicePostre], cantidad);
                                }

                                System.out.println("Producto agregado al pedido.");
                            }

                            System.out.print("Desea agregar otro producto? (S/N): ");
                            respuesta = entrada.nextLine();
                        }

                        pedidos[cantidadPedidos] = pedido;
                        cantidadPedidos++;

                        System.out.println("Pedido registrado en estado PENDIENTE.");

                        if (modalidad == ModalidadEntrega.DOMICILIO) {
                            System.out.println(
                                    "Recuerde gestionar el servicio de domicilio (opcion 7) antes de confirmar."
                            );
                        }
                    }
                }
            }
        }
    }

    public static void gestionarDomicilio() {

        System.out.println("\n--- GESTIONAR DOMICILIO ---");

        System.out.print("Codigo del pedido: ");
        String codigo = entrada.nextLine();

        int indicePedido = buscarPedido(codigo);

        if (indicePedido < 0) {
            System.out.println("Pedido no encontrado.");
        } else if (pedidos[indicePedido].getModalidad() != ModalidadEntrega.DOMICILIO) {
            System.out.println("El pedido no es a domicilio.");
        } else if (pedidos[indicePedido].getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println("Solo se gestiona el domicilio de pedidos pendientes.");
        } else {
            Pedido pedido = pedidos[indicePedido];

            System.out.println("Empresa:");
            System.out.println("1. RapidoExpress");
            System.out.println("2. EntregaSegura");
            System.out.print("Seleccione la empresa: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            EmpresaDomicilio empresa = null;
            boolean empresaValida = true;

            switch (opcion) {
                case 1:
                    empresa = new RapidoExpress();
                    break;
                case 2:
                    empresa = new EntregaSegura();
                    break;
                default:
                    empresaValida = false;
                    System.out.println("Empresa no valida.");
                    break;
            }

            if (empresaValida) {
                System.out.print("Distancia del recorrido en km: ");
                double distancia = entrada.nextDouble();
                entrada.nextLine();

                ServicioDomicilio servicio = new ServicioDomicilio(empresa, distancia);
                boolean aceptado = servicio.solicitarServicio();
                pedido.asociarServicioDomicilio(servicio);

                System.out.println(servicio.mostrarInformacion());

                if (!aceptado) {
                    System.out.println(
                            "La empresa no acepta esa distancia. Pruebe con otra empresa o distancia."
                    );
                }
            }
        }
    }

    public static void confirmarPedido() {

        System.out.println("\n--- CONFIRMAR PEDIDO ---");

        System.out.print("Codigo del pedido: ");
        String codigo = entrada.nextLine();

        int indicePedido = buscarPedido(codigo);

        if (indicePedido < 0) {
            System.out.println("Pedido no encontrado.");
        } else if (pedidos[indicePedido].getEstado() != EstadoPedido.PENDIENTE) {
            System.out.println(
                    "El pedido esta en estado " + pedidos[indicePedido].getEstado()
                            + ". Solo se confirman pedidos pendientes."
            );
        } else if (buscarCliente(
                pedidos[indicePedido].getCliente().getNumeroDocumento()) < 0) {
            System.out.println("El cliente del pedido no esta registrado.");
        } else {
            Pedido pedido = pedidos[indicePedido];

            boolean productosValidos = true;

            for (int i = 0; i < pedido.getCantidadDetalles(); i++) {
                int codigoProducto = pedido.getDetalles()[i].getProducto().getCodigoUnico();

                if (!codigoProductoExiste(codigoProducto)) {
                    productosValidos = false;
                    System.out.println(
                            "El producto " + codigoProducto + " no pertenece al menu."
                    );
                }
            }

            if (productosValidos) {
                if (pedido.confirmar()) {
                    System.out.println("Pedido confirmado.");
                } else {
                    System.out.println(
                            "No se pudo confirmar. Revise que tenga productos, que las cantidades "
                                    + "sean mayores que cero, que todos los productos cumplan la calidad y, "
                                    + "si es a domicilio, que el servicio haya sido aceptado."
                    );
                }
            }
        }
    }

    public static void calcularTotalPedido() {

        System.out.println("\n--- TOTAL DEL PEDIDO ---");

        System.out.print("Codigo del pedido: ");
        String codigo = entrada.nextLine();

        int indicePedido = buscarPedido(codigo);

        if (indicePedido < 0) {
            System.out.println("Pedido no encontrado.");
        } else {
            Pedido pedido = pedidos[indicePedido];

            System.out.println("Total productos: $" + pedido.calcularTotalProductos());
            System.out.println("Domicilio: $" + pedido.calcularCostoDomicilio());
            System.out.println("Total del pedido: $" + pedido.calcularTotal());
        }
    }

    public static void consultarPedidosCliente() {

        System.out.println("\n--- PEDIDOS DEL CLIENTE ---");

        System.out.print("Documento del cliente: ");
        String documento = entrada.nextLine();

        int indiceCliente = buscarCliente(documento);

        if (indiceCliente < 0) {
            System.out.println("El cliente no esta registrado.");
        } else {
            int encontrados = 0;

            for (int i = 0; i < cantidadPedidos; i++) {
                if (pedidos[i].getCliente().getNumeroDocumento().equals(documento)) {
                    System.out.println(pedidos[i].mostrarInformacion());
                    encontrados++;
                }
            }

            if (encontrados == 0) {
                System.out.println("El cliente no tiene pedidos.");
            }
        }
    }

    public static void actualizarEstado() {

        System.out.println("\n--- ACTUALIZAR ESTADO DEL PEDIDO ---");

        System.out.print("Codigo del pedido: ");
        String codigo = entrada.nextLine();

        int indicePedido = buscarPedido(codigo);

        if (indicePedido < 0) {
            System.out.println("Pedido no encontrado.");
        } else {
            Pedido pedido = pedidos[indicePedido];

            System.out.println("Estado actual: " + pedido.getEstado());
            System.out.println("Nuevo estado:");
            System.out.println("1. Entregado");
            System.out.println("2. Cancelado");
            System.out.println("0. No cambiar");
            System.out.print("Seleccione una opcion: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion == 1) {
                if (pedido.entregar()) {
                    System.out.println("Estado actualizado a " + pedido.getEstado());
                } else {
                    System.out.println("Solo se puede entregar un pedido confirmado.");
                }
            } else if (opcion == 2) {
                if (pedido.cancelar()) {
                    System.out.println("Estado actualizado a " + pedido.getEstado());
                } else {
                    System.out.println(
                            "Solo se puede cancelar un pedido pendiente o confirmado."
                    );
                }
            }
        }
    }

    public static void generarReportes() {

        System.out.println("\n--- REPORTES DE VENTAS ---");

        double ingresos = 0;
        double ingresosPlatos = 0;
        double ingresosBebidas = 0;
        double ingresosPostres = 0;

        for (int i = 0; i < cantidadPedidos; i++) {
            Pedido pedido = pedidos[i];

            if (pedido.contabilizaIngreso()) {
                ingresos = ingresos + pedido.calcularTotalProductos();

                for (int j = 0; j < pedido.getCantidadDetalles(); j++) {
                    DetallePedido detalle = pedido.getDetalles()[j];
                    int codigoProducto = detalle.getProducto().getCodigoUnico();

                    if (buscarPlato(codigoProducto) >= 0) {
                        ingresosPlatos = ingresosPlatos + detalle.calcularSubtotal();
                    } else if (buscarBebida(codigoProducto) >= 0) {
                        ingresosBebidas = ingresosBebidas + detalle.calcularSubtotal();
                    } else {
                        ingresosPostres = ingresosPostres + detalle.calcularSubtotal();
                    }
                }
            }
        }

        System.out.println("Ingresos del restaurante (sin domicilios): $" + ingresos);

        int maximoUnidades = 0;
        String nombreMasVendido = "";

        for (int i = 0; i < cantidadPlatos; i++) {
            int unidades = contarUnidades(platos[i].getCodigoUnico());

            if (unidades > maximoUnidades) {
                maximoUnidades = unidades;
                nombreMasVendido = platos[i].getNombre();
            }
        }

        for (int i = 0; i < cantidadBebidas; i++) {
            int unidades = contarUnidades(bebidas[i].getCodigoUnico());

            if (unidades > maximoUnidades) {
                maximoUnidades = unidades;
                nombreMasVendido = bebidas[i].getNombre();
            }
        }

        for (int i = 0; i < cantidadPostres; i++) {
            int unidades = contarUnidades(postres[i].getCodigoUnico());

            if (unidades > maximoUnidades) {
                maximoUnidades = unidades;
                nombreMasVendido = postres[i].getNombre();
            }
        }

        if (maximoUnidades == 0) {
            System.out.println("Producto mas vendido: aun no hay ventas.");
        } else {
            System.out.println(
                    "Producto mas vendido: " + nombreMasVendido
                            + " (" + maximoUnidades + " unidades)"
            );
        }

        if (ingresos == 0) {
            System.out.println("Categoria con mayores ingresos: aun no hay ventas.");
        } else if (ingresosPlatos >= ingresosBebidas && ingresosPlatos >= ingresosPostres) {
            System.out.println(
                    "Categoria con mayores ingresos: " + PlatoFuerte.CATEGORIA_PLATO_FUERTE
                            + " ($" + ingresosPlatos + ")"
            );
        } else if (ingresosBebidas >= ingresosPostres) {
            System.out.println(
                    "Categoria con mayores ingresos: " + Bebida.CATEGORIA_BEBIDA
                            + " ($" + ingresosBebidas + ")"
            );
        } else {
            System.out.println(
                    "Categoria con mayores ingresos: " + Postre.CATEGORIA_POSTRE
                            + " ($" + ingresosPostres + ")"
            );
        }
    }

    public static int contarUnidades(int codigoProducto) {
        int unidades = 0;

        for (int i = 0; i < cantidadPedidos; i++) {
            if (pedidos[i].contabilizaIngreso()) {
                for (int j = 0; j < pedidos[i].getCantidadDetalles(); j++) {
                    DetallePedido detalle = pedidos[i].getDetalles()[j];

                    if (detalle.getProducto().getCodigoUnico() == codigoProducto) {
                        unidades = unidades + detalle.getCantidad();
                    }
                }
            }
        }

        return unidades;
    }

    public static int buscarPlato(int codigo) {
        for (int i = 0; i < cantidadPlatos; i++) {
            if (platos[i].getCodigoUnico() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarBebida(int codigo) {
        for (int i = 0; i < cantidadBebidas; i++) {
            if (bebidas[i].getCodigoUnico() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarPostre(int codigo) {
        for (int i = 0; i < cantidadPostres; i++) {
            if (postres[i].getCodigoUnico() == codigo) {
                return i;
            }
        }
        return -1;
    }

    public static boolean codigoProductoExiste(int codigo) {
        return buscarPlato(codigo) >= 0
                || buscarBebida(codigo) >= 0
                || buscarPostre(codigo) >= 0;
    }

    public static int buscarCliente(String documento) {
        for (int i = 0; i < cantidadClientes; i++) {
            if (clientes[i].getNumeroDocumento().equals(documento)) {
                return i;
            }
        }
        return -1;
    }

    public static int buscarPedido(String codigo) {
        for (int i = 0; i < cantidadPedidos; i++) {
            if (pedidos[i].getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }

    public static void cargarDatosIniciales() {

        platos[cantidadPlatos] = new PlatoFuerte(
                101, "Churrasco", "Carne a la brasa con papa",
                30000, "25", 350, TipoPreparacion.ASADO, true
        );
        cantidadPlatos++;

        platos[cantidadPlatos] = new PlatoFuerte(
                102, "Pescado frito", "Mojarra con patacon",
                28000, "20", 150, TipoPreparacion.FRITO, true
        );
        cantidadPlatos++;

        bebidas[cantidadBebidas] = new Bebida(
                201, "Limonada de coco", "Limonada cremosa",
                8000, "5", 400, 5, TipoBebida.FRIA, true
        );
        cantidadBebidas++;

        bebidas[cantidadBebidas] = new Bebida(
                202, "Chocolate caliente", "Chocolate con queso",
                6000, "8", 300, 70, TipoBebida.CALIENTE, false
        );
        cantidadBebidas++;

        postres[cantidadPostres] = new Postre(
                301, "Brownie con helado", "Brownie tibio",
                10000, "10", 150, 4, true
        );
        cantidadPostres++;

        clientes[cantidadClientes] = new Cliente(
                "1001", "Ana Gomez", "3001112233",
                "ana@correo.com", "Calle 10 # 5-20"
        );
        cantidadClientes++;

        clientes[cantidadClientes] = new Cliente(
                "1002", "Luis Perez", "3004445566",
                "luis@correo.com", "Carrera 14 # 8-30"
        );
        cantidadClientes++;
    }
}
