package com.ensah.dicegame.web.listeners;

import com.ensah.dicegame.bo.User;
import com.ensah.dicegame.web.DataManagement.IDataManagement;
import com.ensah.dicegame.web.Factories.DataManagementFactory;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.ArrayList;

@WebListener
public class AppInitializer implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String type = sce.getServletContext().getInitParameter("type_stockage");
        IDataManagement gameData = DataManagementFactory.getFactory(type,ctx);
        ctx.setAttribute("gameData",gameData);
    }

    public void contextDestroyed(ServletContextEvent sce) {
       // System.out.println("app shutdown");
    }
}
