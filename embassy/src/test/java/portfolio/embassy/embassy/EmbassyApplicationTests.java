package portfolio.embassy.embassy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmbassyApplicationTests {

	RestTemplateBuilder template = mock(RestTemplateBuilder.class);

	@Autowired
	private final HttpConfiguration httpConfiguration = new HttpConfiguration(template);


	@Test
	void contextLoads() {
	}

}
