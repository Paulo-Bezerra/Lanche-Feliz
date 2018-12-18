/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_telas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author anton
 */
public class CadastroAlimento extends Conexao{
    
    public void Cadastrar(String nome, String descricao){
        String sql = "INSERT INTO  alimento (id, nome, descricao) VALUES (DEFAULT, ?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setString(1, nome);
            estado1.setString(2, descricao);
            estado1.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }
    }
    
        public ArrayList <Alimento> Consultar(){
        ArrayList <Alimento> lista = new ArrayList();
        String sql = "SELECT * FROM Alimento";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                Alimento a = new Alimento();
                a.setId(resultado.getInt("id"));
                a.setNome(resultado.getString("nome"));
                a.setDescricao(resultado.getString("descricao"));
                lista.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta");
        }
        return lista;
    }
}
