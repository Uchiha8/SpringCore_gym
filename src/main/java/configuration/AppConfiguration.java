package configuration;

import dao.implementation.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.implementation.UserService;
import utils.DataSource;
import utils.Facade;

@Configuration
public class AppConfiguration {

    @Bean
    public DataSource dataSource() {
        return new DataSource();
    }

    @Bean
    public UserDAO userDAO() {
        DataSource dataSource = new DataSource();
        return new UserDAO(dataSource);
    }

    @Bean
    public UserService userService() {
        return new UserService(userDAO());
    }

    @Bean
    public Facade facade(UserService userService) {
        return new Facade(userService);
    }

}
