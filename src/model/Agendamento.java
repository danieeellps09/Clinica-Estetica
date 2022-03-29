/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Daniel lopes
 */
public class Agendamento {
    
    private int Id;
    private String cliente;
    private String servico;
    private Double valor;
    private String data; 

    public Agendamento() {
    }
    
    
    

    public Agendamento(String cliente, String servico, Double valor, String data) {
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }

    public Agendamento(int Id, String cliente, String servico, Double valor, String data) {
        this.Id = Id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }

   

    
    
    
    
    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


     
    
    
    
    
    
    
}
