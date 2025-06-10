public class CristianismoSIR {
    public static void main(String[] args) {
        // Modelo SIR y sus parámetros
        double beta = 0.4;   // Tasa de Conversión
        double gamma = 0.1;  // Tasa de Integración
        double dt = 1.0;     // Cada paso representa un siglo

        // Condiciones iniciales (siglo V, año 500)
        double S = 0.99; // No Cristianos
        double I = 0.01; // Evangelizadores Activos
        double R = 0.00; // Cristianos Estables

        int siglos = 11; // De siglo V (año 500) al siglo XV (año 1500)

        System.out.println("Simulación de la expansión del cristianismo (modelo SIR)");
        System.out.println("Siglo\tNo cristianos (S)\tEvangelizadores (I)\tCristianos estables (R)");

        for (int t = 0; t <= siglos; t++) {
            // Imprimir resultados
            System.out.printf("%d\t%.4f\t\t\t%.4f\t\t\t%.4f\n", t + 5, S, I, R); // t + 5 para indicar siglo V, VI, VII...

            // Calcular derivadas
            double dS = -beta * S * I;
            double dI = beta * S * I - gamma * I;
            double dR = gamma * I;

            // Método de Euler
            S += dS * dt;
            I += dI * dt;
            R += dR * dt;
        }

        System.out.println("\nLeyenda:");
        System.out.println("S: Proporción de población aún no cristiana.");
        System.out.println("I: Proporción de población que difunde activamente el cristianismo.");
        System.out.println("R: Proporción de población cristianizada e integrada.");
    }
}
