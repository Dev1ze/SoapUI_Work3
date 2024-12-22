import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetRequest 
{
	public static void main(String[] args) 
	{
		String url = "http://speller.yandex.net/services/spellservice/checkText?text=";
        String myText = "Привет мир! Я изучаю джаву и вэб програмирование";

        String encodedText = java.net.URLEncoder.encode(myText, java.nio.charset.StandardCharsets.UTF_8);
        
        String fullUrl = url + encodedText;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) 
        {
            HttpGet request = new HttpGet(fullUrl);

            try (CloseableHttpResponse response = httpClient.execute(request)) 
            {
                String responseBody = EntityUtils.toString(response.getEntity());
                System.out.println("Ответ сервиса:");
                System.out.println(responseBody);
            }
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
}
