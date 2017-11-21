/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.ViewCadastroUsuario;
import view.ViewLogin;

/**
 *
 * @author Otaviano
 */
public class Cadastro {
    
    Connection con;

    public Cadastro() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Usuario use) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario  (login, senha)VALUES(?,?)");
            stmt.setString(1, use.getLogin());
            stmt.setString(2, use.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
