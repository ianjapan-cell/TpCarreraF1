import java.util.List;
import java.util.ArrayList;


public class Escuderia {
    private String nombre;
    
    private List<Integer> puntosPorRonda; 

    
    public Escuderia(String nombre) {
        this.nombre = nombre;
        this.puntosPorRonda = new ArrayList<>();
    }

    // Get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Integer> getPuntosPorRonda() {
        return puntosPorRonda;
    }

    public void setPuntosPorRonda(List<Integer> puntosPorRonda) {
        this.puntosPorRonda = puntosPorRonda;
    }

    // Método para agregar el puntaje de una ronda
    public void agregarPunto(int punto) {
        this.puntosPorRonda.add(punto);
    }

    // Método para calcular el puntaje total acumulado
    public int calcularPuntajeTotal() {
        int total = 0;
        for (int punto : puntosPorRonda) {
            total += punto;
        }
        return total;
    }
    
    // Método para calcular el promedio 
    public double calcularPromedio() {
        if (puntosPorRonda.isEmpty()) {
            return 0.0;
        }
        return (double) calcularPuntajeTotal() / puntosPorRonda.size();
    }
}
