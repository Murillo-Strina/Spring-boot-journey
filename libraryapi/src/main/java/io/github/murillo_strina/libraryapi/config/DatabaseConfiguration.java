package io.github.murillo_strina.libraryapi.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    /**
     * Alternative configuration using DriverManagerDataSource (Commented out).
     * This approach creates a new connection for each request, which can
     * negatively impact performance in high-load applications.
     */
    // @Bean
    // public DataSource dataSource() {
    // DriverManagerDataSource ds = new DriverManagerDataSource();
    // ds.setUrl(url);
    // ds.setUsername(username);
    // ds.setPassword(password);
    // ds.setDriverClassName(driver);
    // return ds;
    // }
    /**
     * Configures the DataSource using HikariCP, an efficient and high-performance
     * connection pool for Spring Boot applications.
     */
    @Bean
    public DataSource hikariDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);

        // Sets the maximum number of connections in the pool
        config.setMaximumPoolSize(10);

        // Sets the minimum number of idle connections (0 means all connections will be
        // released when not in use)
        config.setMinimumIdle(1);

        // Defines a custom name for the connection pool
        config.setPoolName("library-db-pool");

        // Sets the maximum lifetime of a connection (10 minutes)
        config.setMaxLifetime(600000);
        config.setConnectionTimeout(100000);
        config.setConnectionTestQuery("select 1"); // Test query

        return new HikariDataSource(config);
    }
}
