/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linguagensformais.vazioutil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David .V
 */
public class VazioUtilList extends ArrayList<VazioUtil> {
    private int possiblities = 0;
    List<String> simbolos = new ArrayList<String>();
    
    public boolean haveSimbolo(String simbolo){
        for(VazioUtil vazio : this){
            if(vazio.getSimbolo().equals(simbolo)){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public boolean add(VazioUtil e) {
        setPossiblities(getPossiblities() + 1);
        return super.add(e);
    }
    
    public VazioUtil getVazioUtilBySimbolo(String simbolo){
        for(VazioUtil vazio : this){
            if(vazio.getSimbolo().equals(simbolo)){
                return vazio;
            }
        }
        return null;
    }
    
    public void findVazioUtilBySimboloAndIncreasePossibilite(String simbolo){
        for(VazioUtil vazio : this){
            if(vazio.getSimbolo().equals(simbolo)){
                this.setPossiblities(this.getPossiblities() + 1);
                vazio.setCount(vazio.getCount() + 1);
            }
        }
        System.out.println("Erro ao interar possiblidades do simbolo " + simbolo);
        return;
    }

    public int getPossiblities() {
        return possiblities;
    }

    public void setPossiblities(int possiblities) {
        this.possiblities = possiblities;
    }
}
