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
            Query query = new Query("TIM", namespaceKey).addSort("name", Query.SortDirection.DESCENDING);
            List<Entity> tims = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(50));
            if (tims.isEmpty()) {
        %>
            <p>TIM is void.</p>
        <%
            } else {
                    for (Entity tim : tims) {
                        pageContext.setAttribute("tims_name", tim.getProperty("name"));

        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%

            pageContext.setAttribute("tims_name", tim.getProperty("name_alias"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("name_formal"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("name_formal_full"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("name_role"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("name_mbti"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("ung_extravert_or_introvert"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("ung_intuition_or_sensation"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
            pageContext.setAttribute("tims_name", tim.getProperty("ung_thinking_or_feeling"));
        %>
            <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
             pageContext.setAttribute("tims_name", tim.getProperty("ung_rational_or_irrational"));
         %>
             <blockquote>${fn:escapeXml(tims_name)}</blockquote>
         <%
             pageContext.setAttribute("tims_name", tim.getProperty("model_a_leading"));
         %>
             <blockquote>${fn:escapeXml(tims_name)}</blockquote>
         <%
             pageContext.setAttribute("tims_name", tim.getProperty("model_a_creative"));
         %>
             <blockquote>${fn:escapeXml(tims_name)}</blockquote>
         <%
             pageContext.setAttribute("tims_name", tim.getProperty("model_a_role"));
         %>
             <blockquote>${fn:escapeXml(tims_name)}</blockquote>
         <%

             pageContext.setAttribute("tims_name", tim.getProperty("model_a_vulnerable"));
         %>
             <blockquote>${fn:escapeXml(tims_name)}</blockquote>
         <%
              pageContext.setAttribute("tims_name", tim.getProperty("model_a_suggestive"));
        %>
              <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
              pageContext.setAttribute("tims_name", tim.getProperty("model_a_mobilizing"));
        %>
              <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
              pageContext.setAttribute("tims_name", tim.getProperty("model_a_observant"));
        %>
              <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
              pageContext.setAttribute("tims_name", tim.getProperty("model_a_background"));
        %>
              <blockquote>${fn:escapeXml(tims_name)}</blockquote>
        <%
                }
            }
        %>

        <form action="/tim" method="post">
            <div><input type="text" name="name"/></div>
            <div><input type="text" name="name_formal" direction="desc"/>
            <div><input type="text" name="name_formal_full" direction="desc"/>
            <div><input type="text" name="name_role" direction="desc"/>
            <div><input type="text" name="name_mbti" direction="desc"/>
            <div><input type="text" name="ung_extravert_or_introvert" direction="desc"/>
            <div><input type="text" name="ung_intuition_or_sensation" direction="desc"/>
            <div><input type="text" name="ung_thinking_or_feeling" direction="desc"/>
            <div><input type="text" name="ung_rational_or_irrational" direction="desc"/>
            <div><input type="text" name="model_a_leading" direction="desc"/>
            <div><input type="text" name="model_a_creative" direction="desc"/>
            <div><input type="text" name="model_a_role" direction="desc"/>
            <div><input type="text" name="model_a_vulnerable" direction="desc"/>
            <div><input type="text" name="model_a_suggestive" direction="desc"/>
            <div><input type="text" name="model_a_mobilizing" direction="desc"/>
            <div><input type="text" name="model_a_observant" direction="desc"/>
            <div><input type="text" name="model_a_background" direction="desc"/>
            <div><input type="submit" value="Post Greeting"/></div>
        </form>
    </body>
</html>