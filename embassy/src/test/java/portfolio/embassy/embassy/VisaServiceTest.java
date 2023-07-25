package portfolio.embassy.embassy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import portfolio.embassy.embassy.config.HttpProperties;
import portfolio.embassy.embassy.servises.VisaService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VisaServiceTest {
    @Mock RestTemplate template;
    @Spy HttpProperties properties = HttpProperties.builder()
            .visaEndpoint("http://visa-service")
            .build();
    @InjectMocks VisaService target;


    @Test
    void should_call_external_visa_service(){
        when(template.postForEntity(
                "http://visa-service/request?userId=user-0",
                null,
                String.class
        )).thenReturn(ResponseEntity.ok("ticket-0"));

        assertThat(target.createVisa("user-0"));

//        verify(template,
//                times(1))
//                .postForEntity("http://visa-service/request?userId=user-0",
//                null,
//                String.class
//        );
    }

}