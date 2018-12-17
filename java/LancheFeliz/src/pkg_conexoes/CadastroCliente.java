package pkg_conexoes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pkg_classes.Cliente;

/**
 *
 * @author 20161134010020
 */
public class CadastroCliente  extends Conexao{
    
    public void CadastrarCliente(String cpf, String nome, String email){
        String sql = "INSERT INTO  cliente (cpf, nome, email) VALUES (?, ?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, cpf);
            estado1.setString(2, nome);
            estado1.setString(3, email);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }
    }
    
    public void AtualizarCliente ( String nome, String email, String cpf){
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE cpf = ?";
        PreparedStatement estado1;
        conectar();
        
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, nome);
            estado1.setString(2, email);
            estado1.setString(3, cpf);
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
}