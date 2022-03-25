/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author Daniel lopes
 */
public class ClienteDAO {
    private final Connection connection;



    public ClienteDAO(Connection connection) {
       this.connection = connection;
    }

 

 
   
    
    public void insert (Cliente cliente) throws SQLException {

            
            String sql = "insert into cliente (nome,email,telefone) values (?, ?,? );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(3,cliente.getTelefone());
            statement.setString(2, cliente.getEmail());
            statement.execute();
            connection.close();
            
    }
    
    
        public java.util.ArrayList<Cliente> selectAll () throws SQLException {
    String sql = "select * from cliente";
    PreparedStatement statement = connection.prepareStatement(sql);
        return pesquisa(statement);
               
        
    }

    private ArrayList<Cliente> pesquisa(PreparedStatement statement) throws SQLException {
        java.util.ArrayList<Cliente> clientes = new java.util.ArrayList<Cliente>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String telefone = resultSet.getString("telefone");
            String email = resultSet.getString("email");
            
            Cliente clienteComDadosNoBanco = new Cliente (nome,telefone,email);
            clientes.add(clienteComDadosNoBanco);
            
        }
        return clientes;
    }
    
    
       public Cliente selectPorId (Cliente cliente) throws SQLException {
    String sql = "select * from usuario where id = ?";
    
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setInt(1 ,cliente.getId());

     ArrayList<Cliente> clientes = pesquisa(statement);
     return clientes.get(0);
    }
}
