package lk.ijse.dep.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/

@Configuration
@ComponentScan
@EnableAspectJAutoProxy //to enable the transaction aspect in util package in bo layer
public class AppConfig {
}
