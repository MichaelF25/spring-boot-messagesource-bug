package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@SpringBootApplication
@RestController
public class Application {

    @Autowired
    public MessageSource messageSource;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/us")
    public String helloUS() {
        return messageSource.getMessage("some.property", null, Locale.US);
    }

    @RequestMapping("/de")
    public String helloDE() {
        return messageSource.getMessage("some.property", null, Locale.GERMAN);
    }
}
