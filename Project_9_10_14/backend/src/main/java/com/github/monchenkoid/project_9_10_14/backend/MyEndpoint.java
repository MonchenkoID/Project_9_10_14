/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

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

/**
 * An endpoint class we are exposing
 */
@Api(name = "myApi",
     version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.project_9_10_14.monchenkoid.github.com",
                ownerName = "backend.project_9_10_14.monchenkoid.github.com",
                packagePath = ""))
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "storeMy")
    public void storeMy(TIMBean TIMBean) {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key myBeanParentKey = KeyFactory.createKey("MyBeanParent", "todo.txt");
            Entity taskEntity = new Entity("MyBean", TIMBean.getId(), myBeanParentKey);
            taskEntity.setProperty("data", TIMBean.getName());
            datastoreService.put(taskEntity);
            txn.commit();
        } finally {
            if (txn.isActive()) {
                txn.rollback();
            }
        }
    }

    @ApiMethod(name = "getTasks")
    public List<TIMBean> getTasks() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Key taskBeanParentKey = KeyFactory.createKey("TaskBeanParent", "todo.txt");
        Query query = new Query(taskBeanParentKey);
        List<Entity> results = datastoreService.prepare(query).asList(FetchOptions.Builder.withDefaults());
        ArrayList<TIMBean> TIMBeans = new ArrayList<TIMBean>();
        for (Entity result : results) {
            TIMBean TIMBean = new TIMBean();
            TIMBean.setId(result.getKey().getId());
            TIMBean.setName((String) result.getProperty("data"));
            TIMBeans.add(TIMBean);
        }

        return TIMBeans;
    }

    @ApiMethod(name = "clearTasks")
    public void clearTasks() {
        DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
        Transaction txn = datastoreService.beginTransaction();
        try {
            Key taskBeanParentKey = KeyFactory.createKey("TaskBeanParent", "todo.txt");
            Query query = new Query(taskBeanParentKey);
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

