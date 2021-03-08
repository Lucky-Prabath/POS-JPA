package lk.ijse.dep.web.listener; /**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/


import lk.ijse.dep.web.WebAppInitializer;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@WebListener
public class ContextListener implements ServletContextListener{

    org.slf4j.Logger logger = LoggerFactory.getLogger(ContextListener.class);

    public ContextListener() {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {


    }

}
