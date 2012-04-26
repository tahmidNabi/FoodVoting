package net.therap.service;

import net.therap.dao.FoodDao;
import net.therap.dao.VoteDao;
import net.therap.domain.Vote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 4:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class VoteServiceImpl implements VoteService {

    private static final Logger log = LoggerFactory.getLogger(VoteServiceImpl.class);

    public void vote(String [] foodNameList) {

        FoodDao foodDao = new FoodDao();

        for (String foodName : foodNameList) {
             foodDao.updateVoteCount(foodName);
        }

    }

    public boolean hasAlreadyVoted(String userName) {
        VoteDao voteDao = new VoteDao();


        List<Vote> votes = voteDao.getVoteList();

        for (Vote vote: votes) {
            if (vote.getName().equals(userName)) {
                java.util.Date today = new java.util.Date();
                java.sql.Date curDate = new java.sql.Date(today.getTime());

                java.sql.Date voteDate = new java.sql.Date(vote.getDate().getTime());

                //log.debug("From table: " + curDate.getYear() + " " + voteDate.getYear());
                //log.debug("From system " + voteDate);

                if (curDate.getYear()==voteDate.getYear() && curDate.getMonth()==voteDate.getMonth() && curDate.getDay()==voteDate.getDay()) {
                    log.debug("Found equal");
                    return true;
                }


            }
        }
        return false;




    }

    public void insertVote(String userName) {

        VoteDao voteDao = new VoteDao();

        voteDao.insertVote(userName);

    }
}
