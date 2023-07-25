package portfolio.embassy.embassy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import portfolio.embassy.embassy.servises.VisaService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VisaRequestControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    VisaService visaService;

    @Test
    void should_accept_user_id_and_return_200(){
        ResponseEntity<String> response = testRestTemplate.postForEntity("/visa/request?userId=user-0",
                null,
                String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void should_return_ticket_number(){
        //given
        when(visaService.createVisa("user-0")).thenReturn("ticket-0");
        //when
        ResponseEntity<String> response = testRestTemplate.postForEntity("/visa/request?userId=user-0",
                null,
                String.class
        );
        //then
        assertThat(response.getBody()).isEqualTo("ticket-0");
    }
}
