package portfolio.embassy.embassy.servises;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class VisaServiceCacheableTest {

    @MockBean RestTemplate template;
    @Autowired VisaService visaService;

    @Test
    void should_cache(){
        visaService.createVisa("000");
        visaService.createVisa("000");
        visaService.createVisa("000");
        visaService.createVisa("000");
        visaService.createVisa("000");

        Mockito.verify(template, Mockito.times(1)).postForEntity(ArgumentMatchers.startsWith("http"),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.eq(String.class));
    }

}