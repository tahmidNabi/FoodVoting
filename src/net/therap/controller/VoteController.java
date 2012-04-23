package net.therap.controller;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/23/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
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
import java.util.List;

public class VoteController  extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(VoteController.class);

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("USER") == null) {
            log.debug("user is not logged in");
            RequestDispatcher rd = request.getRequestDispatcher("/login");
            rd.forward(request, response);
        } else {

            String [] foodNameList = request.getParameterValues("foodNames");

            VoteService voteService = new VoteServiceImpl();

            voteService.vote(foodNameList);





        }
    }
}
