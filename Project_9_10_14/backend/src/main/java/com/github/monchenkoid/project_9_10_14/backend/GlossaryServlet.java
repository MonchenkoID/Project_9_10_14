package com.github.monchenkoid.project_9_10_14.backend;

    import com.google.appengine.api.datastore.*;
    import com.google.appengine.api.users.User;
    import com.google.appengine.api.users.UserService;
    import com.google.appengine.api.users.UserServiceFactory;

    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

/**
 * Created by shiza on 17.02.2015.
 */

public class GlossaryServlet extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            String namespace = "default";
            Key namespaceKey = KeyFactory.createKey("Socionics", namespace);
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            Entity greeting = new Entity("Glosary", name, namespaceKey);

            greeting.setProperty("name", name);
            greeting.setProperty("description", description);
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            datastore.put(greeting);

            resp.sendRedirect("/glossary.jsp");
        }

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        }
    }

