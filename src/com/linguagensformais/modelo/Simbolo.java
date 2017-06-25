/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linguagensformais.modelo;

/**
 *
 * @author David .V
 */
public class Simbolo {
    
    private String conteudo;
    
    public Simbolo(){
        
    }
    
    public Simbolo(String conteudo){
        this.conteudo = conteudo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
