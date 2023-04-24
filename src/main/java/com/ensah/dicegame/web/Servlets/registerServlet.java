package com.ensah.dicegame.web.Servlets;

import com.ensah.dicegame.bo.Message;
import com.ensah.dicegame.bo.MessageTypes;
import com.ensah.dicegame.bo.User;
import com.ensah.dicegame.web.DataManagement.IDataManagement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "registerServlet", value = "/register")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //getting the information from the form
        String lname = request.getParameter("lname");
        String fname = request.getParameter("fname");;
        String login = request.getParameter("login");;
        String password = request.getParameter("password");;
        String password_confirmation = request.getParameter("password_confirmation");;

        IDataManagement gameData = (IDataManagement) request.getServletContext().getAttribute("gameData");
        if(lname!=null && fname != null && login !=null && password!=null && password_confirmation!=null){
            if(!password_confirmation.equals(password)){
                //if the passwords do not match
                request.setAttribute("message",new Message("Passwords do not match", MessageTypes.WARNING));
                getServletContext().getRequestDispatcher("/WEB-INF/vues/RegisterPage.jsp").forward(request,response);
                return;
            }
            //if a user with the specified login exist already
            User user = gameData.getUserByLogin(login);
            if(user!=null){
                request.setAttribute("message",new Message("The login is already used", MessageTypes.WARNING));
                getServletContext().getRequestDispatcher("/WEB-INF/vues/RegisterPage.jsp").forward(request,response);
                return;
            }

            user = new User(fname,lname,login,password,0);
            gameData.setUser(user);
            request.setAttribute("message",new Message("Welcome,please login", MessageTypes.INFO));
            getServletContext().getRequestDispatcher("/WEB-INF/vues/LoginPage.jsp").forward(request,response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/vues/RegisterPage.jsp").forward(request,response);
    }
}
