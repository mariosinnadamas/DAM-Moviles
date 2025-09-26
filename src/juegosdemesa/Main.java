package juegosdemesa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorJuegos gestor = new GestorJuegos();
        boolean comprobado = false; //Variable reutilizada para comprobar las distintas entradas
        gestor.cargarDatos();

        String eleccion;

        while(true){
            System.out.println("MENU DE JUEGOS DE MESA");
            System.out.println("1. Añadir juego");
            System.out.println("2. Listar juegos");
            System.out.println("3. Buscar juego por nombre");
            System.out.println("4. Salir");
            eleccion = sc.nextLine();
            switch (eleccion){
                case "1":
                    System.out.println("MENÚ INSERCION DE JUEGO");

                    String nombreJuego = "";
                    while(!comprobado){
                        System.out.println("Ingrese el nombre del juego: ");
                        nombreJuego = sc.nextLine();
                        if (nombreJuego.isEmpty()){
                            System.err.println("No puedes dejar el nombre vacío");
                        } else {
                            comprobado = true;
                        }
                    }
                    comprobado = false;

                    int nMin = 0;
                    while (!comprobado) {
                        System.out.println("Ingrese número mínimo de jugadores: ");
                        String input = sc.nextLine();

                        if (input.isEmpty()){
                            System.err.println("No puedes dejar este campo vacío");
                            continue;
                        }
                        try {
                            nMin = Integer.parseInt(input);
                            if (nMin < 1){
                                System.err.println("No puede haber menos de 1 jugador");
                            } else {
                                comprobado = true;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Debe introducir un numero entero");
                        }
                    }

                    comprobado = false;

                    int nMax = 0;
                    while (!comprobado){
                        System.out.println("Ingrese número máximo de jugadores: ");
                        String input = sc.nextLine();

                        if (input.isEmpty()){
                            System.err.println("No puedes dejar este campo vacío");
                            continue;
                        }
                        try {
                            nMax = Integer.parseInt(input);
                            if (nMax < nMin){
                                System.err.println("No puede haber menos jugadores que el minimo de jugadores");
                            } else {
                                comprobado = true;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Debe introducir un numero entero");
                        }
                    }

                    comprobado = false;

                    int duracionMin = 0;
                    while (!comprobado) {
                        System.out.println("Ingrese la duración en minutos: ");
                        String input = sc.nextLine();

                        if (input.isEmpty()){
                            System.err.println("No puedes dejar este campo vacío");
                            continue;
                        }
                        try {
                            duracionMin = Integer.parseInt(input);
                            if (duracionMin < 1){
                                System.err.println("La partida no puede durar menos de 1 minuto");
                            } else {
                                comprobado = true;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Debe introducir un numero entero");
                        }
                    }
                    comprobado = false;

                    Juego.TipoJuego tipoJuego = null;
                    while (tipoJuego == null) {
                        System.out.println("Escriba el tipo de juego exactamente: ");
                        for (Juego.TipoJuego t : Juego.TipoJuego.values()) {
                            System.out.println(t);
                        }

                        String tipo = sc.nextLine().toUpperCase();
                        try {
                            tipoJuego = Juego.TipoJuego.valueOf(tipo);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Opción no válida, inténtelo de nuevo");
                        }
                    }

                    int decTipo = 0;
                    while (!comprobado) {
                        System.out.println("Seleccione el tipo de juego: ");
                        System.out.println("1. Juego de cartas");
                        System.out.println("2. Juego de tablero");
                        String input = sc.nextLine();

                        if (input.isEmpty()){
                            System.err.println("No puedes dejar este campo vacío");
                            continue;
                        }
                        try {
                            decTipo = Integer.parseInt(input);
                            if (decTipo != 1 && decTipo != 2){
                                System.err.println("Debe introducir 1 o 2");
                            } else {
                                comprobado = true;
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Debe introducir un numero entero");
                        }
                    }

                    comprobado = false;

                    if (decTipo == 1){
                        int nCartas;
                        while (!comprobado) {
                            System.out.println("¿Cuántas cartas tiene?");
                            String input = sc.nextLine();

                            if (input.isEmpty()){
                                System.err.println("No puedes dejar este campo vacío");
                                continue;
                            }

                            try {
                                nCartas = Integer.parseInt(input);
                                if (nCartas >= 1){
                                    comprobado = true;
                                    gestor.anadirJuego(new JuegoCartas(nombreJuego,nMin,nMax,duracionMin,tipoJuego,nCartas));
                                } else {
                                    System.err.println("No puede haber menos de 1 carta");
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Debe introducir un numero entero");
                            }
                        }
                    } else {
                        String tablero;
                        while (!comprobado) {
                            System.out.println("¿Cuanto mide el tablero? Ej: 20x20, 15x20, etc");
                            tablero = sc.nextLine();
                            if (tablero.isEmpty()){
                                System.err.println("Debe introducir un tamaño de tablero");
                            } else {
                                comprobado = true;
                                gestor.anadirJuego(new JuegoTablero(nombreJuego,nMin,nMax,duracionMin,tipoJuego,tablero));
                            }
                        }
                    }
                    comprobado = false;
                    break;
                case "2":
                    gestor.listarJuegos();
                    break;
                case "3":
                    gestor.busquedaPorTitulo();
                    break;
                case "4":
                    gestor.guardarDatos();
                    System.out.println("Saliendo...");
                    return;
            }
        }
    }
}
