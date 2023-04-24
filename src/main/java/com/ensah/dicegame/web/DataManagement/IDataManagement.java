package com.ensah.dicegame.web.DataManagement;

import com.ensah.dicegame.bo.User;

import java.util.ArrayList;

public interface IDataManagement {
    public ArrayList<User> getUsers();
    public User getUserByLogin(String login);

    public void setUser(User user);


    void updateBestScore(User user);
}
