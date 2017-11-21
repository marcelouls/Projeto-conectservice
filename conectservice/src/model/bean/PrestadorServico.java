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
public class PrestadorServico {
    private int codprestador;
    private String nome;
    private String cnpj;
    private String loginprestador;
    private String senhaprestador;
    private String codsetor;
    private String prestador;

    public String getPrestador() {
        return prestador;
    }

    public void setPrestador(String prestador) {
        this.prestador = prestador;
    }

    public int getCodprestador() {
        return codprestador;
    }

    public void setCodprestador(int codprestador) {
        this.codprestador = codprestador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLoginprestador() {
        return loginprestador;
    }

    public void setLoginprestador(String login) {
        this.loginprestador = login;
    }

    public String getSenhaprestador() {
        return senhaprestador;
    }

    public void setSenhaprestador(String senha) {
        this.senhaprestador = senha;
    }

    public String getCodsetor() {
        return codsetor;
    }

    public void setCodsetor(String codsetor) {
        this.codsetor = codsetor;
    }
    
    
    
}
