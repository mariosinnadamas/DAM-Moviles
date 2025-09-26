package juegosdemesa;

public class JuegoCartas extends Juego {

    private int nCartas;

    public JuegoCartas(String titulo, int nMin, int nMax, int duracionMinutos, TipoJuego tipoJuego, int nCartas) {
        super(titulo, nMin, nMax, duracionMinutos, tipoJuego);
        this.nCartas = nCartas;
    }

    public int getnCartas() {
        return nCartas;
    }

    public void setnCartas(int nCartas) {
        this.nCartas = nCartas;
    }

    @Override
    public String toString() {
        return super.toString() + " Número de cartas = " + nCartas;
    }

    @Override
    public String getDescripcion() {
        return "Juego de cartas: " + getTitulo() +
                " | Jugadores: " + getnMin() + "-" + getnMax() +
                " | Duración: " + getDuracionMinutos() + " min" +
                " | Cartas: " + this.nCartas;
    }
}
