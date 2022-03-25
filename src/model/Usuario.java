/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daniel lopes
 */
public class Usuario {
    private int id;
    private String usuario;
    private String Senha;

    public Usuario(int id, String usuario, String Senha) {
        this.id = id;
        this.usuario = usuario;
        this.Senha = Senha;
    }

    public Usuario(String usuario, String Senha) {
        this.usuario = usuario;
        this.Senha = Senha;
    }

   

    
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    
    
}
