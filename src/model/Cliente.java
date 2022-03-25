/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import controller.CadastroClienteController;
/**
 *
 * @author Daniel lopes
 */
public class Cliente {
    private int Id;
    private String nome;
    private String telefone;
    private String email;

   
   

    public Cliente(String nome, String telefone, String email) {
          this.Id = Id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
public String toString (){

return getNome();
}

   

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
}
