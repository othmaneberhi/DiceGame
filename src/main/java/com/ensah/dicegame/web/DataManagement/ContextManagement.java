package com.ensah.dicegame.web.DataManagement;

import com.ensah.dicegame.bo.User;
import jakarta.servlet.ServletContext;

import java.util.ArrayList;

public class ContextManagement implements IDataManagement{
    private ServletContext ctx;
    private static ContextManagement instance;
    private ContextManagement(ServletContext ctx){
        this.ctx=ctx;
        this.ctx.setAttribute("users",new ArrayList<User>());
    }
    synchronized public static final ContextManagement getInstance(ServletContext ctx){
        if(instance == null){
            instance = new ContextManagement(ctx);
        }
        return instance;

    }

    @Override
    public ArrayList<User> getUsers() {
        return (ArrayList<User>) this.ctx.getAttribute("users");
    }

    @Override
    public User getUserByLogin(String login) {
        ArrayList<User> allUsers = this.getUsers();
        for (User user: allUsers) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void setUser(User user) {
        ArrayList<User> allUsers = this.getUsers();
        allUsers.add(user);
    }

    @Override
    public void updateBestScore(User user) {
        ArrayList<User> allUsers = this.getUsers();
        for (User userIt: allUsers) {
            if(userIt.getLogin().equals(user.getLogin())){
                userIt.setBestScore(user.getBestScore());
            }
        }
    }
}
