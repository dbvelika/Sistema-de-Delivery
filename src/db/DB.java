package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/bddelivery";

    private static final String USER = "postgres";

    private static final String PASSWORD = "root";

    public static Connection getConnection(){

        try{
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        }
        catch(SQLException e){
            throw new RuntimeException(
                    "Erro ao conectar ao banco."
            );
        }
    }
}
