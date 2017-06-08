package com.linguagensformais.modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloTabelaGramatica extends AbstractTableModel{
    public List<Producao> gramatica;

    String colunas[] = {"Esquerda","Direita"};
    boolean editavel;
    
    public ModeloTabelaGramatica(List<Producao> gramatica, boolean editavel){
        this.editavel = editavel;
        this.gramatica = gramatica;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        if(editavel == true){
            return true;
        }
        return false;
    }
    
    @Override
    public void setValueAt(Object value, int row, int col) {
        
       if(col == 0){
           gramatica.get(row).setEsquerda((String) value);
       }
       if(col == 1){
           gramatica.get(row).setDireita((String) value);
       }
       fireTableCellUpdated(row, col);
     }
    
    public int getRowCount() {
        return gramatica.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Producao producao = (Producao) gramatica.get(rowIndex);
         switch( columnIndex ) {
             case 0: return producao.getEsquerda();
             case 1: return producao.getDireita();
         }
         return null;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
