import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("*Conversor de monedas*");
            System.out.println("1.-Convertir");
            System.out.println("2.-Historial de conversión");
            System.out.println("3.-Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: convertir.convertirMoneda(scanner);
                break;
                case 2: historial.verHistorico();
                break; case 3: System.out.println("Saliendo...");
                break; default: System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 3);
        scanner.close(); }
    }