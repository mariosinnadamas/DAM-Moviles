package juegosdemesa;

import java.io.*;
import java.util.*;

public class GestorJuegos {
    Scanner sc = new Scanner(System.in);
    //Ordena por nombre y hace que no sea case Sensitive
    Set<Juego> coleccionJuegos = new TreeSet<>(Comparator.comparing(Juego::getTitulo, String.CASE_INSENSITIVE_ORDER));

    public void anadirJuego(Juego juego) {
        coleccionJuegos.add(juego);
        System.out.println("Juego/s añadido/s correctamente");
    }

    public void listarJuegos() {
        for (Juego temp : coleccionJuegos) {
            System.out.println(temp.getDescripcion());
        }
    }

    public void busquedaPorTitulo(){
        System.out.println("MENÚ BUSQUEDA POR TITULO");
        System.out.print("Inserte el titulo del juego: ");
        String titulo = sc.nextLine();

        boolean encontrado = false;
        for (Juego temp : coleccionJuegos) {
            String tituloJuego = temp.getTitulo().toLowerCase();
            if (tituloJuego.startsWith(titulo)) {
                System.out.println(temp);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.err.println("No existe el juego");
        }
    }

    public void guardarDatos() {
        File f = new File ("Recursos/juegosdemesa.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))){
            for (Juego temp : coleccionJuegos) {
                if (temp instanceof JuegoCartas){
                    JuegoCartas jc = (JuegoCartas) temp;
                    bw.write("CARTAS," + jc.getTitulo() + "," + jc.getnMin() + "," + jc.getnMax() + ","
                            + jc.getDuracionMinutos() + "," + jc.getTipoJuego() + "," + jc.getnCartas());
                } else if (temp instanceof JuegoTablero) {
                    JuegoTablero jt = (JuegoTablero) temp;
                    bw.write("TABLERO," + jt.getTitulo() + "," + jt.getnMin() + "," + jt.getnMax() + ","
                            + jt.getDuracionMinutos() + "," + jt.getTipoJuego() + "," + jt.getTamanoTablero());
                } else {
                    bw.write("JUEGO," + temp.getTitulo() + "," + temp.getnMin() + "," + temp.getnMax() + ","
                            + temp.getDuracionMinutos() + "," + temp.getTipoJuego());
                }
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha podido encontrar el archivo " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarDatos() {
        File f = new File("Recursos/juegosdemesa.txt");
        String linea;
        String [] datos;
        try(BufferedReader br = new BufferedReader(new FileReader(f))){
            while ((linea = br.readLine()) != null) {
                datos = linea.split(",");

                String tipo = datos[0];
                String titulo = datos[1];
                int nMin = Integer.parseInt(datos[2]);
                int nMax = Integer.parseInt(datos[3]);
                int duracion = Integer.parseInt(datos[4]);
                Juego.TipoJuego tipoJuego = Juego.TipoJuego.valueOf(datos[5]);

                switch (tipo) {
                    case "CARTAS":
                        int numCartas = Integer.parseInt(datos[6]);
                        coleccionJuegos.add(new JuegoCartas(titulo, nMin, nMax, duracion, tipoJuego, numCartas));
                        break;
                        case "TABLERO":
                            String tablero = datos[6];
                            coleccionJuegos.add(new JuegoTablero(titulo, nMin, nMax, duracion, tipoJuego, tablero));
                            break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
