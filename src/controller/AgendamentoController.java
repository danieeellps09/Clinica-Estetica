/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AgendamentoDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Agendamento;
import view.AgendamentoView;

/**
 *
 * @author Daniel lopes
 */
public class AgendamentoController {
    private final AgendamentoView view;

    public AgendamentoController(AgendamentoView view) {
        this.view = view;
    }
    
    public void salvarAgendamento () {
    String cliente = view.getCbCliente().getSelectedItem().toString();
    String servico = view.getCbServico().getSelectedItem().toString();
    String valor = view.getjTextFieldValor().getText();
    String data = view.getTextData().getText();
    
    Agendamento agendamentoNovo = new Agendamento (cliente,servico,Double.parseDouble(valor),data);
    this.limpar();
        try {
            Connection conexao = new Conexao().getConnection();
            AgendamentoDAO agendamentoDao = new AgendamentoDAO(conexao);
            agendamentoDao.insert(agendamentoNovo);
            JOptionPane.showMessageDialog(null, "Agendamento feito com sucesso ");
            
    
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
 
    }
    
 public void limpar() {
 

 
  
 
 
 
 }
    
    
}
