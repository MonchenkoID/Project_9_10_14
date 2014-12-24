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
import java.util.List;
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

    @ApiMethod(name = "insertTIMBean")
    public void insertTIMBean(TIMBean timBean) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key timBeanParentKey = KeyFactory.createKey("TIMBeanParent", "bcknd");
            Entity timEntity = new Entity("TIMBean", timBean.getId(), timBeanParentKey);
            timEntity.setProperty("name", timBean.getName());
         /*   timEntity.setProperty("dichotomy", timBean.getDichotomy());
            timEntity.setProperty("traitsReinin", timBean.getTraitsReinin());
            timEntity.setProperty("modelA", timBean.getModelA());*/
            datastoreService.put(timEntity);
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

    @ApiMethod(name = "getTIMBeans")
    public List<TIMBean> getTIMBeans() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key timBeanParentKey = KeyFactory.createKey("TIMBeanParent", "bcknd");
        Query query = new Query(timBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<TIMBean> timBeans = new ArrayList<TIMBean>();
        for (Entity result : results) {
            TIMBean timBean = new TIMBean();
            timBean.setId(result.getKey().getId());
            timBean.setName((String) result.getProperty("name"));
         /*   timBean.setDichotomy((String[]) result.getProperty("dichotomy"));
            timBean.setTraitsReinin((String[]) result.getProperty("traitsReinin"));
            timBean.setModelA((String[]) result.getProperty("modelA"));*/
            timBeans.add(timBean);
        }

        return timBeans;
    }

    @ApiMethod(name = "deleteTIMBeans")
    public void deleteTIMBeans() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key timBeanParentKey = KeyFactory.createKey("TIMBeanParent", "bcknd");
            Query query = new Query(timBeanParentKey);
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





