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
public class AlimCard extends Conexao {

    public void Cadastrar(int id_cardapio, int id_alimento) {
        String sql = "INSERT INTO  alim_card (id_cardapio, id_alimento) VALUES (?, ?)";
        PreparedStatement estado1;
        conectar();
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setInt(1, id_cardapio);
            estado1.setInt(2, id_alimento);
            estado1.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
        }
    }

    public void Remover(int id_cardapio, int id_alimento) {
        String sql = "DELETE FROM alim_card WHERE  id_cardapio = ? AND id_alimento = ?";
        PreparedStatement estado1;
        conectar();
 
        try {
            estado1 = conexao.prepareStatement(sql);
            estado1.setInt(1, id_cardapio);
            estado1.setInt(2, id_alimento);
            estado1.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover");
        }
    }
    
    public ArrayList <String> consultar (int id) {
        ArrayList <String> lista = new ArrayList();
        String sql = "SELECT alimento.nome FROM alimento, "
                + "(SELECT id_alimento AS id FROM alim_card  WHERE id_cardapio = " + id + ") AS selecao "
                + "WHERE alimento.id = selecao.id";
        conectar();
        ResultSet resultado;
        
        try {
            resultado = estado.executeQuery(sql);
            while (resultado.next()){
                String a;
                a = resultado.getString("nome");
                lista.add(a);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consulta");
        }
        return lista;
    }
    
    
}
