package com.ufps.sgd;

import com.ufps.sgd.domain.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class UfpsSgdApplication {

    public static void main(String[] args) {
        SpringApplication.run(UfpsSgdApplication.class, args);
    }

}
