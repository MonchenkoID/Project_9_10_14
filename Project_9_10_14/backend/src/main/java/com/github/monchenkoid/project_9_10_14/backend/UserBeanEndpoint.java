package com.github.monchenkoid.project_9_10_14.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        logger.info("Calling getTIMBean method");
        return null;
    }

    @ApiMethod(name = "insertUserBean")
    public void insertTIMBean(UserBean userBean) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key userBeanParentKey = KeyFactory.createKey("UserBeanParent", "todo.txt");
            Entity userEntity = new Entity("UserBean", userBean.getId(), userBeanParentKey);
            userEntity.setProperty("name", userBean.getName());
            userEntity.setProperty("lastName", userBean.getLastName());
            userEntity.setProperty("state", userBean.getState());
            userEntity.setProperty("countryNatale", userBean.getCountryNatale());
            userEntity.setProperty("cityNatale", userBean.getCityNatale());
            userEntity.setProperty("gender", userBean.getGender());
            userEntity.setProperty("userDateBirthday", userBean.getUserDateBirthday());
            userEntity.setProperty("userTIM", userBean.getUserTIM());
            datastoreService.put(userEntity);
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }


    @ApiMethod(name = "getUserBeans")
    public List<UserBean> getUserBeans() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key userBeanParentKey = KeyFactory.createKey("UserBeanParent", "todo.txt");
        Query query = new Query(userBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<UserBean> userBeans = new ArrayList<UserBean>();
        for (Entity result : results) {
            UserBean userBean = new UserBean();
            userBean.setId(result.getKey().getId());
            userBean.setName((String) result.getProperty("name"));
            userBean.setLastName((String) result.getProperty("lastName"));
            userBean.setState((String) result.getProperty("state"));
            userBean.setCountryNatale((String) result.getProperty("countryNatale"));
            userBean.setCityNatale((String) result.getProperty("cityNatale"));
            userBean.setGender((String) result.getProperty("gender"));
            userBean.setUserDateBirthday((Date) result.getProperty("userDateBirthday"));
            userBean.setUserTIM((TIMBean) result.getProperty("userTIM"));
            userBeans.add(userBean);
        }

        return userBeans;
    }

    @ApiMethod(name = "deleteUserBeans")
    public void deleteUserBeans() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key userBeanParentKey = KeyFactory.createKey("UserBeanParent", "todo.txt");
            Query query = new Query(userBeanParentKey);
            List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
            for (Entity result : results) {
                datastoreService.delete(result.getKey());
            }
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

}





