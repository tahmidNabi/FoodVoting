package net.therap.service;

import net.therap.dao.FoodDao;
import net.therap.domain.Food;

import java.util.*;

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

    public List<String> getFoodNames() {

        List<Food> foodList = populateFoodList();
        List<String> foodNames = new ArrayList<String>();

        for (Food food : foodList) {
            foodNames.add(food.getFoodName());

        }

        return foodNames;

    }

    public List<Integer> getVotes() {

        List<Food> foodList = populateFoodList();
        List<Integer> Votes = new ArrayList<Integer>();

        for (Food food : foodList) {
            Votes.add(food.getVoteCount());

        }

        return Votes;

    }

    public Set<String> getType(List<Food> foodList) {

        Set<String> foodTypes = new HashSet<String>();

        for (Food food : foodList) {

            foodTypes.add(food.getType());

        }


        return foodTypes;

    }

    public List<Food> getFoodListByType(List<Food> foodList, String type) {
        List<Food> foods = new ArrayList<Food>();

        for (Food food : foodList)  {
            if (food.getType().equals(type)) {
                foods.add(food);
            }
        }

        Collections.sort(foods);

        return foods;
    }

    public Map<String, List<Food>> getFoodMap () {
        Map<String, List<Food>> foodMap = new HashMap<String, List<Food>>();

        List<Food> foodList = populateFoodList();

        Set<String> foodTypes = getType(foodList);

        for (String type : foodTypes) {
            List<Food> foodNameByType = getFoodListByType(foodList,type);

            foodMap.put(type, foodNameByType);

        }


        return foodMap;


    }
}
