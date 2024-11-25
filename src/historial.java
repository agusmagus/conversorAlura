import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class historial {
    private static List<String> historialConversion = new ArrayList<>();
    public static void guardarHistorico(String monedaOrigen, String monedaDestino, double cantidad, double cantidadConvertida, String fecha)
    {
        String conversionRecord = String.format("%s %.2f -> %s %.2f en %s", monedaOrigen, cantidad, monedaDestino, cantidadConvertida, fecha);
        historialConversion.add(conversionRecord);
        try (FileWriter writer = new FileWriter("conversion_history.txt", true))
    {
        writer.write(conversionRecord + "\n");
    }
    catch (IOException e)
    {
        System.out.println("Error al guardar el historial de conversiones: " + e.getMessage());
    }
    }
    public static void verHistorico()
    {
        System.out.println("Historial de conversión:");
        try
        {
            File file = new File("conversion_history.txt"); Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine())
            {
                System.out.println(fileScanner.nextLine());
            }
            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No se encontró el archivo de historial de conversiones.");
        }
    }
}
