package gradle.spring.pet.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import gradle.spring.pet.greeters.Greeter;

@Configuration
public class BootConfiguration {
	
	@Bean
	public Greeter createGreeter() {
		return new Greeter();
	}
}
