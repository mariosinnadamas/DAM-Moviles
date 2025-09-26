package juegosdemesa;

public class JuegoTablero extends Juego{
    private String tamanoTablero;

    public JuegoTablero(String titulo, int nMin, int nMax, int duracionMinutos, TipoJuego tipoJuego, String tamanoTablero) {
        super(titulo, nMin, nMax, duracionMinutos, tipoJuego);
        this.tamanoTablero = tamanoTablero;
    }

    public String getTamanoTablero() {
        return tamanoTablero;
    }

    public void setTamanoTablero(String tamanoTablero) {
        this.tamanoTablero = tamanoTablero;
    }

    @Override
    public String toString() {
        return super.toString() + " Tamaño del tablero = " + tamanoTablero;
    }

    @Override
    public String getDescripcion() {
        return "Juego de cartas: " + getTitulo() +
                " | Jugadores: " + getnMin() + "-" + getnMax() +
                " | Duración: " + getDuracionMinutos() + " min" +
                " | Tablero: " + this.tamanoTablero;
    }
}
