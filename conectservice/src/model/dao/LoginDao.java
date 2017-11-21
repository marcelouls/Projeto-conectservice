package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.ViewCadastroPrestador;
import view.ViewCadastroUsuario;

/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano
 */
public class LoginDao {

    public static boolean checkLogin(String prestador, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM login WHERE prestado_servico = ? and senha = ?");
            stmt.setString(1, prestador);
            stmt.setString(2, senha);
            
            //vai fazer o check na tabela de usuario para entrar nas permissoes de usuario
            /*
                 mudei o pacote bean e dao, view cadastro usuario, view cadastro prestador.
                 falta colocar no login e ver a melhor forma para usuario nao bular.
                 falta tambem colocar no banco para aceitar so sim e não.
            
            
            */ 

            if (prestador.equals("não") && senha.equals(senha)) {

                rs = stmt.executeQuery();
                rs.next();
                check = true;
                new ViewCadastroUsuario().setVisible(true);

            } else {

                if (prestador.equals("sim") && senha.equals(senha)) {
                    rs = stmt.executeQuery();
                    rs.next();
                    check = true;
                    new ViewCadastroPrestador().setVisible(true);

                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

}

 /*
if(txtLogin.getText().equals("") || txtSenha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Login ou Senha inválido.", JOptionPane.ERROR_MESSAGE);
        }else{
            Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://10.20.194.170:3306/oi","usuario1","");
                Statement stm = con.createStatement();
                String SQL = "Select * from usuarios where login = '"+ jTextField1.getText()+"';";
                ResultSet rs = stm.executeQuery(SQL);
                while(rs.next()) {
                    String loginn = rs.getString("login");
                    String senhaa = rs.getString("senha");
                    String nomee = rs.getString("nome");
                    String matriculaa = rs.getString("matricula"); //ctx
                    String emaill = rs.getString("email");
                    String perfill = rs.getString("perfil");
                    if(jTextField1.getText().equals(loginn) && jPasswordField1.getText().equals(senhaa)){
                        JOptionPane.showMessageDialog(null,"Seja bem vindo: " + nomee,"Oi. Simples assim!",JOptionPane.INFORMATION_MESSAGE);
                        jLabel2.setText(nomee);
                        jLabel5.setText(matriculaa); //ctx
                        jLabel6.setText(emaill);
                        jLabel11.setText(perfill); //administrador ou usuário
                    }else{
                        JOptionPane.showMessageDialog(null,"Login ou Senha inválidos.","Oi. Simples assim!",JOptionPane.ERROR_MESSAGE);
                        jPasswordField1.setText("");
                    }
                }
            }catch(SQLException e){
                e.printStackTrace(); //vejamos que erro foi gerado e quem o gerou
                JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Oi. Simples assim!",JOptionPane.WARNING_MESSAGE);
            }catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
                try{
                    con.close();
                }catch(SQLException onConClose){
                    //System.out.println("Houve erro no fechamento da conexão");
                    JOptionPane.showMessageDialog(null,"Erro na conexão, com o banco de dados!","Oi. Simples assim!",JOptionPane.WARNING_MESSAGE);
                    onConClose.printStackTrace();
                }
            } // fim do bloco try-catch-finally
        }//else do login e senha vazios
        jTextField1.setText("");
        jPasswordField1.setText("");
*/
