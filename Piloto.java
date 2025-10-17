package tp;

public class Piloto {
    private String nombre;
    private String escuderia;
    private double tiempoVuelta;

    public Piloto(String nombre, String escuderia, double tiempoVuelta) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.tiempoVuelta = tiempoVuelta;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public double getTiempoVuelta() {
        return tiempoVuelta;
    }

    
    @Override
    public String toString() {
        return nombre + " (" + escuderia + ") - Tiempo: " + String.format("%.3f", tiempoVuelta) + "s";
    }
}