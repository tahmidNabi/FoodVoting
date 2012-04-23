package net.therap.controller;

import net.therap.domain.Food;
import net.therap.domain.User;
import net.therap.service.FoodService;
import net.therap.service.FoodServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class UserController extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("USER") == null) {
            log.debug("user is not logged in");
            RequestDispatcher rd = request.getRequestDispatcher("//login.jsp");
            rd.forward(request, response);
        } else {
            User user = (User) session.getAttribute("USER");

            FoodService foodService = new FoodServiceImpl();

            List<String> foodNames = foodService.getFoodNames();
            request.setAttribute("foodNames", foodNames);

            if (user.getType().equals("U")) {

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Vote.jsp");
                rd.forward(request, response);

            } else if (user.getType().equals("A")) {

                //List<Integer> Votes = foodService.getVotes();
                List<Food> foodList = foodService.populateFoodList();
                request.setAttribute("foodList",foodList);
                //request.setAttribute("Votes", Votes);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Results.jsp");
                rd.forward(request, response);
            }


        }


    }


}
