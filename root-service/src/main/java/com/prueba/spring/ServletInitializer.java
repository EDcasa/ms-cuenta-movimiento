package com.prueba.spring;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ServletInitializer to run spring boot app.
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * configure
     *
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppWebApplication.class);
    }

}
