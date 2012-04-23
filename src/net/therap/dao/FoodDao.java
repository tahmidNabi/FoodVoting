package net.therap.dao;

import net.therap.domain.Food;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodDao {
     DatabaseTemplate dbTemplate;



    public List<Food> getFoodList() {
        dbTemplate = DatabaseTemplate.getDatabaseTemplate();

        List<Food> foodList = new ArrayList<Food>();

        foodList = dbTemplate.queryForObject("select * from saima_tahmid_food", new RowObjectMapper<Food>() {
            public Food mapRowToObject(ResultSet resultSet) {
                Food food = new Food();

                String foodName;
                int voteCount;

                try {
                    foodName = resultSet.getString("name");
                    voteCount = resultSet.getInt("votecount");


                    food.setFoodName(foodName);
                    food.setVoteCount(voteCount);


                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return food;


            }
        });


        return foodList;

    }

    public void updateVoteCount(String name) {

        dbTemplate = DatabaseTemplate.getDatabaseTemplate();

        dbTemplate.executeQuery("update saima_tahmid_food set votecount = votecount + 1 where name = ?", name);


    }
}
