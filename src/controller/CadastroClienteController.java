/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ClienteDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import view.CadastroCliente;

/**
 *
 * @author Daniel lopes
 */
public class CadastroClienteController {
    
    private final CadastroCliente view;

    public CadastroClienteController(CadastroCliente view) {
        this.view = view;
    }

  
    
    public void salvarCliente () {
    String nome = view.getTextNome().getText();
    String telefone = view.getjTextTelefone().getText();
    String email = view.getjTextEmail().getText();
   
    Cliente clienteNovo = new Cliente (nome, telefone, email);
    Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            ClienteDAO clientedao = new ClienteDAO (conexao);
            clientedao.insert(clienteNovo);
            
             JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
             
        } catch (SQLException ex) {
            Logger.getLogger(CadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
     
    
    
    
    
    }
}