/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Login;
import model.bean.Usuario;

/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano 
 */
public class CadastroUsuario {
    Connection con;

    public CadastroUsuario() {
        con = ConnectionFactory.getConnection();
    }

    public void create(Usuario use) {
        // nao pegando o erro pode ser o nome da tabela

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario  (nome, cpf, login, senha, prestado_servico) VALUES(?,?,?,?,?)");
            //insert into "nome da tabela"
            stmt.setString(1, use.getNome());
            stmt.setString(2, use.getCpf());
            stmt.setString(3, use.getLogin());
            stmt.setString(4, use.getSenha());
            stmt.setString(5, use.getPrestador());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}

   