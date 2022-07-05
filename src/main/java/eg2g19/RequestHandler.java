package eg2g19;
// // This sample uses the Apache HTTP client from HTTP Components (http://hc.apache.org/httpcomponents-client-ga/)

import javafx.scene.control.Alert;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.net.URI;

public class RequestHandler
{

    private String url;
    private String contentType;
    private String predictionKey;
    private String appName;


    public RequestHandler(String url, String contentType, String predictionKey, String appName) {
        this.url = url;
        this.contentType = contentType;
        this.predictionKey = predictionKey;
        this.appName = appName;
    }


    public String makeRequest(File f)
    {
        HttpClient httpclient = HttpClients.createDefault();
        String result = null;

        try
        {
            URIBuilder builder = new URIBuilder(url);

            builder.setParameter("application", appName);

            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);
            request.setHeader("Content-Type", contentType);
            request.setHeader("Prediction-key", predictionKey);


            // Request body
            // body is image File path (I think)
            FileEntity reqEntity = new FileEntity(f);
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);

            if (entity != null)
            {
                System.out.println(result);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Request Timed OUt");
            errorAlert.setContentText("Please check internet connection");
            errorAlert.showAndWait();
        }
        return result;
    }
}

