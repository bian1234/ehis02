package com.thinkgem.jeesite.cfq.sys.listener;

import javax.servlet.ServletContext;

import com.thinkgem.jeesite.cfq.sys.service.PrescriptionSystemService;
import org.springframework.web.context.WebApplicationContext;


public class PrescriptionWebContextListener extends org.springframework.web.context.ContextLoaderListener {

    @Override
    public WebApplicationContext initWebApplicationContext(ServletContext servletContext) {
        if (!PrescriptionSystemService.printKeyLoadMessage()) {

            return null;
        }
        return super.initWebApplicationContext(servletContext);
    }
}

