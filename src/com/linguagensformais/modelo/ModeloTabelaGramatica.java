package com.linguagensformais.modelo;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloTabelaGramatica extends AbstractTableModel{
    private Gramatica gramatica;

    String colunas[] = {"Esquerda","Direita"};
    boolean editavel;
    
    public ModeloTabelaGramatica(Gramatica gramatica, boolean editavel){
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
            if(gramatica.producaoExists((String) value)){
                getGramatica().get(row).setSimboloEsquerda(
                getGramatica().getProducoesByEsquerda((String) value).get(0).getSimboloEsquerda());
            }else{
                getGramatica().get(row).setSimboloEsquerda(new NaoTerminal((String) value));
            }
            getGramatica().get(row).setEsquerda((String) value);
       }
       if(col == 1){
            getGramatica().get(row).setDireita((String) value);
       }
       fireTableCellUpdated(row, col);
     }
    
    public int getRowCount() {
        return getGramatica().size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
                 Producao producao = (Producao) getGramatica().get(rowIndex);
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

    public Gramatica getGramatica() {
        return gramatica;
    }

    public void setGramatica(Gramatica gramatica) {
        this.gramatica = gramatica;
    }
    
}
