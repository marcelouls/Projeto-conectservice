/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @authores Amanda, Cristovão, Dinah, Felipe, Marcelo e Otaviano 
 */
public class Login {
    
    private String prestadorServico;
    private String login;
    private String senha;

    
    public String getId() {
        return prestadorServico;
    }

    public void setId(String prestadorServico) {
        this.prestadorServico = prestadorServico;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
