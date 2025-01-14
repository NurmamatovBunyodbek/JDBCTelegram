package uz.bunyodbek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyDatabase {

    String urlDatabase = "jdbc:postgresql://localhost:5432/sinf11a23";
    String usernameDatabase = "postgres";
    String password = "root";


    public void create(User user) {

        try {
            Connection connection = DriverManager.getConnection(urlDatabase, usernameDatabase, password);

            Statement statement = connection.createStatement();

            String query = "insert into message(chatid , text) values (" + user.getId() + ", '" + user.getText() + "');";

            statement.execute(query);
            System.out.println("Message created");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void read(User user) {

        try {
            Connection connection = DriverManager.getConnection(urlDatabase, usernameDatabase, password);

            Statement statement = connection.createStatement();
            String query = "select * from message where chatid = '" + user.getId() + "';";

            statement.executeQuery(query);
            System.out.println("Message read");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(User user) {
        try {
            Connection connection = DriverManager.getConnection(urlDatabase, usernameDatabase, password);

            Statement statement = connection.createStatement();

            String query = "update message set text = '" + user.getText() + "' where chatid = '" + user.getId() + "';";

            statement.executeUpdate(query);
            System.out.println("Message updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(User user) {

        try {
            Connection connection = DriverManager.getConnection(urlDatabase, usernameDatabase, password);

            Statement statement = connection.createStatement();

            String query = "delete from message where chatid = '" + user.getId() + "';";

            statement.executeUpdate(query);
            System.out.println("Message deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
