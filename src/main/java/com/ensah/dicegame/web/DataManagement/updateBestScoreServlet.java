package com.ensah.dicegame.web.DataManagement;

import com.ensah.dicegame.bo.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "updateBestScoreServlet", value = "/updateBestScore")
public class updateBestScoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double bestScore = Double.valueOf(request.getParameter("bestScore"));
        IDataManagement gameData = (IDataManagement) request.getServletContext().getAttribute("gameData");
        if(bestScore!=null){
            User user = (User) request.getSession().getAttribute("user");
            user.setBestScore(bestScore);
            gameData.updateBestScore(user);
        }
    }
}
