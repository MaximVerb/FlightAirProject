package real.domen.togethair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TogethAirApplication {

    public static void main(String[] args) {
        SpringApplication.run(TogethAirApplication.class, args);
    }

}
