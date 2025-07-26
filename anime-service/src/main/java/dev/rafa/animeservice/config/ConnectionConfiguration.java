package dev.rafa.animeservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ConnectionConfiguration {

    @Value("${database.url}")
    private String url;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Bean
    // @Primary
    @Profile({"mysql", "test"})
    public Connection connectionMySql() {
        return new Connection(url, username, password);
    }

    @Bean
    @Profile("mongo")
    public Connection connectionMongo() {
        return new Connection("localhost", "devdojoMongo", "goku");
    }

}
