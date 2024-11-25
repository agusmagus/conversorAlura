import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class convertir {
    private static final String API_KEY = "1df523ed051e347668649f5b";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void convertirMoneda(Scanner scanner)
    {
        System.out.print("Introduce la moneda de origen (por ejemplo, USD): ");
        String monedaOrigen = scanner.next().toUpperCase();
        System.out.print("Introduce la moneda de destino (por ejemplo, EUR): ");
        String monedaDestino = scanner.next().toUpperCase();
        System.out.print("Introduce la cantidad a convertir: ");
        double cantidad = scanner.nextDouble();

        try
        {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(API_URL + monedaOrigen)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
            double tipoCambio = jsonResponse.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
            double conversion = cantidad * tipoCambio;

            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formateado = DateTimeFormatter.ofPattern("MM-dd-yy HH:mm");
            String fechaFormteada = now.format(formateado);

            System.out.printf("La cantidad convertida es: %.2f %s%n", conversion, monedaDestino);
            System.out.printf("Fecha de conversión: %s%n", fechaFormteada);
            historial.guardarHistorico(monedaOrigen, monedaDestino, cantidad, conversion, fechaFormteada);
        }
        catch (Exception e)
        {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        }
    }
}
