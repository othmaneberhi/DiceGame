package com.ensah.dicegame.bo;

public class User {
    private String fname;
    private String lname;
    private String login;

    private String password;


    private double bestScore;

    @Override
    public String toString() {
        return "User{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", bestScore=" + bestScore +
                '}';
    }


    public User(String fname, String lname, String login, String password, double bestScore) {
        this.fname = fname;
        this.lname = lname;
        this.login = login;
        this.password = password;
        this.bestScore = bestScore;
    }

    public User(String fname, String lname, String login, double bestScore) {
        this.fname = fname;
        this.lname = lname;
        this.login = login;
        this.bestScore = bestScore;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBestScore() {
        return bestScore;
    }

    public void setBestScore(double bestScore) {
        this.bestScore = bestScore;
    }


}
