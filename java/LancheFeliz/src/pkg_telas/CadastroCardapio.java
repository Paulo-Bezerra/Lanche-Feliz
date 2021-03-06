package pkg_telas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161134010020
 */
public class CadastroCardapio extends Conexao {
    
    
    public void CadastrarProduto(String nome, String descricao){
        String sql = "INSERT INTO  cardapio (id, nome, descricao) VALUES (DEFAULT, ?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, nome);
            estado1.setString(2,descricao);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }
    }
    
    public void AtualizarProduto ( String nome, String data_validade, String tipo, int idCategoria, int id_Cardapio){
        String sql = "UPDATE cardapio SET nome = ?, data_validade = ?, tipo = ?, idCategoria = ? WHERE idProduto = ?";
        PreparedStatement estado1;
        conectar();
        
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, nome);
            estado1.setString(2, data_validade);
            estado1.setString(3, tipo);
            estado1.setInt(4, idCategoria);
            estado1.setInt(5, id_Cardapio);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        }
    }
    
    public void RemoverProduto(int id_Cardapio){
        String sql = "DELETE FROM cardapio WHERE idProduto = ?";
        PreparedStatement estado1;
        conectar();
        
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setInt(1, id_Cardapio);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover");
        }
    }
    
    public ArrayList <Cardapio> ConsultaCardapio(){
        ArrayList <Cardapio> lista = new ArrayList();
        String sql = "SELECT * FROM cardapio";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Cardapio c = new Cardapio();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setDescricao(resultado.getString("descricao"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta");
        }
        return lista;
    }
    
    public ArrayList <CardapioSemanal> GerarCardapio(){
        ArrayList <CardapioSemanal> lista = new ArrayList();
        String sql = "SELECT cardapio.id, cardapio.nome, selecao.quantidade "
                   + "FROM cardapio, (SELECT id, COUNT(id) AS quantidade FROM cliente INNER JOIN cardapio "
                   + "ON cardapio.id = cliente.id_cardapio GROUP BY id ORDER BY COUNT(id) DESC LIMIT  5) AS selecao "
                   + "WHERE cardapio.id = selecao.id";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                CardapioSemanal c = new CardapioSemanal();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                c.setQuantidade(resultado.getInt("quantidade"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta");
        }
        return lista;
    }
    
    public ArrayList <Integer> CardapioAtivos() {
        ArrayList <Integer> ids = new ArrayList();
        String sql = "SELECT id FROM cardapio";
        ResultSet resultado;
        
        conectar();
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()) {
                int id;
                id = resultado.getInt("id");
                ids.add(id);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        
        return ids;
    } 
    
        public int ultimoCardapio(){
        int id = 0;
        String sql = "SELECT id FROM cardapio";
        ResultSet resultado;
        
        conectar();
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()) {
                
                id = resultado.getInt("id");
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar");
        }
        
        return id;
    } 
        
        public ArrayList <Cardapio> BuscarCardapio(String var){
        ArrayList <Cardapio> lista = new ArrayList();
        String sql = "SELECT * FROM cardapio WHERE nome LIKE '" + var + "%'";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Cardapio c = new Cardapio();
                c.setId(resultado.getInt("id"));
                c.setNome(resultado.getString("nome"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar");
        }
        return lista;
    }
        public Cardapio DetalharCardapio (int var) {
            Cardapio c = new Cardapio();
            String sql = "SELECT * FROM cardapio WHERE id = " + var;
            
            conectar();
            ResultSet resultado;
            
        try {
            resultado = estado.executeQuery(sql);
            c.setId(resultado.getInt("id"));
            c.setNome(resultado.getString("nome"));
            c.setDescricao(resultado.getString("descricao"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, c.getNome());
        }
            
            return c;
        }

}
