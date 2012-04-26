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
    public void vote(String [] foodNameList);

    public boolean hasAlreadyVoted(String userName);

    public void insertVote(String userName);
}
