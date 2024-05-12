package conversordemoneda.api;
import com.google.gson.Gson;
import conversordemoneda.modelos.Moneda;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda tipoMoneda(String paisA, String paisC, double monto){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7efc1b467a71b57018b53c06/pair/"+
        paisA+"/"+paisC+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
