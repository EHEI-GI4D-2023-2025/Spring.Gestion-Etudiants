package site.technova.gestionetudiant.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "site.technova.gestionetudiant")
@PropertySource("classpath:app.properties")
public class AppConfig {
    @Value("${jdbc.url.datasource}")
    private String url;

    @Value("${jdbc.url.username}")
    private String username;

    @Value("${jdbc.url.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }
}
