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

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
