package portfolio.embassy.embassy.servises;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import portfolio.embassy.embassy.config.HttpProperties;

@Service
@RequiredArgsConstructor
public class VisaService {
    private final RestTemplate visaRestTemplate;
    private final HttpProperties properties;


    @Cacheable("visa-request")
    public String createVisa(String s){
        ResponseEntity<String> response = visaRestTemplate.postForEntity(properties.getVisaEndpoint() + "/request?userId=" + s,
                null,
                String.class
        );

        return response.getBody();
    }
}
