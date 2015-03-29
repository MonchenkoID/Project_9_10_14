package com.github.monchenkoid.project_9_10_14.backend;

import com.google.appengine.api.datastore.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by shiza on 17.02.2015.
 */

public class TimServlet extends HttpServlet {
        @Override
        public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            String namespace = "default";
            Key namespaceKey = KeyFactory.createKey("Socionics", namespace);
            String name = req.getParameter("name");
            String nameFormal = req.getParameter("name_formal");
            String nameFormalFull = req.getParameter("name_formal_full");
            String nameRole = req.getParameter("name_role");
            String nameMbti = req.getParameter("name_mbti");
            String ungExtravertOrIntrovert = req.getParameter("ung_extravert_or_introvert");
            String ungIntuitionOrSensation = req.getParameter("ung_intuition_or_sensation");
            String ungThinkingOrFeeling = req.getParameter("ung_thinking_or_feeling");
            String ungRationalOrIrrational = req.getParameter("ung_rational_or_irrational");
            String modelALeading = req.getParameter("model_a_leading");
            String modelACreative = req.getParameter("model_a_creative");
            String modelARole = req.getParameter("model_a_role");
            String modelAVulnerable = req.getParameter("model_a_vulnerable");
            String modelASuggestive = req.getParameter("model_a_suggestive");
            String modelAMobilizing = req.getParameter("model_a_mobilizing");
            String modelAObservant = req.getParameter("model_a_observant");
            String modelABackground = req.getParameter("model_a_background");

            Entity greeting = new Entity("TIM", name, namespaceKey);
            greeting.setProperty("name_formal", nameFormal);
            greeting.setProperty("name_formal_full", nameFormalFull);
            greeting.setProperty("name_role", nameRole);
            greeting.setProperty("name_mbti", nameMbti);
            greeting.setProperty("ung_extravert_or_introvert", ungExtravertOrIntrovert);
            greeting.setProperty("ung_intuition_or_sensation", ungIntuitionOrSensation);
            greeting.setProperty("ung_thinking_or_feeling", ungThinkingOrFeeling);
            greeting.setProperty("ung_rational_or_irrational",ungRationalOrIrrational);
            greeting.setProperty("model_a_leading",modelALeading);
            greeting.setProperty("model_a_creative",modelACreative);
            greeting.setProperty("model_a_role", modelARole);
            greeting.setProperty("model_a_vulnerable", modelAVulnerable);
            greeting.setProperty("model_a_suggestive", modelASuggestive);
            greeting.setProperty("model_a_mobilizing", modelAMobilizing);
            greeting.setProperty("model_a_observant", modelAObservant);
            greeting.setProperty("model_a_background", modelABackground);

            DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
            datastore.put(greeting);

            resp.sendRedirect("/tim.jsp");
        }

        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        }
    }

