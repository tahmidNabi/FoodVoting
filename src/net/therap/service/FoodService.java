package net.therap.service;

import net.therap.domain.Food;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FoodService {
    List<Food> populateFoodList();

    List<String> getFoodNames();

    List<Integer> getVotes();

}
