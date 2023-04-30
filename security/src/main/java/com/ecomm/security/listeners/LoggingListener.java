package com.ecomm.security.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class LoggingListener implements ApplicationListener<ApplicationEvent>, Ordered{

    
    /**
     * The getOrder function is used to determine the order in which listeners are called.
     * The default value of 0 means that it will be called after all other listeners, but before any post-processing.
     
     *
     *
     * @return The order of the listener
     *
     */
    @Override
    public int getOrder() {
        return LoggingApplicationListener.DEFAULT_ORDER - 1;
    }

    
    /**
     * The onApplicationEvent function is called by the Spring Boot framework when an ApplicationEvent occurs.
     * In this case, we are only interested in the ApplicationEnvironmentPreparedEvent event which occurs after
     * all of the properties have been loaded from application.properties and other property files.  We then use those
     * properties to set our logging system's log path, app name, console log level, file log level and root logger level.
     
     *
     * @param ApplicationEvent event Get the environment properties
     *
     * @return void
     *
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent)
        {
            // Fetch environment properties
            ConfigurableEnvironment environment = ((ApplicationEnvironmentPreparedEvent) event).getEnvironment();
            String logPath = environment.getProperty("logging.file.path");
            if (logPath == null || logPath.isEmpty())
            {
                logPath = "logs";
            }
            // Set Log Path either with default(logs) or from properties
            System.setProperty("log.path", logPath);
            String appName = environment.getProperty("spring.application.name");
            if (appName == null || appName.isEmpty())
            {
                appName = "app";
            }
            // Set App Name either with default(app) or from properties
            System.setProperty("app.name", appName);
            String consoleLogLevel = environment.getProperty("logging.level.console");
            if (consoleLogLevel == null || consoleLogLevel.isEmpty())
            {
                consoleLogLevel = "INFO";
            }
            // Set Console Log Level either with default(INFO) or from properties
            System.setProperty("log.level.console", consoleLogLevel);
            String fileLogLevel = environment.getProperty("logging.level.file");
            if (fileLogLevel == null || fileLogLevel.isEmpty())
            {
                fileLogLevel = "INFO";
            }
            // Set File Log Level either with default(INFO) or from properties
            System.setProperty("log.level.file", fileLogLevel);
            String rootLogLevel = environment.getProperty("logging.level.root");
            if (rootLogLevel == null || rootLogLevel.isEmpty())
            {
                rootLogLevel = "INFO";
            }
            // Set Root Log Level either with default(INFO) or from properties
            System.setProperty("log.level.root", rootLogLevel);
        }
    }
    
}
