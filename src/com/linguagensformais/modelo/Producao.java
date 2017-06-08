package com.linguagensformais.modelo;

import java.util.ArrayList;
import java.util.List;


public class Producao {

    
    private String esquerda;
    private String direita;
    private List<String> simbolosIsolados;
    
    

    public String getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(String esquerda) {
        this.esquerda = esquerda;
    }


    public String getDireita() {
        return direita;
    }

 
    public void setDireita(String direita) {
        this.direita = direita;
    }
    
    private void isolarSimbolos(){
        this.simbolosIsolados = new ArrayList<String>();
        if(this.direita.charAt(0) == '\'' ){
            String slice = this.direita.substring(direita.indexOf(esquerda) , 0);
        }
    }
    
}
