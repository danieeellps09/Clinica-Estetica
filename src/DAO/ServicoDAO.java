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
import model.Servico;
import model.Usuario;

/**
 *
 * @author Daniel lopes
 */
public class ServicoDAO {
    
    private final Connection connection;
    private ArrayList<Servico> servico;

    public ServicoDAO(Connection connection) {
        this.connection = connection;
    }
    
    
    public void insert (Servico servico) throws SQLException {
           String sql = "insert into servico (descricao,valor) values (?, ? );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, servico.getDescrição());
            statement.setDouble(2,servico.getValor());
            statement.execute();
            connection.close();
    
    
    }
    
    
                public void delete (Servico servico) throws SQLException {
    
    String sql = "delete from servico where id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    
    statement.setInt(1, servico.getId());
             statement.execute();
     
    
    }
    
        
    
    
    
    
    
    
    
    
          public ArrayList<Servico> selectAll () throws SQLException {
           String sql = "select * from servico";
           PreparedStatement statement = connection.prepareStatement(sql);
            return pesquisa(statement);
                
        
    }

    private java.util.ArrayList<Servico> pesquisa(PreparedStatement statement) throws SQLException {
        java.util.ArrayList<Servico> servicos = new java.util.ArrayList<Servico>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()) {
            
            String descricao = resultSet.getString("descricao");
            Double valor = resultSet.getDouble("valor");
  
            
            Servico servicoComDadosNoBanco = new Servico (descricao,valor);
            servicos.add(servicoComDadosNoBanco);
            
        }
        return servicos;
    }
    
    
        public Servico selectPorDescricao (Servico servico) throws SQLException {
    String sql = "select * from servico where descricao = ?";
    
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1 ,servico.getDescrição());

     ArrayList<Servico> servicos = pesquisa(statement);
     return servicos.get(0);
    }
    
    
    
    
}
