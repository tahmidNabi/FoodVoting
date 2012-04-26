package net.therap.controller;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/23/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */

import net.therap.domain.User;
import net.therap.service.VoteService;
import net.therap.service.VoteServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

            String[] foodNameList = request.getParameterValues("foodNames");

            VoteService voteService = new VoteServiceImpl();


            if (!voteService.hasAlreadyVoted(user.getUserName())) {
                voteService.vote(foodNameList);
                voteService.insertVote(user.getUserName());
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VoteSuccess.jsp");
                rd.forward(request, response);
            }
            else {
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VoteError.jsp");
                rd.forward(request, response);

            }


        }
    }
}
