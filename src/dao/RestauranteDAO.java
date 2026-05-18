package dao;

import db.DB;
import model.entites.Restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RestauranteDAO {
    public void inserir(Restaurante restaurante){

        String sql =
                "INSERT INTO restaurante " +
                        "(nome, endereco, cnpj, telefone, categoria) " +
                        "VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql)){

            ps.setString(1, restaurante.getNome());
            ps.setString(2, restaurante.getEndereco());
            ps.setString(3, restaurante.getCnpj());
            ps.setString(4, restaurante.getTelefone());
            ps.setString(5, restaurante.getCategoria());

            ps.executeUpdate();

            System.out.println(
                    "Restaurante salvo no banco."
            );
        }
        catch(SQLException e){
            System.out.println(
                    "Erro ao inserir restaurante."
            );
        }
    }
}
