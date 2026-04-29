import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bddelivery",
                "root",
                "senha"
            );

            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}