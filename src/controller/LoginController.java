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
import javax.swing.JOptionPane;
import model.Usuario;
import view.LoginView;
import view.MenuView;

/**
 *
 * @author Daniel lopes
 */
public class LoginController {
    private LoginView view;

    public LoginController(LoginView view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
  
  
              //Buscar usuario da view
        String usuario = view.getjTextFieldUser().getText();
        String senha = view.getjPasswordFieldPassword().getText();
        
        Usuario usuarioAutenticado = new Usuario (usuario,senha);
        //varefica a existencia no banco de dados
          Connection conexao = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
           boolean existe =  usuarioDao.existeUsuarioPorNomeESenha(usuarioAutenticado);
           if (existe){ 
              //se ele existir no banco de dados, abrir o menu
                MenuView telaDeMenu =  new MenuView();
                telaDeMenu.setVisible(true);
                LoginView login = new LoginView();
                login.dispose();
                
           }else { JOptionPane.showMessageDialog(null, "Usuario ou senha inválida");
           view.getjTextFieldUser().setText("");
           view.getjPasswordFieldPassword().setText("");
           
           }
    }

  
    
    
    
    
}
