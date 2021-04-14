package bm.app.watercollector;

import bm.app.watercollector.controllers.RestController;
import bm.app.watercollector.service.WaterService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterCollectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WaterCollectorApplication.class, args);
    }

}
