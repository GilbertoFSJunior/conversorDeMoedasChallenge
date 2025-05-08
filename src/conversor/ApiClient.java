package conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiClient {

    private static final String API_BASE_URL = "https://v6.exchangerate-api.com"; // Corrigido o URL
    private final String apiKey;
    private final Gson gson = new Gson();

    public ApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public JsonObject getExchangeRates(String base, String toCurrency) throws IOException, InterruptedException {
        String uri = API_BASE_URL + "/v6/" + apiKey + "/latest/" +  URLEncoder.encode(base, StandardCharsets.UTF_8);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .header("Accept", "application/json")
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro ao obter taxas de câmbio: Código de status " + response.statusCode() + ", Resposta: " + response.body());
        }

        String responseBody = response.body();
        return gson.fromJson(responseBody, JsonObject.class);
    }

    public static void main(String[] args) {
        String apiKey = "264c2f3059053280df57c430"; // Substitua pela sua chave de API
        ApiClient apiClient = new ApiClient(apiKey);
        try {
            JsonObject exchangeRates = apiClient.getExchangeRates("USD", "EUR,GBP,BRL");
            System.out.println(exchangeRates);

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
