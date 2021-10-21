package com.area.myfirst.webservice;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
@SwaggerDefinition (info = @Info (
                    title = "Example Service",
                    description = "A simple example of apiee",
                    version = "1.0.0",
                    contact = @Contact (
                        name = "Jordi Ascension", 
                        email = "jordiascension@bonarea.com", 
                        url = "http://bonarea.com"
                    )
                )
            )
public class JAXRSConfiguration extends Application {
    
}
