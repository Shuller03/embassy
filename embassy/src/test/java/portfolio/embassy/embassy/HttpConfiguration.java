package portfolio.embassy.embassy;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@TestConfiguration
@RequiredArgsConstructor
public class HttpConfiguration {

    private final RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate visaRestTemplate(){
        return restTemplateBuilder.build();
    }
}
