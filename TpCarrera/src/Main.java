import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// 1. Inicializar las 4 escuderías
		Escuderia Verde = new Escuderia("Verde");
		Escuderia Amarillo = new Escuderia("Amarillo");
		Escuderia Azul = new Escuderia("Azul");
		Escuderia Rojo = new Escuderia("Rojo");

		List<Escuderia> escuderias = Arrays.asList(Verde, Amarillo, Azul, Rojo);

		Random random = new Random();

		int vueltas = 3;

		String resultadoRondas = "--- PUNTOS POR RONDA ---\n";

		// 2. Usar un bucle while para realizar las 3 rondas
		while (vueltas > 0) {
			int rondaActual = 4 - vueltas;
			resultadoRondas += "\nRONDA " + rondaActual + ":\n";

			for (Escuderia escuderia : escuderias) {

				int puntaje = random.nextInt(16) + 10;

				escuderia.agregarPunto(puntaje);

				resultadoRondas += " " + escuderia.getNombre() + ": " + puntaje + " pts\n";
			}

			vueltas--;
		}

		// --- CÁLCULO DE RESULTADOS FINALES ---

		// Determinar el ganador y calcular totales
		Escuderia ganador = null;
		int puntajeMaximo = -1;
		String resumenTotal = "\n--- PUNTAJE TOTAL Y PROMEDIO ---\n";

		for (Escuderia escuderia : escuderias) {
			int total = escuderia.calcularPuntajeTotal();

			double promedio = escuderia.getPuntosPorRonda().stream().mapToInt(Integer::intValue).average().orElse(0.0);

			// Construir el resumen total y promedio
			resumenTotal += escuderia.getNombre() + " -> Total: " + total + " pts | Promedio: "
					+ String.format("%.2f", promedio) + " pts\n";

			// Lógica para encontrar al ganador
			if (total > puntajeMaximo) {
				puntajeMaximo = total;
				ganador = escuderia;
			}
		}

		// 2. Construir el mensaje final para JOptionPane
		String mensajeFinal = resultadoRondas + "\n" + resumenTotal;

		if (ganador != null) {
			mensajeFinal += "\n--- ¡GANADOR! ---\n";
			mensajeFinal += "La escudería ganadora es: " + ganador.getNombre() + " con un total de " + puntajeMaximo
					+ " puntos.";
		} else {
			mensajeFinal += "\nError al determinar el ganador.";
		}

		// 3. Mostrar el resultado final en JOptionPane
		JOptionPane.showMessageDialog(null, mensajeFinal, "Resultados de la Carrera (3 Rondas)",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
