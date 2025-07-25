package br.com.logos.telinhaquente.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "omdb.api")
public class OmdbProperties {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

@SpringBootApplication
@EnableConfigurationProperties(OmdbProperties.class)
public class TelinhaquenteApplication {
    public static void main(String[] args) {
        SpringApplication.run(TelinhaquenteApplication.class, args);
    }
}