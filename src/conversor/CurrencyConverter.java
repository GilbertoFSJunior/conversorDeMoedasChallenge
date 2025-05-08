package conversor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyConverter {

    private final ApiClient apiClient;
    private final Gson gson;
    private final List<String> supportedCurrencies;

    public CurrencyConverter(ApiClient apiClient, Gson gson, List<String> supportedCurrencies) {
        this.apiClient = apiClient;
        this.gson = gson;
        this.supportedCurrencies = supportedCurrencies;
    }

    public CurrencyConverter() {
        this(new ApiClient("264c2f3059053280df57c430"), new Gson(), Arrays.asList("ARS", "BOB", "BRL", "CLP", "COP",
                "USD", "EUR"));
    }

    public double convert(String from, String to, double amount) {
        if (amount <= 0) {
            System.out.println("Valor de conversão deve ser maior que zero.");
            return 0;
        }
        if (!supportedCurrencies.contains(from) || !supportedCurrencies.contains(to)) {
            System.out.println("Moeda não suportada.");
            return 0;
        }
        try {
            JsonObject jsonResponse = apiClient.getExchangeRates(from, to);
            if (jsonResponse != null && jsonResponse.has("conversion_rates")) {
                JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
                if (conversionRates != null && conversionRates.has(to)) {
                    double rate = conversionRates.get(to).getAsDouble();
                    return amount * rate;
                } else {
                    System.out.println("Moeda de destino não encontrada na resposta da API.");
                    return 0;
                }
            } else {
                System.out.println("Objeto 'conversion_rates' não encontrado na resposta da API.");
                return 0;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro na conversão: " + e.getMessage());
            return 0;
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            return 0;
        }
    }

    public List<String> getSupportedCurrencies() {
        return supportedCurrencies;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        double amount = 100;
        String fromCurrency = "USD";
        String toCurrency = "BRL";
        double result = converter.convert(fromCurrency, toCurrency, amount);
        if (result > 0) {
            System.out.printf("%.2f %s são %.2f %s%n", amount, fromCurrency, result, toCurrency);
        } else {
            System.out.println("Conversão falhou.");
        }

        System.out.println("Moedas suportadas: " + converter.getSupportedCurrencies());
    }
}
