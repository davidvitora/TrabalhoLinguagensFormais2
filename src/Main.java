import com.linguagensformais.modelo.ModeloTabelaGramatica;
import com.linguagensformais.modelo.Producao;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    public ModeloTabelaGramatica getModeloGramaticaOrigem() {
        return modeloGramaticaOrigem;
    }

    public void setModeloGramaticaOrigem(ModeloTabelaGramatica modeloGramaticaOrigem) {
        this.modeloGramaticaOrigem = modeloGramaticaOrigem;
    }

    public ModeloTabelaGramatica getModeloGramaticaGerada() {
        return modeloGramaticaGerada;
    }

    public void setModeloGramaticaGerada(ModeloTabelaGramatica modeloGramaticaGerada) {
        this.modeloGramaticaGerada = modeloGramaticaGerada;
    }


    private ModeloTabelaGramatica modeloGramaticaOrigem;
    private ModeloTabelaGramatica modeloGramaticaGerada;
    
    public Main() {
        modeloGramaticaOrigem = new ModeloTabelaGramatica(new ArrayList<Producao>(), true); 
        modeloGramaticaGerada = new ModeloTabelaGramatica(new ArrayList<Producao>(), false);       
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        buttonEliminarSombolosInuteis = new javax.swing.JButton();
        buttonSimplificacaoCombinada = new javax.swing.JButton();
        buttonEliminarProducoesVazias1 = new javax.swing.JButton();
        buttonEliminarProducoesUnitarias = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLinguagemOrigem = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLinguagemGerada = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        buttonNovaLinha = new javax.swing.JButton();
        buttonExcluirLinha = new javax.swing.JButton();
        buttonLimparLinha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Simplificador de Gramatica"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar"));

        buttonEliminarSombolosInuteis.setText("Simbolos Inuteis");
        buttonEliminarSombolosInuteis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarSombolosInuteisActionPerformed(evt);
            }
        });

        buttonSimplificacaoCombinada.setText("Simplificação Combinada");

        buttonEliminarProducoesVazias1.setText("Producoes Vazias");

        buttonEliminarProducoesUnitarias.setText("Producoes Unitarias");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonEliminarSombolosInuteis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEliminarProducoesVazias1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSimplificacaoCombinada, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(buttonEliminarProducoesUnitarias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonEliminarSombolosInuteis, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEliminarProducoesVazias1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEliminarProducoesUnitarias, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSimplificacaoCombinada, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        tableLinguagemOrigem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Simbolo", "Regras"
            }
        ));
        this.tableLinguagemOrigem.setModel(this.getModeloGramaticaOrigem());
        this.tableLinguagemOrigem.getColumnModel().getColumn(0).setHeaderValue("Esquerda");
        this.tableLinguagemOrigem.getColumnModel().getColumn(1).setHeaderValue("Direita");
        jScrollPane1.setViewportView(tableLinguagemOrigem);
        if (tableLinguagemOrigem.getColumnModel().getColumnCount() > 0) {
            tableLinguagemOrigem.getColumnModel().getColumn(0).setResizable(false);
            tableLinguagemOrigem.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel1.setText("Linguagem Origem");

        jLabel2.setText("Linguagem Gerada");

        tableLinguagemGerada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Simbolo", "Regras"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        this.tableLinguagemGerada.setModel(this.getModeloGramaticaGerada());
        this.tableLinguagemGerada.getColumnModel().getColumn(0).setHeaderValue("Esquerda");
        this.tableLinguagemGerada.getColumnModel().getColumn(1).setHeaderValue("Direita");
        jScrollPane2.setViewportView(tableLinguagemGerada);
        if (tableLinguagemGerada.getColumnModel().getColumnCount() > 0) {
            tableLinguagemGerada.getColumnModel().getColumn(0).setResizable(false);
            tableLinguagemGerada.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));

        buttonNovaLinha.setText("Nova Linha");
        buttonNovaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovaLinhaActionPerformed(evt);
            }
        });

        buttonExcluirLinha.setText("Excluir Linha");
        buttonExcluirLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirLinhaActionPerformed(evt);
            }
        });

        buttonLimparLinha.setText("Limpar Linha");
        buttonLimparLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparLinhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNovaLinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLimparLinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonExcluirLinha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(buttonNovaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimparLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluirLinha, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarSombolosInuteisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarSombolosInuteisActionPerformed
        
    }//GEN-LAST:event_buttonEliminarSombolosInuteisActionPerformed

    private void buttonExcluirLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirLinhaActionPerformed
        if(tableLinguagemOrigem.getSelectedRow() != -1){
            this.getModeloGramaticaOrigem().gramatica.remove(this.tableLinguagemOrigem.getSelectedRow());
            this.getModeloGramaticaOrigem().fireTableDataChanged();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma linha da Gramatica de origem para realizar a exclusão");
        }
    }//GEN-LAST:event_buttonExcluirLinhaActionPerformed

    private void buttonNovaLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovaLinhaActionPerformed
        this.getModeloGramaticaOrigem().gramatica.add(new Producao());
        this.getModeloGramaticaOrigem().fireTableDataChanged();
    }//GEN-LAST:event_buttonNovaLinhaActionPerformed

    private void buttonLimparLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparLinhaActionPerformed
        this.getModeloGramaticaOrigem().gramatica.clear();
        this.getModeloGramaticaOrigem().fireTableDataChanged();
    }//GEN-LAST:event_buttonLimparLinhaActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());    
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEliminarProducoesUnitarias;
    private javax.swing.JButton buttonEliminarProducoesVazias1;
    private javax.swing.JButton buttonEliminarSombolosInuteis;
    private javax.swing.JButton buttonExcluirLinha;
    private javax.swing.JButton buttonLimparLinha;
    private javax.swing.JButton buttonNovaLinha;
    private javax.swing.JButton buttonSimplificacaoCombinada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableLinguagemGerada;
    private javax.swing.JTable tableLinguagemOrigem;
    // End of variables declaration//GEN-END:variables
}
