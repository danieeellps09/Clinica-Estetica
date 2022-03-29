/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Conexao;
import DAO.ServicoDAO;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import model.Servico;
import view.ServicoView;

/**
 *
 * @author Daniel lopes
 */
public class ServicoController {
private final ServicoView view;

    public ServicoController(ServicoView view) {
        this.view = view;
    }


    public void SalvarServico ()  {
      String descricao = view.getjTextFieldDescricao().getText();
       String valor = view.getjTextFieldValor().getText(); 
       Servico servicoNovo = new Servico(descricao, Double.parseDouble(valor));
 
        
         
        
        Connection conexao;
    try {
        conexao = new Conexao().getConnection();
           ServicoDAO servicoDao = new ServicoDAO(conexao);
           servicoDao.insert(servicoNovo);
    } catch (SQLException ex) {
        Logger.getLogger(ServicoController.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    
    
    
    }

   
    
    
    
    
    

}
