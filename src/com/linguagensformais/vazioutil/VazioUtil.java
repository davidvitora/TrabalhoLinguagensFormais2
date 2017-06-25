/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linguagensformais.vazioutil;

public class VazioUtil {
   private String simbolo;
   private int count = 0;
   
   public VazioUtil(String simbolo){
       this.simbolo = simbolo;
       this.count = 1;
   }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
