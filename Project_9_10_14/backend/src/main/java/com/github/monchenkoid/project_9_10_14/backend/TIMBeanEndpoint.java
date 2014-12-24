package com.github.monchenkoid.project_9_10_14.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "timBeanApi",
        version = "v1",
        resource = "timBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.project_9_10_14.monchenkoid.github.com",
                ownerName = "backend.project_9_10_14.monchenkoid.github.com",
                packagePath = ""
        )
)
public class TIMBeanEndpoint {

    private static final Logger logger = Logger.getLogger(TIMBeanEndpoint.class.getName());

    /**
     * This method gets the <code>TIMBean</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>TIMBean</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getTIMBean")
    public TIMBean getTIMBean(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getTIMBean method");
        return null;
    }

    /**
     * This inserts a new <code>TIMBean</code> object.
     *
     * @param tIMBean The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertTIMBean")
    public TIMBean insertTIMBean(TIMBean tIMBean) {
        // TODO: Implement this function
        logger.info("Calling insertTIMBean method");
        return tIMBean;
    }
}