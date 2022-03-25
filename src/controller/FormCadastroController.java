/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import model.Usuario;
import view.FormCadastroView;

/**
 *
 * @author Daniel lopes
 */
public class FormCadastroController {
    private FormCadastroView view;

    public FormCadastroController(FormCadastroView view) {
        this.view = view;
    }

    public FormCadastroController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void salvaUsuario (){
             String usuario = view.getjTextFieldUsuario().getText();
             String senha = view.getjTextFieldSenha().getText(); 
              Usuario usuarioNovo = new Usuario(usuario, senha);
        
        try {
      
            
            Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            
            usuarioDao.insert(usuarioNovo);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
            
           
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
