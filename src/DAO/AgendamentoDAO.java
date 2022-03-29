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
import model.Usuario;
import model.Agendamento;
import model.Servico;

/**
 *
 * @author Daniel lopes
 */
public class AgendamentoDAO {
    
     private final Connection connection;

    public AgendamentoDAO(Connection connection) {
        this.connection = connection;
    }
     
        public void insert (Agendamento agendamento) throws SQLException {

            
            String sql = "insert into agendamento (cliente,servico,valor,data) values (?, ?, ?,? );";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,agendamento.getCliente());
            statement.setString(2, agendamento.getServico());
            statement.setDouble(3, agendamento.getValor());
            statement.setString(4, agendamento.getData());

            statement.execute();
            connection.close();

            
    }
    
        
            public void update(Agendamento agendamento) throws SQLException{
    String sql  = "update agendamento set  cliente = ?, servico = ?, valor = ?, data = ?  where id = ?;";
     PreparedStatement statement = connection.prepareStatement(sql); 
     
                   
            statement.setString(1, agendamento.getCliente());
            statement.setString(2, agendamento.getServico());
            statement.setDouble (3, agendamento.getValor());
            statement.setString(4, agendamento.getData());
            statement.setInt (5, agendamento.getId());
            statement.execute();
            
    }
    
        
        
        
           public java.util.ArrayList<Agendamento> selectAll () throws SQLException {
           String sql = "select * from agendamento";
           PreparedStatement statement = connection.prepareStatement(sql);
            return pesquisa(statement);
        
           }
        
        private java.util.ArrayList<Agendamento> pesquisa(PreparedStatement statement) throws SQLException {
         ArrayList<Agendamento> agendamentos = new java.util.ArrayList<Agendamento>();
        statement.execute();
        ResultSet resultSet = statement.getResultSet();
        
        while (resultSet.next()) {
            
            
            int id = resultSet.getInt("id"); 
            String cliente = resultSet.getString("cliente");
            String servico =  resultSet.getString("servico");
            Double valor = resultSet.getDouble("valor");
            String data = resultSet.getString("data");
            
            Agendamento agendamentoComDadosNoBanco = new Agendamento (id,cliente,servico,valor,data);
            agendamentos.add(agendamentoComDadosNoBanco);
            
        }
        return agendamentos;
    }
    
            public void delete (Agendamento agendamento) throws SQLException {
    
    String sql = "delete from agendamento where id = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    
    statement.setInt(1, agendamento.getId());
             statement.execute();
     
    
    }
    
        
        
}
