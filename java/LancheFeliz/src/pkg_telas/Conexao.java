package pkg_telas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 20161134010020
 */
public class Conexao {
   String driver = "com.mysql.jdbc.Driver";
  String banco = "bar";
  String host = "localhost";
  String url = "jdbc:mysql://"+host+":3306/"+banco;
  String user = "root";
  String pass = "";
  
  Connection conexao;
  Statement estado;
  
  public void conectar(){
      try {
          Class.forName(driver);
          conexao = DriverManager.getConnection(url, user, pass);
          estado = conexao.createStatement();
      } catch (ClassNotFoundException ex) {
          JOptionPane.showMessageDialog(null, "erro no drive");
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "erro ao conectar");
      }
      
  }
  public void fecharConexao(){
      try {
          conexao.close();
          estado.close();
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "erro ao fechar");
      }
  }
}