package mr.demonid.spring.hw3;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(                // и openAPI
        title = "Lesson-3 Spring Framework",
        description = "Написание простого REST-сервиса",
        version = "первая и последняя",
        contact = @Contact(
                name = "Andrey Hlus",
                email = "MrDemonid@yandex.ru"
        )
))

@SpringBootApplication
public class SpringHw3Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringHw3Application.class, args);
    }

}
