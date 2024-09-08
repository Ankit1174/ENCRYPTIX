import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

public class task_2 {

    /*-----getExchangeRate Method-----*/
    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        double exchangeRate = 0.0;
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/40e5f9704976192d3387e4a6/latest/" + baseCurrency;
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                StringBuilder inline = new StringBuilder();
                Scanner sc = new Scanner(url.openStream());

                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }
                sc.close();

                JSONObject json = new JSONObject(inline.toString());
                exchangeRate = json.getJSONObject("conversion_rates").getDouble(targetCurrency);
            } else {
                System.out.println("HTTP Response Code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println("Error fetching data: " + e.getMessage());
        } catch (JSONException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
        }
        return exchangeRate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        task_2 obj = new task_2();

        System.out.println("ENTER BASE CURRENCY: ");
        String baseCurrency = sc.nextLine().toUpperCase();

        System.out.println("ENTER TARGET CURRENCY: ");
        String targetCurrency = sc.nextLine().toUpperCase();

        System.out.println("ENTER AMOUNT TO CONVERT: ");
        double amount = sc.nextDouble();

        double exchangeRate = obj.getExchangeRate(baseCurrency, targetCurrency);
        if(exchangeRate > 0) {
            double convertAmount = amount * exchangeRate;
            System.out.println(amount + " " + baseCurrency+" = "+convertAmount + " " +  targetCurrency );
        } else {
            System.out.println("Failed to retrieve the exchange rate.");
        }
        sc.close();
    }
}
