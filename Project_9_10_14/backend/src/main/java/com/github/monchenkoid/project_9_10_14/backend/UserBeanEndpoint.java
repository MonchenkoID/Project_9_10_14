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
        name = "userBeanApi",
        version = "v1",
        resource = "userBean",
        namespace = @ApiNamespace(
                ownerDomain = "backend.project_9_10_14.monchenkoid.github.com",
                ownerName = "backend.project_9_10_14.monchenkoid.github.com",
                packagePath = ""
        )
)
public class UserBeanEndpoint {

    private static final Logger logger = Logger.getLogger(UserBeanEndpoint.class.getName());

    /**
     * This method gets the <code>UserBean</code> object associated with the specified <code>id</code>.
     *
     * @param id The id of the object to be returned.
     * @return The <code>UserBean</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getUserBean")
    public UserBean getUserBean(@Named("id") Long id) {
        // TODO: Implement this function
        logger.info("Calling getUserBean method");
        return null;
    }

    /**
     * This inserts a new <code>UserBean</code> object.
     *
     * @param userBean The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertUserBean")
    public UserBean insertUserBean(UserBean userBean) {
        // TODO: Implement this function
        logger.info("Calling insertUserBean method");
        return userBean;
    }
}