package restmock.restmock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SpringBootApplication
public class RestMockApplication extends SpringBootServletInitializer {
	@Bean
	public Gson getGson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}

	public static void main(String[] args) {
		SpringApplication.run(RestMockApplication.class, args);
	}
}
