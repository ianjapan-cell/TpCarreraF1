package tp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.swing.JOptionPane; // ¡Nueva importación necesaria!

// Nota: La clase Piloto sigue siendo la misma.

public class Main {

    public static void main(String[] args) {
        // Establecer el Look and Feel para una mejor apariencia (opcional pero recomendado)
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Ignorar si falla
        }

        // Crear la lista de pilotos (misma lista)
        List<Piloto> pilotos = Arrays.asList(
            new Piloto("Max Verstappen", "Red Bull", 90.540),
            new Piloto("Lewis Hamilton", "Mercedes", 90.875),
            new Piloto("Charles Leclerc", "Ferrari", 91.002),
            new Piloto("George Russell", "Mercedes", 90.998),
            new Piloto("Sergio Perez", "Red Bull", 91.120),
            new Piloto("Carlos Sainz", "Ferrari", 91.250),
            new Piloto("Lando Norris", "McLaren", 91.560),
            new Piloto("Fernando Alonso", "Aston Martin", 91.805),
            new Piloto("Oscar Piastri", "McLaren", 91.680)
        );

        // --- 1. Piloto con el mejor tiempo de vuelta (Pole Position) ---
        Optional<Piloto> mejorTiempo = pilotos.stream()
            .min(Comparator.comparingDouble(Piloto::getTiempoVuelta));

        String msgMejorTiempo = mejorTiempo
            .map(p -> "✅ Piloto con el mejor tiempo (Pole Position):\n" + p.toString())
            .orElse("N/A");

        JOptionPane.showMessageDialog(null, msgMejorTiempo, "1. Mejor Tiempo", JOptionPane.INFORMATION_MESSAGE);

        // --- 2. Piloto con el peor tiempo de vuelta ---
        Optional<Piloto> peorTiempo = pilotos.stream()
            .max(Comparator.comparingDouble(Piloto::getTiempoVuelta));

        String msgPeorTiempo = peorTiempo
            .map(p -> "❌ Piloto con el peor tiempo:\n" + p.toString())
            .orElse("N/A");

        JOptionPane.showMessageDialog(null, msgPeorTiempo, "2. Peor Tiempo", JOptionPane.INFORMATION_MESSAGE);

        // --- 3. Promedio de todos los tiempos ---
        double promedioTiempos = pilotos.stream()
            .mapToDouble(Piloto::getTiempoVuelta)
            .average()
            .orElse(0.0);

        String msgPromedio = "⏱️ Promedio de todos los tiempos de vuelta:\n" + 
                             String.format("%.3f", promedioTiempos) + "s";
                             
        JOptionPane.showMessageDialog(null, msgPromedio, "3. Promedio de Tiempos", JOptionPane.INFORMATION_MESSAGE);

    
        List<Piloto> clasificacionOrdenada = pilotos.stream()
            .sorted(Comparator.comparingDouble(Piloto::getTiempoVuelta))
            .collect(Collectors.toList());

        String msgClasificacion = clasificacionOrdenada.stream()
            .map(p -> String.format("%-2s", (clasificacionOrdenada.indexOf(p) + 1) + ".") + " " + p.toString())
            .collect(Collectors.joining("\n"));
        
        String tituloClasificacion = "📊 Clasificación Completa (Mejor a Peor):\n";
        JOptionPane.showMessageDialog(null, tituloClasificacion + msgClasificacion, "4. Clasificación Ordenada", JOptionPane.PLAIN_MESSAGE);

        // --- 5. Cantidad de pilotos por escudería ---
        Map<String, Long> pilotosPorEscuderia = pilotos.stream()
            .collect(Collectors.groupingBy(
                Piloto::getEscuderia,
                Collectors.counting()
            ));

        String msgPorEscuderia = pilotosPorEscuderia.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue() + " piloto(s)")
            .collect(Collectors.joining("\n"));

        String tituloEscuderia = "🏎️ Cantidad de pilotos por escudería:\n";
        JOptionPane.showMessageDialog(null, tituloEscuderia + msgPorEscuderia, "5. Pilotos por Escudería", JOptionPane.INFORMATION_MESSAGE);
    }
}