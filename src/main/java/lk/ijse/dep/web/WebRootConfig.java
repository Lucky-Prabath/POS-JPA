package lk.ijse.dep.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@Configuration
@Import(JPAConfig.class)
public class WebRootConfig {
}
