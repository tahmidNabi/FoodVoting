package net.therap.service;

import net.therap.dao.FoodDao;
import net.therap.domain.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 4:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class FoodServiceImpl implements FoodService {

    public List<Food> populateFoodList() {
        FoodDao foodDao = new FoodDao();

        return foodDao.getFoodList();


    }

    public List<String> getFoodNames () {

        List<Food> foodList = populateFoodList();
        List<String> foodNames = new ArrayList<String>();

        for (Food food : foodList) {
            foodNames.add(food.getFoodName());

        }

        return foodNames;

    }

    public List<Integer> getVotes () {

        List<Food> foodList = populateFoodList();
        List<Integer> Votes = new ArrayList<Integer>();

        for (Food food : foodList) {
            Votes.add(food.getVoteCount());

        }

        return Votes;

    }
}
