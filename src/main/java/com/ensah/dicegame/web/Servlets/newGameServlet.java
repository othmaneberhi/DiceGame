package com.ensah.dicegame.web.Servlets;

import com.ensah.dicegame.bo.State;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "newGameServlet", value = "/secure/newGame")
public class newGameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //saving the gameStat in the session
        HashMap<Integer,Integer> launchedDices = new HashMap<>();
        State gameState = new State(0,false,launchedDices);
        request.getSession().setAttribute("gameState",gameState);
        getServletContext().getRequestDispatcher("/WEB-INF/vues/PlayPage.jsp").forward(request,response);
    }
}
