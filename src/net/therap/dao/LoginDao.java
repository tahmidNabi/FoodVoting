package net.therap.dao;

import net.therap.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginDao {
    static DatabaseTemplate dbTemplate;


    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();

        userList = dbTemplate.queryForObject("select * from saima_tahmid_user", new RowObjectMapper<User>() {
            public User mapRowToObject(ResultSet resultSet) {
                User user = new User();

                String name;
                String password;
                String type;

                try {
                    name = resultSet.getString("name");
                    password = resultSet.getString("password");
                    type = resultSet.getString("type");


                    user.setUserName(name);
                    user.setPassword(password);
                    user.setType(type);


                } catch (SQLException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

                return user;


            }
        });


        return userList;

    }


}
