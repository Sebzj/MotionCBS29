package motioncbs.server;

import motioncbs.shared.User;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import motioncbs.client.rpc.MotionCBSService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class MotionCBSServiceImpl extends RemoteServiceServlet implements MotionCBSService {

    // Implementation of sample interface method
    /*
     * The url, username and password for the database. The password is not necessarily
     * the same pass as your computer password
     */
    private static final String URL = "jdbc:mysql://localhost:3306/data?useSSL=false";
    private static final String USERNAME = "newuser";
    private static final String PASSWORD = "zard8238473mwe";
    private static Connection connection = null;



    /**
     * The constructor which is creating the connection the the database
     */
    public MotionCBSServiceImpl() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * A method which is used for closing the connection
     */
    private static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Just a simple method which is used to test client server connection
     */

    @Override
    public void test() throws IllegalArgumentException {
        System.out.println("Server/Client connection is fine");
    }


    /**
     * This method is used for the login by authorizing the username and password in the database
     */
    @Override
    public User authorizeUser(String username, String password) throws IllegalArgumentException {
        // By making a SELECT/executeQuery to the database the data will presented/saved in a ResultSet
        ResultSet resultSet = null;
        User user = null;

        // Using a catch since a query to the database can fail
        try {

            /*
             * The PreparedStatement which is used to make authorize a user.
             * This statement will return all users which both have a specific username and password in combination
             * The username and password is set later in this method
             */
            PreparedStatement authorizeUser = connection
                    .prepareStatement("SELECT * FROM users where username = ? AND password = ?");
            /*
             * In the next two lines the username and password is set.
             * The 1 is referring to the first question mark and the 2 is referring to the second question mark
             */
            authorizeUser.setString(1, username);
            authorizeUser.setString(2, password);

            // The PreparedStatement is executed and data is loaded into a resultSet
            resultSet = authorizeUser.executeQuery();

            // This loop will create and set a user if anyone found and there by returned in the resultSet
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setCustomertype(resultSet.getInt("customertype"));


            }
            // The catch which is used if either the statement or connection is failing
        } catch (SQLException e) {
            e.printStackTrace();
            // A finally try catch which closes the result set and it can't then close the db connection
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }
        return user;
    }






    /**
     * This method is changing a specific users info in the database
     */
    @Override
    public void changeUserInfo(User user ) throws IllegalArgumentException {
        try {
            // Look at the previous method
            PreparedStatement updateUser = connection.prepareStatement("UPDATE Users SET firstname = ?, lastname = ?, age = ?, username = ?, password = ?, gender=?, customertype = ? where id = ?");


            updateUser.setString(1, user.getFirstName());

            updateUser.setString(2, user.getLastName());

            updateUser.setInt(3, user.getAge());

            updateUser.setString(4,user.getUsername());

            updateUser.setString(5, user.getPassword());

            updateUser.setString(6, user.getGender() + "");

            updateUser.setInt(7, user.getCustomertype());

            updateUser.setInt(8, user.getId());


            updateUser.executeUpdate();


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    @Override
    public User getCurrentUser(int userId) throws IllegalArgumentException {
        ResultSet resultSet = null;
         User currentUser = new User();

        try {
            // Same concept as getMessages method except there is no join in this statement
            PreparedStatement getCurrentUser = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            getCurrentUser.setInt(1, userId);
            resultSet = getCurrentUser.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setCustomertype(resultSet.getInt("customertype"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }
        return currentUser;
    }





    /**
     * This message is getting all the users from the database
     */
    @Override
    public ArrayList<User> getUsers(int userId) throws IllegalArgumentException {
        ResultSet resultSet = null;
        ArrayList<User> users = new ArrayList<>();

        try {
            // Same concept as getMessages method except there is no join in this statement
            PreparedStatement getUsers = connection.prepareStatement("SELECT * FROM users WHERE customertype != 4");
            //getUsers.setInt(1, userId);
            resultSet = getUsers.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setGender(resultSet.getString("gender"));
                user.setCustomertype(resultSet.getInt("customertype"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }
        return users;
    }

    /**
     * This method is creating a new user in the database
     */
    @Override
    public boolean createUser(User user) throws IllegalArgumentException {
        try {
            // Same concept as createMessage method
            PreparedStatement createUser = connection
                    .prepareStatement("INSERT INTO users (username, password) VALUES (?,?)");

            createUser.setString(1, user.getUsername());
            createUser.setString(2, user.getPassword());

            int rowsAffected = createUser.executeUpdate();
            if (rowsAffected == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * This method is deleting a specific user in the database
     */
    @Override
    public boolean deleteUser(int userId) throws IllegalArgumentException {
        try {
            /*
             * This statement is deleting a row/rows in the users table by id. There should only be on user with a id
             * since this should be unique
             */
            PreparedStatement deleteUser = connection.prepareStatement("DELETE FROM users WHERE id = ?");

            deleteUser.setInt(1, userId);

            int rowsAffected = deleteUser.executeUpdate();

            if (rowsAffected == 1) {
                return true;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    }
