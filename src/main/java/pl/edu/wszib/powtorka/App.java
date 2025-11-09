package pl.edu.wszib.powtorka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.edu.wszib.powtorka.configuration.AppConfiguration;
import pl.edu.wszib.powtorka.core.Core;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        AppConfiguration.class);
        Core core = context.getBean(Core.class);
        core.run();
    }
}
