package lk.ijse.dep.web;

import lk.ijse.dep.web.util.LogConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-02-28
 **/
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebAppInitializer() {
        LogConfig.initLogging();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
