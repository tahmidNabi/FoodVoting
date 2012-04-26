package net.therap.dao;

import net.therap.domain.User;
import net.therap.domain.Vote;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/25/12
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class VoteDao {
    DatabaseTemplate dbTemplate;

    public List<Vote> getVoteList() {
        dbTemplate = DatabaseTemplate.getDatabaseTemplate();

        List<Vote> voteList = new ArrayList<Vote>();

        voteList = dbTemplate.queryForObject("select * from saima_tahmid_vote", new RowObjectMapper<Vote>() {
            public Vote mapRowToObject(ResultSet resultSet) {
                Vote vote = new Vote();

                String name;
                Date date;

                try {
                    name = resultSet.getString("name");
                    date = resultSet.getDate("vote_date");



                    vote.setName(name);
                    vote.setDate(date);



                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return vote;


            }
        });


        return voteList;

    }

     public void insertVote(String name) {

        dbTemplate = DatabaseTemplate.getDatabaseTemplate();

        java.util.Date today = new java.util.Date();
        java.sql.Date curDate = new java.sql.Date(today.getTime());

        dbTemplate.executeQuery("insert into saima_tahmid_vote values (?,?)", name, curDate);


    }


}
