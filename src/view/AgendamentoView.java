/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.AgendamentoDAO;
import DAO.ClienteDAO;
import DAO.Conexao;
import DAO.ServicoDAO;
import controller.AgendamentoController;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.parser.Entity;
import model.Agendamento;
import model.Cliente;
import model.Servico;

/**
 *
 * @author Daniel lopes
 */
public class AgendamentoView extends javax.swing.JFrame {

    private Object prepareStatement;

    /**
private     */
    
    private final AgendamentoController controller;
    public AgendamentoView() throws SQLException  {
        initComponents();
        controller = new AgendamentoController (this);
    
               Connection conexao = new Conexao().getConnection();
       
            ClienteDAO clienteDao = new ClienteDAO(conexao);
            for (Cliente p: clienteDao.selectAll()) {
             cbCliente.addItem(p);
         
       }
       
            
             ServicoDAO servicoDao = new ServicoDAO(conexao);
            for (Servico s: servicoDao.selectAll()) {
            cbServico.addItem(s);
         
       }
    
      DefaultTableModel modelo = (DefaultTableModel)TableAgendar.getModel();
      TableAgendar.setRowSorter(new TableRowSorter(modelo));
      selectTable();
    }
    
      public void selectTable() throws SQLException{
      DefaultTableModel modelo = (DefaultTableModel)TableAgendar.getModel(); 
      modelo.setNumRows(0);
        Connection conexao = new Conexao().getConnection();
      AgendamentoDAO  agendarDao  = new AgendamentoDAO(conexao);
      for (Agendamento a: agendarDao.selectAll()){
       modelo.addRow(new Object[] {
        a.getId(),
        a.getCliente(),
        a.getServico(),
        a.getValor(),
        a.getData()
       
       });
      
      }
      
      }
      
      
      
      
      
      
      
   
    
      
         
         
             


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextData = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCliente = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonAgendar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbServico = new javax.swing.JComboBox<>();
        JButtonAtualizar = new javax.swing.JButton();
        jButtonApagar = new javax.swing.JButton();
        jTextFieldValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAgendar = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDataActionPerformed(evt);
            }
        });
        getContentPane().add(TextData, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 110, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Serviço");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Cliente");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 70, 40));

        cbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbClienteItemStateChanged(evt);
            }
        });
        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });
        getContentPane().add(cbCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 162, 140, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Valor");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 50, 30));

        jButtonAgendar.setBackground(new java.awt.Color(102, 255, 0));
        jButtonAgendar.setForeground(new java.awt.Color(0, 0, 102));
        jButtonAgendar.setText("AGENDAR");
        jButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAgendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 160, 40));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Data/hora");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 31));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("AGENDAMENTO DE SESSÕES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 690, 50));

        cbServico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServicoItemStateChanged(evt);
            }
        });
        cbServico.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbServicoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServicoActionPerformed(evt);
            }
        });
        getContentPane().add(cbServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, 20));

        JButtonAtualizar.setBackground(new java.awt.Color(102, 51, 255));
        JButtonAtualizar.setText("ATUALIZAR");
        JButtonAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JButtonAtualizarMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JButtonAtualizarMouseClicked(evt);
            }
        });
        JButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(JButtonAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 153, 40));

        jButtonApagar.setBackground(new java.awt.Color(255, 0, 0));
        jButtonApagar.setText("APAGAR ");
        jButtonApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApagarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 350, 134, 38));

        jTextFieldValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 110, 30));

        TableAgendar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Cliente", "Servico", "Valor", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableAgendar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TableAgendarKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TableAgendar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 620, 230));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagensicon/AgendamentoView.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -70, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextDataActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
 
    }//GEN-LAST:event_cbClienteActionPerformed

    private void jButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarActionPerformed
  
        try {
            controller.salvarAgendamento();
            selectTable();
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonAgendarActionPerformed

    private void jTextFieldValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorActionPerformed

    private void cbServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServicoActionPerformed
     
            
         
         
     
     
        
        
        
    }//GEN-LAST:event_cbServicoActionPerformed

    private void cbServicoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbServicoPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
           
    }//GEN-LAST:event_cbServicoPopupMenuWillBecomeInvisible

    private void cbServicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServicoItemStateChanged
      
        if(evt.getStateChange() == ItemEvent.SELECTED){
        
        Servico servico = (Servico) evt.getItem();
        jTextFieldValor.setText(String.valueOf(servico.getValor()));
                
        
        }
      
        
        
    }//GEN-LAST:event_cbServicoItemStateChanged

    private void cbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbClienteItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteItemStateChanged

    private void TableAgendarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableAgendarKeyReleased
        // TODO add your handling code here:
        
                         if (TableAgendar.getSelectedRow() != -1) {
        
       cbCliente.setSelectedItem(TableAgendar.getValueAt(TableAgendar.getSelectedRow(),1).toString());
       cbServico.setSelectedItem(TableAgendar.getValueAt(TableAgendar.getSelectedRow(),2).toString());
       jTextFieldValor.setText(TableAgendar.getValueAt(TableAgendar.getSelectedRow(),3).toString());
      TextData.setText(TableAgendar.getValueAt(TableAgendar.getSelectedRow(),4).toString());
       
       
       
       
            
        
        }
        
    
        
    }//GEN-LAST:event_TableAgendarKeyReleased

    private void JButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonAtualizarActionPerformed
        // TODO add your handling code here:
        if (TableAgendar.getSelectedRow() != -1) {
        
   
       
       Connection conexao;
            try {
                conexao = new Conexao().getConnection();
                  AgendamentoDAO  agendaDao  = new AgendamentoDAO(conexao);
                    Agendamento agenda = new Agendamento();   
       agenda.setId((int) TableAgendar.getValueAt(TableAgendar.getSelectedRow(), 0));
       agenda.setCliente(cbCliente.getSelectedItem().toString());
       agenda.setServico((String) (Object) cbServico.getSelectedItem().toString());
       agenda.setValor (Double.valueOf(jTextFieldValor.getText()));
       agenda.setData(TextData.getText());
       
       jTextFieldValor.setText("");
       TextData.setText("");
       JOptionPane.showMessageDialog(rootPane, "Agendamento atualizado com sucesso");
       
       agendaDao.update(agenda);
            } catch (SQLException ex) {
                
                Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
     
         
       
            try {
                selectTable();
            } catch (SQLException ex) {
                Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }
    }//GEN-LAST:event_JButtonAtualizarActionPerformed

    private void JButtonAtualizarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAtualizarMouseReleased
        // TODO add your handling code here:
   
        
    }//GEN-LAST:event_JButtonAtualizarMouseReleased

    private void JButtonAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JButtonAtualizarMouseClicked
        // TODO add your handling code here:
        

    }//GEN-LAST:event_JButtonAtualizarMouseClicked

    private void jButtonApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApagarActionPerformed
        // TODO add your handling code here:
         if (TableAgendar.getSelectedRow() != -1) {
        
   
       
       Connection conexao;
            try {
                conexao = new Conexao().getConnection();
                  AgendamentoDAO  agendaDao  = new AgendamentoDAO(conexao);
                    Agendamento agenda = new Agendamento();   
       agenda.setId((int) TableAgendar.getValueAt(TableAgendar.getSelectedRow(), 0));
 
       
       jTextFieldValor.setText("");
       TextData.setText("");
       agendaDao.delete(agenda);
            } catch (SQLException ex) {
                
                Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
     
         
       
            try {
                selectTable();
                JOptionPane.showMessageDialog(null, "Agendamento deletado com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        }

    }//GEN-LAST:event_jButtonApagarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgendamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendamentoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
   
                try {
                    new AgendamentoView().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AgendamentoView.class.getName()).log(Level.SEVERE, null, ex);
                }
              
             
            }
        });
    }

    public JTextField getTextData() {
        return TextData;
    }

    public void setTextData(JTextField TextData) {
        this.TextData = TextData;
    }

    public JComboBox<Object> getCbCliente() {
        return cbCliente;
    }

    public void setCbCliente(JComboBox<Object> cbCliente) {
        this.cbCliente = cbCliente;
    }

    public JComboBox<Object> getCbServico() {
        return cbServico;
    }

    public void setCbServico(JComboBox<Object> cbServico) {
        this.cbServico = cbServico;
    }

    public JTextField getjTextFieldValor() {
        return jTextFieldValor;
    }

    public void setjTextFieldValor(JTextField jTextFieldValor) {
        this.jTextFieldValor = jTextFieldValor;
    }

    
    
    
    
    
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonAtualizar;
    private javax.swing.JTable TableAgendar;
    private javax.swing.JTextField TextData;
    private javax.swing.JComboBox<Object> cbCliente;
    private javax.swing.JComboBox<Object> cbServico;
    private javax.swing.JButton jButtonAgendar;
    private javax.swing.JButton jButtonApagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
