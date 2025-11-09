package pl.edu.wszib.powtorka.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan({
        "pl.edu.wszib.powtorka.authentication",
        "pl.edu.wszib.powtorka.core",
        "pl.edu.wszib.powtorka.database",
        "pl.edu.wszib.powtorka.gui"
})
public class AppConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
