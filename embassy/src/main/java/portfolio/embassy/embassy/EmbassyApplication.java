package portfolio.embassy.embassy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import portfolio.embassy.embassy.config.HttpProperties;

@EnableCaching
@EnableConfigurationProperties(HttpProperties.class)
@SpringBootApplication
public class EmbassyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbassyApplication.class, args);
	}

}
