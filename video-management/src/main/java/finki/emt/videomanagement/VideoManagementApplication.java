package finki.emt.videomanagement;

import finki.emt.videomanagement.domain.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VideoManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoManagementApplication.class, args);
    }

}
