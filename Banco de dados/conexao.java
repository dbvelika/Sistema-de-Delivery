import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/bddelivery",
                "postgres",   // usuário padrão do PostgreSQL
                "root"       // sua senha
            );

            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
