package AutomakerApp;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@EnableConfigurationProperties
public class Application {
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class)
				.bannerMode(Banner.Mode.OFF)
				.profiles("producao", "homologacao");

		ConfigurableApplicationContext applicationContext = builder.run(args);
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		String applicationName = environment.getProperty("spring.application.name");

		System.out.println("Nome da aplicação: " + applicationName);
	}
}
