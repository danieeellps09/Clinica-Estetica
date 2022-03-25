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
public class agendamento {
    
    private int Id;
    private Cliente cliente;
    private Servicos servico;
    private float valor;
    private Date data;

    public agendamento(int Id, Cliente cliente, Servicos servico, float valor, Date data) {
        this.Id = Id;
        this.cliente = cliente;
        this.servico = servico;
        this.valor = valor;
        this.data = data;
    }
    
    
    
    
    
    
    
}
