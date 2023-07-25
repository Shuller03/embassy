package portfolio.embassy.embassy.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "http")
public class HttpProperties {
    String visaEndpoint;
}
