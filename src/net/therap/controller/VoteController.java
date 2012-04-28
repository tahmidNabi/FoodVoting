package net.therap.controller;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/23/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */

import net.therap.domain.Food;
import net.therap.domain.User;
import net.therap.service.FoodService;
import net.therap.service.FoodServiceImpl;
import net.therap.service.VoteService;
import net.therap.service.VoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

public class VoteController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(VoteController.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("USER") == null) {
            log.debug("user is not logged in");
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
        } else {

            User user = (User) session.getAttribute("USER");

            Enumeration<String> foodTypeList = request.getParameterNames();
            List<String> foodNameList = new ArrayList<String>();

            VoteService voteService = new VoteServiceImpl();
            String message1 = "Your vote for the category of ";
            String message2 = "You have already voted for ";

            int categoryCount = 0;
            int voteCount = 0;
            int errorCount = 0;


            while (foodTypeList.hasMoreElements()) {


                String foodType = foodTypeList.nextElement();
                String foodName = request.getParameter(foodType);
                ++categoryCount;
                log.debug(foodType);


                if (!voteService.hasAlreadyVoted(user.getUserName(), foodType)) {
                    message1 += "\"" + foodType + "\" , ";
                    voteService.updateVoteCount(foodName);
                    voteService.insertTodaysVote(user.getUserName(), foodType, foodName);


                    ++voteCount;
                } else {

                    message2 += "\"" + foodType + "\" , ";
                    ++errorCount;


                }


            }
            message1 = message1.substring(0, message1.length() - 2);
            message2 = message2.substring(0, message2.length() - 2);
            message2 += ".";

            message1 += " has been received. ";

            if (categoryCount == voteCount) {
                message2 = "";
            }
            if (errorCount == categoryCount) {
                message1 = "";
            }
            if (categoryCount != 0) {

                request.setAttribute("successMessage", message1);
                request.setAttribute("errorMessage", message2);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VoteSuccess.jsp");
                rd.forward(request, response);
            }
            else {
                FoodService foodService = new FoodServiceImpl();

                Map<String, List<Food>> foodMap = foodService.getFoodMap();
                request.setAttribute("foodMap", foodMap);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Vote.jsp");
                rd.forward(request, response);
            }


        }
    }
}
