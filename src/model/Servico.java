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
public class Servico {
    
    private int id;
    private String descrição;
    private Double valor;

    public Servico(String descrição, Double valor) {
        this.descrição = descrição;
        this.valor = valor;
    }



 
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

 
    
   public String toString (){
    
   return getDescrição();
   
   } 
    
    
    public Double toDouble(){
    return getValor();
    }
    
    
    
}
