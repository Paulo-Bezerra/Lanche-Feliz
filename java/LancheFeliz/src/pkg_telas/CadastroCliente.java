package pkg_telas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161134010020
 */
public class CadastroCliente  extends Conexao{
    
    public void CadastrarCliente(String cpf, String nome, String email, int id_cardapio){
        String sql = "INSERT INTO  cliente (cpf, nome, email, id_cardapio) VALUES (?, ?, ?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, cpf);
            estado1.setString(2, nome);
            estado1.setString(3, email);
            estado1.setInt(4, id_cardapio);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }
    }
    
    public void AtualizarCliente ( String nome, String email, int id_cardapio, String cpf){
        String sql = "UPDATE cliente SET nome = ?, email = ?, id_cardapio = ? WHERE cpf = ?";
        PreparedStatement estado1;
        conectar();
        
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, nome);
            estado1.setString(2, email);
            estado1.setInt(3, id_cardapio);            
            estado1.setString(4, cpf);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        }
    }
    
    public void RemoverCliente(String cpf){
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        PreparedStatement estado1;
        conectar();
        
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, cpf);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Removido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover");
        }
    }
    
    public int quantidadeCliente(){
        ArrayList <Cliente> lista = new ArrayList();
        String sql = "SELECT * FROM cliente";
        int count = 0;
        conectar();
        
        try {
            ResultSet resultado = estado.executeQuery(sql);
            while (resultado.next()){
                count++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        }
        return count++;
    }
    
    public ArrayList <Cliente> ConsultaCliente(String var){
        ArrayList <Cliente> lista = new ArrayList();
        String sql = "SELECT * FROM cliente WHERE nome LIKE '%" + var + "%'";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Cliente c = new Cliente();
                c.setCpf(resultado.getString("cpf"));
                c.setNome(resultado.getString("nome"));
                c.setEmail(resultado.getString("email"));
                c.setId_cardapio(resultado.getInt("id_cardapio"));
                lista.add(c);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar");
        }
        return lista;
    }
}
