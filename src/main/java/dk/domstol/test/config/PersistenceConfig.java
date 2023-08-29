package dk.domstol.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"dk.domstol.test.repository"})
public class PersistenceConfig {
}
