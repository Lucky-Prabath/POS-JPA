package lk.ijse.dep.web;

import lk.ijse.dep.web.util.LogConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@SpringBootApplication
public class AppInitializer {

    public static void main(String[] args) {
        LogConfig.initLogging(); //error log
        SpringApplication.run(AppInitializer.class, args);
    }
}
