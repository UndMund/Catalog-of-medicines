package by.zavadskiy;

import by.zavadskiy.facade.impl.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner {
    @Autowired
    private UserFacade userFacade;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }
}
