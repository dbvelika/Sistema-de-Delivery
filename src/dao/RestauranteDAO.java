package dao;

import db.DB;
import model.entites.Restaurante;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestauranteDAO {
    public void inserir(Restaurante restaurante){

        String sql = "INSERT INTO restaurante " + "(nome, endereco, cnpj, telefone, categoria) " + "VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, restaurante.getNome());
            ps.setString(2, restaurante.getEndereco());
            ps.setString(3, restaurante.getCnpj());
            ps.setString(4, restaurante.getTelefone());
            ps.setString(5, restaurante.getCategoria());

            ps.executeUpdate();

            System.out.println("Restaurante salvo no banco.");
        }
        catch(SQLException e){
            System.out.println("Erro ao inserir restaurante.");
            e.printStackTrace();
        }
    }

    public void update(Restaurante restaurante){

        String sql =
                "UPDATE restaurante " +
                        "SET nome = ?, " +
                        "endereco = ?, " +
                        "cnpj = ?, " +
                        "telefone = ?, " +
                        "categoria = ? " +
                        "WHERE id = ?";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, restaurante.getNome());
            ps.setString(2, restaurante.getEndereco());
            ps.setString(3, restaurante.getCnpj());
            ps.setString(4, restaurante.getTelefone());
            ps.setString(5, restaurante.getCategoria());
            ps.setInt(6, restaurante.getId());
            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Restaurante atualizado com sucesso.");
            }
            else{
                System.out.println("Nenhum restaurante encontrado.");
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao atualizar restaurante: " + e.getMessage());
        }
    }

    public List<Restaurante> listar(){

        List<Restaurante> lista = new ArrayList<>();

        String sql = "SELECT * FROM restaurante";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){

                Restaurante restaurante = new Restaurante();

                restaurante.setId(rs.getInt("id"));
                restaurante.setNome(rs.getString("nome"));
                restaurante.setEndereco(rs.getString("endereco"));
                restaurante.setCnpj(rs.getString("cnpj"));
                restaurante.setTelefone(rs.getString("telefone"));
                restaurante.setCategoria(rs.getString("categoria"));

                lista.add(restaurante);
            }
        }
        catch(SQLException e){

            System.out.println(
                    "Erro ao listar restaurantes."
            );

            e.printStackTrace();
        }

        return lista;
    }

    public Restaurante findById(Integer id){

        String sql =
                "SELECT * FROM restaurante " +
                        "WHERE id = ?";

        try(
                Connection conn = DB.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Restaurante restaurante =
                        new Restaurante();

                restaurante.setId(
                        rs.getInt("id")
                );

                restaurante.setNome(
                        rs.getString("nome")
                );

                restaurante.setEndereco(
                        rs.getString("endereco")
                );

                restaurante.setCnpj(
                        rs.getString("cnpj")
                );

                restaurante.setTelefone(
                        rs.getString("telefone")
                );

                restaurante.setCategoria(
                        rs.getString("categoria")
                );

                return restaurante;
            }

        }
        catch(SQLException e){

            System.out.println(
                    "Erro ao buscar restaurante."
            );
        }

        return null;
    }

    public void deleteById(Integer id){

        String sql =
                "DELETE FROM restaurante " +
                        "WHERE id = ?";

        try(
                Connection conn = DB.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            int linhasAfetadas =
                    ps.executeUpdate();

            if(linhasAfetadas > 0){

                System.out.println(
                        "Restaurante removido com sucesso."
                );
            }
            else{

                System.out.println(
                        "Restaurante não encontrado."
                );
            }

        }
        catch(SQLException e){

            System.out.println(
                    "Erro ao remover restaurante: "
                            + e.getMessage()
            );
        }
    }
}
