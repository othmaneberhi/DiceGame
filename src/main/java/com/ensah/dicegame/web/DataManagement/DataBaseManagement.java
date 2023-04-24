package com.ensah.dicegame.web.DataManagement;

import com.ensah.dicegame.bo.User;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseManagement implements IDataManagement{
    private static DataBaseManagement instance;
    private String connexionString = "jdbc:mariadb://localhost:3306/dice_game?user=root&password=";

    private DataBaseManagement(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (Exception e) {
            //throw new GameException(e);
        }
    }
    synchronized public static final DataBaseManagement getInstance(){
        if (instance==null){
            instance=new DataBaseManagement();
        }
        return instance;
    }


    @Override
    public ArrayList<User> getUsers() {
        Connection connection = null;
        ArrayList<User> usersList = new ArrayList<User>();
        try {
            connection = DriverManager.getConnection(this.connexionString);
            try {
                Statement st = connection.createStatement();
                ResultSet rs = st.executeQuery("select fname,lname,login,bestScore from Users");
                while (rs.next()){
                    User user = new User(rs.getString("fname"), rs.getString("lname")
                            ,rs.getString("login"), rs.getDouble("bestScore")
                    );
                    usersList.add(user);
                }

            }
            finally {
                if(connection!=null){
                    connection.close();
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        return usersList;
    }

    @Override
    public User getUserByLogin(String login) {
        Connection con = null;
        ArrayList<User> usersList=new ArrayList<>();
        try {
            con = DriverManager.getConnection(this.connexionString);
            try{
                PreparedStatement pstmt = con.prepareStatement("select * from Users where login =?");
                pstmt.setString(1, login);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    User user = new User(rs.getString("fname"),rs.getString("lname"),rs.getString("login"),
                                rs.getString("password"),rs.getDouble("bestScore"));

                    usersList.add(user);
                }
            }
            finally {
                if(con!=null){
                    con.close();
                }
            }
        }catch(SQLException e){
            //
        }
        if(!usersList.isEmpty()){
            return usersList.get(0);
        }
        return null;
    }

    @Override
    public void setUser(User user) {
        Connection con = null;
        try{
            con = DriverManager.getConnection(connexionString);
            try{
                PreparedStatement pstmt = con.prepareStatement("INSERT INTO Users(fname,lname,login,password,bestScore) VALUES (?,?,?,?,?)");
                pstmt.setString(1,user.getFname());
                pstmt.setString(2,user.getLname());
                pstmt.setString(3,user.getLogin());
                pstmt.setString(4,user.getPassword());
                pstmt.setDouble(5,user.getBestScore());
                pstmt.executeUpdate();
            }
            finally {
                if(con!=null){
                    con.close();
                }
            }

        }
        catch (SQLException e){
            //
        }
    }

    @Override
    public void updateBestScore(User user) {
        Connection con =null;
        try {
            con=DriverManager.getConnection(connexionString);
            try{
                PreparedStatement pstmt = con.prepareStatement("UPDATE users SET bestScore=? WHERE login=?");
                pstmt.setDouble(1,user.getBestScore());
                pstmt.setString(2,user.getLogin());

                pstmt.executeUpdate();
            }
            finally {
                if(con!=null){
                    con.close();
                }
            }
        }

        catch(SQLException e){
            //
        }
    }
}
