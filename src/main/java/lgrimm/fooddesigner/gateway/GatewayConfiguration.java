package lgrimm.fooddesigner.gateway;

import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@Configuration
public class GatewayConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
