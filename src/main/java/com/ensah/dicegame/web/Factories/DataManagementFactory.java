package com.ensah.dicegame.web.Factories;

import com.ensah.dicegame.web.DataManagement.ContextManagement;
import com.ensah.dicegame.web.DataManagement.DataBaseManagement;
import com.ensah.dicegame.web.DataManagement.IDataManagement;
import jakarta.servlet.ServletContext;

public class DataManagementFactory {
    public static IDataManagement getFactory(String type, ServletContext ctx){
        if(type.equals("context")){
            return ContextManagement.getInstance(ctx);
        }
        return DataBaseManagement.getInstance();

    }
}
