<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>

<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <link type="text/css" rel="stylesheet" href="/stylesheets/main.css"/>
    </head>
    <body>
        <p>Глоссарий</p>
        <br>

        <%
            String socionics = "default";
            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            Key namespaceKey = KeyFactory.createKey("Socionics", socionics);
            Query query = new Query("Glosary", namespaceKey).addSort("name", Query.SortDirection.DESCENDING);
            List<Entity> glossary = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(50));
            if (glossary.isEmpty()) {
        %>
            <p>Glossary has no messages.</p>
        <%
            } else {
                    for (Entity word : glossary) {
                        pageContext.setAttribute("glossary_name", word.getProperty("name"));

        %>
            <blockquote>${fn:escapeXml(glossary_name)}</blockquote>
        <%
        pageContext.setAttribute("glossary_name", word.getProperty("description"));
          %>
                    <blockquote>${fn:escapeXml(glossary_name)}</blockquote>
                <%
                }
            }
        %>

        <form action="/glossary" method="post">
            <div><input type="text" name="name"/></div>
            <div><input type="text" name="description"/></div>
            <div><input type="submit" value="Post Greeting"/></div>
        </form>
    </body>
</html>