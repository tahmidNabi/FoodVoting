package net.therap.dao;

import java.sql.ResultSet;

/**
 * Created by IntelliJ IDEA.
 * User: tahmid
 * Date: 4/22/12
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
interface RowObjectMapper<E> {

     E mapRowToObject(ResultSet resultSet);
}
