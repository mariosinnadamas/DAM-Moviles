package juegosdemesa;

public abstract class Juego {

    private String titulo;
    private int nMin;
    private int nMax;
    private int duracionMinutos;
    protected enum TipoJuego {ESTRATEGIA,PARTY,FAMILIAR}
    private TipoJuego tipoJuego;

    public Juego(String titulo, int nMin, int nMax, int duracionMinutos, TipoJuego tipoJuego) {
        this.titulo = titulo;
        this.nMin = nMin;
        this.nMax = nMax;
        this.duracionMinutos = duracionMinutos;
        this.tipoJuego = tipoJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getnMin() {
        return nMin;
    }

    public void setnMin(int nMin) {
        this.nMin = nMin;
    }

    public int getnMax() {
        return nMax;
    }

    public void setnMax(int nMax) {
        this.nMax = nMax;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public TipoJuego getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(TipoJuego tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    @Override
    public String toString() {
        return "Titulo = " + titulo +
                ", Número mínimo de jugadores = " + nMin +
                ", Número máximo de jugadores = " + nMax +
                ", Duración partida (en min)= " + duracionMinutos +
                ", Tipo de juego = " + tipoJuego;
    }
    public abstract String getDescripcion();
}
