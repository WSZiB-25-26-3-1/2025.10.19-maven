package pl.edu.wszib.powtorka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.Scanner;

@Configuration
//@ImportResource("classpath:application-context.xml")
@ComponentScan({
        "pl.edu.wszib.powtorka.authentication",
        "pl.edu.wszib.powtorka.core",
        "pl.edu.wszib.powtorka.database",
        "pl.edu.wszib.powtorka.gui"
})
@ImportResource("classpath:cxf-bean.xml")
public class AppConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
