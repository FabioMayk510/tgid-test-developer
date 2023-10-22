package com.maykdeveloper.tgidtestdeveloper.callbacks;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallbackEmpresa {
    public void callback(String tipo, double valor, double taxa) {
        // URL do webhook fornecido pelo site webhook.site
        String webhookURL = "https://webhook.site/c9d7bc6d-7948-4ca6-9b48-10aba295847e";

        try {
            URL url = new URL(webhookURL);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setDoOutput(true);

            String dados = "{\"tipo\":\"" + tipo + "\",\"valor efetivo\":" + valor + "\", \"taxa incidente\":" + (taxa * 100) + "%}";

            try (DataOutputStream out = new DataOutputStream(con.getOutputStream())) {
                out.writeBytes(dados);
                out.flush();
            }

            // resposta do servidor
            int responseCode = con.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            // Feche a conexão
            con.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
