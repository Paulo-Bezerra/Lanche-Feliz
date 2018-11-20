package pkg_telas;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161134010020
 */
public class CadastroCardapio extends Conexao {
    
    
    public void CadastrarProduto(int idCardapio, String nome,String data_validade , String tipo, int idCategoria){
        String sql = "INSERT INTO  cardapio (idProduto, nome, data_validade, tipo, idCategoria) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setInt(1, idCardapio);
            estado1.setString(2,nome);
            estado1.setString(2, data_validade);
            estado1.setString(4, tipo);
            estado1.setInt(5, idCategoria);
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
}
