package ro.softwaredulce.templateapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ro.softwaredulce.templateapplication.config.authentication.UserRole;
import ro.softwaredulce.templateapplication.domain.User;
import ro.softwaredulce.templateapplication.domain.UserRepository;

import java.util.Optional;

@SpringBootApplication
public class TemplateApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TemplateApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        Optional<User> admin = userRepository.findByUsername("admin");
        if (!admin.isPresent()) {
            User user = new User();
            user.setName("Ciprian");
            user.setUsername("admin");
            user.setPassword("$2a$04$XXdHonxRKp5H0D0yJcJUKe5LF/Vhej/ssukSi8MhCyxG1QWo2zr6G");
            user.setEnabled(true);
            user.setRoles(UserRole.all());
            userRepository.save(user);
        }
    }
}
