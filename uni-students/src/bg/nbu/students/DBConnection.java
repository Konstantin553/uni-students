package bg.nbu.students;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection connect;
    public static Connection createDBConnection(){
        try{
            //зареждаме driver класа
            Class.forName("com.mysql.cj.jdbc.Driver");
            //URL връзка
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "*********";
            connect = DriverManager.getConnection(url, username, password);
        } catch(Exception ex) {
                ex.printStackTrace();
        }

        return connect;
    }
}
