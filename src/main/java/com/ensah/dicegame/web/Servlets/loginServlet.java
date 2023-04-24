package com.ensah.dicegame.web.Servlets;

import com.ensah.dicegame.bo.Message;
import com.ensah.dicegame.bo.MessageTypes;
import com.ensah.dicegame.bo.State;
import com.ensah.dicegame.bo.User;
import com.ensah.dicegame.web.DataManagement.IDataManagement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@WebServlet(name = "loginServlet", value = "/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password= request.getParameter("password");

        if(login!=null && password!=null){
            // we need to check if the user exist, using the getUserByLogin methode
            IDataManagement gameData = (IDataManagement) getServletContext().getAttribute("gameData");
            User user = gameData.getUserByLogin(login);
            //if the login exist in the DB
            if(user!=null){
                //check if the passwords match
                if(password.equals(user.getPassword())){
                    request.setAttribute("message",new Message("Welcome back, "+user.getLname(), MessageTypes.SUCCESS));
                    //saving the user in the session
                    request.getSession().setAttribute("user",user);
                    //forward to the gamePage
                    getServletContext().getRequestDispatcher("/WEB-INF/vues/GamePage.jsp").forward(request,response);
                    return;
                }
                else{
                    //forward to the login page indicating an error message saying the credentials do not match
                    request.setAttribute("message",new Message("credentials do not match, please verify", MessageTypes.WARNING));
                    getServletContext().getRequestDispatcher("/WEB-INF/vues/LoginPage.jsp").forward(request,response);
                    return;
                }
            }
            else{
                request.setAttribute("message",new Message("credentials do not match, please verify", MessageTypes.WARNING));
                getServletContext().getRequestDispatcher("/WEB-INF/vues/LoginPage.jsp").forward(request,response);
                return;
            }
        }
        else{
            getServletContext().getRequestDispatcher("/WEB-INF/vues/LoginPage.jsp").forward(request,response);
        }



    }
}
