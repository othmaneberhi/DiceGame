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
import java.util.Random;

@WebServlet(name = "playServlet", value = "/secure/play")
public class playServlet extends HttpServlet {

    protected State play(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //getting the game states
        State gameState  = (State) request.getSession().getAttribute("gameState");
        if(request.getParameter("dice")!=null){
            Random random = new Random();
            Integer dice = Integer.valueOf(request.getParameter("dice"));
            HashMap<Integer,Integer> launchedDices = gameState.getLaunchedDices();

            if(gameState.isGameOver()){
                request.setAttribute("message",new Message("GAME OVER !", MessageTypes.INFO));
                return gameState;

            }

            if(launchedDices.containsKey(dice)){
                request.setAttribute("message",new Message("Game over, dice already launched", MessageTypes.INFO));
                gameState.setScore(0);
                gameState.setGameOver(true);
                return gameState;
            }

            int value = random.nextInt(6) + 1;


            if(launchedDices.containsValue(value)){
                gameState.setScore(0);
                gameState.setGameOver(true);
                request.setAttribute("message",new Message("The round is finished", MessageTypes.INFO));
                return gameState;
            }
            launchedDices.put(dice,value);
            if(launchedDices.get(2)!=null && (launchedDices.get(2)==6 || launchedDices.get(2)==1)){
                gameState.setScore(0);
                gameState.setGameOver(true);
                request.setAttribute("message",new Message("The round is finished", MessageTypes.INFO));
                return gameState;
            }

            if(launchedDices.size()==3){
                if(launchedDices.get(1)<launchedDices.get(2) && launchedDices.get(2)<launchedDices.get(3)){
                    gameState.setScore(launchedDices.get(1)*launchedDices.get(2)*launchedDices.get(3));
                }
                else if (launchedDices.get(1)>launchedDices.get(2) && launchedDices.get(2)>launchedDices.get(3)) {
                    gameState.setScore(launchedDices.get(1)+launchedDices.get(2)+launchedDices.get(3));
                }
                else{
                    gameState.setScore(0);
                }
                gameState.setGameOver(true);
                request.setAttribute("message",new Message("The round is finished", MessageTypes.INFO));

                return gameState;
            }

        }
        return gameState;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        State gameState  = play(request,response);
        IDataManagement gameData = (IDataManagement) getServletContext().getAttribute("gameData");
        //updating the gameState in the session
        request.getSession().setAttribute("gameState",gameState);
        //updating the best score
        if(gameState.getScore()>user.getBestScore()){
            user.setBestScore(gameState.getScore());
            request.getSession().setAttribute("user",user);
            gameData.updateBestScore(user);
            request.setAttribute("message",new Message("Congratulations on your new best score!", MessageTypes.SUCCESS));
        }

        getServletContext().getRequestDispatcher("/WEB-INF/vues/PlayPage.jsp").forward(request,response);
    }
}
