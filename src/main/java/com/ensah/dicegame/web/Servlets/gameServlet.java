package com.ensah.dicegame.web.Servlets;

import com.ensah.dicegame.bo.User;
import com.ensah.dicegame.web.DataManagement.IDataManagement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "gameServlet", value = "/secure/game")
public class gameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IDataManagement gameData = (IDataManagement) request.getServletContext().getAttribute("gameData");

        //Other players best scores
        ArrayList<User> users=gameData.getUsers();
        request.setAttribute("users",users);

        request.getServletContext().getRequestDispatcher("/WEB-INF/vues/GamePage.jsp").forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
