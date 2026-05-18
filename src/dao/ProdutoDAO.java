package dao;

import db.DB;
import model.entites.Produto;
import model.entites.Restaurante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    public void insert(Produto produto){

        String sql = "INSERT INTO produto "
                + "(nome, descricao, preco, categoria, restaurante_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        try(Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setObject(5, produto.getRestaurante().getId());

            ps.executeUpdate();

            System.out.println("Produto salvo no banco.");
        }
        catch(SQLException e){
            System.out.println("Erro ao inserir produto.");
            e.printStackTrace();
        }
    }

    public void update(Produto produto){

        String sql =
                "UPDATE restaurante " +
                        "SET nome = ?, " +
                        "descricao = ?, " +
                        "preco = ?, " +
                        "categoria = ?, " +
                        "restaurante_id = ? " +
                        "WHERE id = ?";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getCategoria());
            ps.setObject(5, produto.getRestaurante().getId());
            ps.setInt(6, produto.getId());
            int linhasAfetadas = ps.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Produto atualizado com sucesso.");
            }
            else{
                System.out.println("Nenhum produto encontrado.");
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    public List<Produto> listar(){

        List<Produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try(
                Connection conn = DB.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ){

            while(rs.next()){
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setCategoria(rs.getString("categoria"));

                Restaurante restaurante = new Restaurante();
                restaurante.setId(rs.getInt("restaurante_id"));

                lista.add(produto);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao listar produtos.");
            e.printStackTrace();
        }
        return lista;
    }

    public Produto findById(Integer id){

        String sql =
                "SELECT * FROM produto " +
                        "WHERE id = ?";

        try(
                Connection conn = DB.getConnection();

                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ){

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                Produto produto = new Produto();

                produto.setId(
                        rs.getInt("id")
                );

                produto.setNome(
                        rs.getString("nome")
                );

                produto.setDescricao(
                        rs.getString("descricao")
                );

                produto.setPreco(
                        rs.getDouble("preco")
                );

                produto.setCategoria(
                        rs.getString("categoria")
                );

                Restaurante restaurante = new Restaurante();
                restaurante.setId(
                        rs.getInt("restaurante_id")
                );

                return produto;
            }

        }
        catch(SQLException e){

            System.out.println(
                    "Erro ao buscar produto."
            );
        }

        return null;
    }

    public void deleteById(Integer id){

        String sql =
                "DELETE FROM produto " +
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
                        "Produto removido com sucesso."
                );
            }
            else{

                System.out.println(
                        "Produto não encontrado."
                );
            }

        }
        catch(SQLException e){

            System.out.println(
                    "Erro ao remover produto: "
                            + e.getMessage()
            );
        }
    }
}
