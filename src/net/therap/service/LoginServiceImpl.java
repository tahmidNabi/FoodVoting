package net.therap.service;

import net.therap.dao.LoginDao;
import net.therap.domain.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginServiceImpl implements LoginService {


    public User checkUser(String userName, String passWord) {

        LoginDao loginDao = new LoginDao();

        List<User> userList = loginDao.getUserList();


        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(passWord)) {
                return user;
            }


        }

        return null;



    }
}
