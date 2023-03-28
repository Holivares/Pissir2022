package edu.uniupo.pissir.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

@Configuration
@EnableJpaRepositories( basePackages = { "edu.uniupo.pissir.repository" }, enableDefaultTransactions = false, bootstrapMode = BootstrapMode.DEFERRED )
public class AppConfiguration {
}
