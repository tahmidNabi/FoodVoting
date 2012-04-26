package net.therap.domain;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/25/12
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Vote {
    private String name;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
