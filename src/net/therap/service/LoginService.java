package net.therap.service;

import net.therap.domain.User;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */
public interface LoginService {
    User checkUser(String userName, String passWord);
}
