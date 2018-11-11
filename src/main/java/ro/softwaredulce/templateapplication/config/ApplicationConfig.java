package ro.softwaredulce.templateapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import ro.softwaredulce.templateapplication.config.audit.SpringSecurityAuditorAware;
import ro.softwaredulce.templateapplication.config.authentication.CustomUser;

@Configuration
@EnableMongoAuditing
public class ApplicationConfig {

    @Bean
    public AuditorAware<CustomUser> myAuditorProvider() {
        return new SpringSecurityAuditorAware();
    }
}
