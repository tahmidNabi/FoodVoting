package net.therap.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 4/9/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
class DatabaseTemplate {
    private static final Logger log = LoggerFactory.getLogger(DatabaseTemplate.class);
    Connection connection;
    static DatabaseTemplate dbTemplate = null;

    public static DatabaseTemplate getDatabaseTemplate() {

        if (dbTemplate == null) {
            dbTemplate = new DatabaseTemplate();
        }

        return dbTemplate;


    }

    Connection openConnection() {
         Context initContext = null;
         try {
             initContext = new InitialContext();
             Context envCtx = (Context) initContext.lookup("java:comp/env");
             DataSource ds = (DataSource) envCtx.lookup("jdbc/myoracle");
             connection = ds.getConnection();

         } catch (NamingException e) {
             log.debug(e.toString());
         } catch (SQLException e) {
             log.debug(e.toString());  //To change body of catch statement use File | Settings | File Templates.
         }

        return connection;
    }


        void execute(String query) {
            openConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
            }
            catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            }catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }


        }
    }

    <E> List<E> queryForObject(String query, RowObjectMapper<E> rowObjectMapper) {
        openConnection();
        Statement stmt = null;
        ResultSet resultSet = null;
        List<E> listOfE = new ArrayList<E>();
        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                listOfE.add(rowObjectMapper.mapRowToObject(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                resultSet.close();
                stmt.close();
            }
            catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            }catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }



        }
        return listOfE;
    }

    void executeQuery(String query, Object... parameters) {
        Connection connection = openConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(i, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(i, (Integer) parameter);
                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(i, (Long) parameter);
                }
                i++;
            }

            preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {

                preparedStatement.close();
            } catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            } catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }
        }
    }

    void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
