package lk.ijse.dep.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-08
 **/

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.dep.web.dao")
@Import(JPAConfig.class)
public class WebRootConfig {
}
