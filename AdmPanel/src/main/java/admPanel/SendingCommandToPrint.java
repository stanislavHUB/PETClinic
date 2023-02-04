package admPanel;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class SendingCommandToPrint {
    public static void createPdfFile(){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("APIKey", "5567GGH67225HYVGG");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        String url = "http://print:8081/sendCommandToCreateFile";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        if (response.getStatusCode()==HttpStatus.OK){
            System.out.println("All is fine");
        }else{
            System.out.println("something went wrong");
        }
    }
}
