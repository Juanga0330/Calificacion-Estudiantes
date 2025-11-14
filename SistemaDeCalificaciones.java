import java.util.Scanner;

public class SistemaDeCalificaciones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declaración de variables
        final int NUM_ESTUDIANTES = 5;
        final int NUM_EVALUACIONES = 4;
        final double NOTA_APROBACION = 3.0;
        
        String[] nombres = new String[NUM_ESTUDIANTES];
        double[][] notas = new double[NUM_ESTUDIANTES][NUM_EVALUACIONES];
        double[] promediosEstudiantes = new double[NUM_ESTUDIANTES];
        double[] promediosEvaluaciones = new double[NUM_EVALUACIONES];
        
        // Solicitar nombres de estudiantes
        System.out.println("=== REGISTRO DE ESTUDIANTES ===");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
        }
        
        // Solicitar notas
        System.out.println("\n=== INGRESO DE NOTAS ===");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            for (int j = 0; j < NUM_EVALUACIONES; j++) {
                System.out.print("Ingrese la nota del estudiante " + nombres[i] + 
                                " en evaluación " + (j + 1) + ": ");
                notas[i][j] = scanner.nextDouble();
            }
        }
        
        // Calcular promedio por estudiante
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            double suma = 0;
            for (int j = 0; j < NUM_EVALUACIONES; j++) {
                suma += notas[i][j];
            }
            promediosEstudiantes[i] = suma / NUM_EVALUACIONES;
        }
        
        // Calcular promedio por evaluación
        for (int j = 0; j < NUM_EVALUACIONES; j++) {
            double suma = 0;
            for (int i = 0; i < NUM_ESTUDIANTES; i++) {
                suma += notas[i][j];
            }
            promediosEvaluaciones[j] = suma / NUM_ESTUDIANTES;
        }
        
        // Encontrar estudiante con mejor promedio
        int indiceMejor = 0;
        double mejorPromedio = promediosEstudiantes[0];
        for (int i = 1; i < NUM_ESTUDIANTES; i++) {
            if (promediosEstudiantes[i] > mejorPromedio) {
                mejorPromedio = promediosEstudiantes[i];
                indiceMejor = i;
            }
        }
        
        // Mostrar promedio por estudiante
        System.out.println("\n=== PROMEDIO POR ESTUDIANTE ===");
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.printf("%s → %.2f\n", nombres[i], promediosEstudiantes[i]);
        }
        
        // Mostrar promedio por evaluación
        System.out.println("\n=== PROMEDIO POR EVALUACIÓN ===");
        for (int j = 0; j < NUM_EVALUACIONES; j++) {
            System.out.printf("Evaluación %d → %.2f\n", (j + 1), promediosEvaluaciones[j]);
        }
        
        // Mostrar mejor promedio
        System.out.println("\n=== MEJOR PROMEDIO ===");
        System.out.printf("El estudiante con mejor promedio es: %s (%.2f)\n", 
                         nombres[indiceMejor], mejorPromedio);
        
        // Mostrar resultados finales
        System.out.println("\n=== RESULTADOS FINALES ===");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("| Estudiante      ");
        for (int j = 0; j < NUM_EVALUACIONES; j++) {
            System.out.printf("| Eval%d ", (j + 1));
        }
        System.out.println("| Promedio | Estado     |");
        System.out.println("------------------------------------------------------------------------");
        
        for (int i = 0; i < NUM_ESTUDIANTES; i++) {
            System.out.printf("| %-15s ", nombres[i]);
            for (int j = 0; j < NUM_EVALUACIONES; j++) {
                System.out.printf("| %.1f  ", notas[i][j]);
            }
            System.out.printf("| %.2f     ", promediosEstudiantes[i]);
            
            String estado = promediosEstudiantes[i] >= NOTA_APROBACION ? "Aprobado" : "Reprobado";
            System.out.printf("| %-10s |\n", estado);
        }
        System.out.println("------");
        
       
    }
}