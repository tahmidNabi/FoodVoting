package net.therap.domain;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Food implements Comparable<Food>{
    private String foodName;
    private int voteCount;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int compareTo(Food b) {

        if (this.getVoteCount()<b.getVoteCount()) {
            return 1;
        }
        else if (this.getVoteCount()==b.getVoteCount()) {
            return 0;
        }
        else {
            return -1;
        }

    }



}
