package net.therap.service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface VoteService {
    public void updateVoteCount(String foodName);

    public boolean hasAlreadyVoted(String userName, String type);

    public void insertTodaysVote(String userName, String type, String foodName);
}
