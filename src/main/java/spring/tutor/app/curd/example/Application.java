package spring.tutor.app.curd.example;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;

@SpringBootApplication
public class Application {
	
	@Autowired
    private ResourceLoader resourceLoader;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	private static final String SCHEMA_VALIDATION_FILE = "validation.json";

	@Bean
	public JsonSchema jsonSchema() throws IOException {
		InputStream stream = resourceLoader.getResource("classpath:" + SCHEMA_VALIDATION_FILE).getInputStream();
		return JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7)
				.getSchema(stream);
	}

	@Bean
	public ObjectMapper getMapper() {
		return new ObjectMapper();
	}
}
