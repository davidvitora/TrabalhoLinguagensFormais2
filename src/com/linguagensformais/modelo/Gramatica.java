/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linguagensformais.modelo;

import com.linguagensformais.vazioutil.VazioUtil;
import com.linguagensformais.vazioutil.VazioUtilList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David .V
 */
public class Gramatica extends ArrayList<Producao> {
    
    String simboloInicial;
    public ArrayList<Producao> getList(){
        return this;
    }
    
    public Gramatica(){
        simboloInicial = "";
    }
    
    public void imprimirGramatica(){
        String direita = "";
        for(Producao prod : this){
            for(Simbolo simbol : prod.getSimbolos()){
                direita += simbol.getConteudo();
            }
            System.out.println(prod.getEsquerda() + " | "
                    + direita
            );
        }
    }
    
    public List<Producao> getProducoesByEsquerda(String esquerda){
        List<Producao> producoes = new ArrayList();
        for(Producao producao : this){
            if(producao.getEsquerda().equals(esquerda)){
                producoes.add(producao);
            }
        }
        return producoes;
    }
    
    public List<Producao> getProducoesOndeNaoTerminalAparece(String NaoTerminal){
        List<Producao> producoes = new ArrayList();
        for(Producao producao : this){
            if(producao.verificarSePossuiNaoTerminal(NaoTerminal)){
                
            }
        }
        return producoes;
    }
    
    public VazioUtilList verificarNaoTerminaisVaziosDeProducao(Producao producao){
        VazioUtil vazioUtil;
        VazioUtilList simbolosVazioUtil = new VazioUtilList();
        for(Simbolo simbolo : producao.getSimbolos()){
            if(verificarSeTemProducaoVazia(simbolo.getConteudo())){
                if(simbolosVazioUtil.haveSimbolo(simbolo.getConteudo())){
                    simbolosVazioUtil.findVazioUtilBySimboloAndIncreasePossibilite(simbolo.getConteudo());
                }else{
                    simbolosVazioUtil.add(new VazioUtil(simbolo.getConteudo()));
                }
            }
        }
        for(VazioUtil util : simbolosVazioUtil){
            System.out.println(util.getSimbolo() + " Que é vazio apareceu " + util.getCount() + " vezes");
        }
        return simbolosVazioUtil;
    }
    
    public boolean verificarSeTemProducaoVazia(String NaoTerminal){
        for(Producao prod : this){
            if(prod.isVazio() && prod.getEsquerda().equals(NaoTerminal)){
                return true;
            }
        }
        return false;
    }
    
    public boolean producaoExists(String esquerda){
        for(Producao producao : this){
            if(producao.getEsquerda().equals(esquerda)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean validar(){
        for(Producao prod : this){
            if(prod.getEsquerda().equals("") || prod.getDireita().equals("")){
                return false;
            }
        }
        return true;
    }
    
    public void EliminarVazios() throws CloneNotSupportedException{
        List<Producao> listaNovasProducoes = new ArrayList<Producao>();
        List<Producao> producoes = new ArrayList<Producao>();
        VazioUtilList vazioUtilList;
        Producao newProducao;
        for(Producao producao : this){
            if(!producao.isVazio()){
                vazioUtilList = this.verificarNaoTerminaisVaziosDeProducao(producao);
                if(!vazioUtilList.isEmpty()){
                    String newDireita = "";
                    List<String> listNewDireita = new ArrayList<String>();
                    VazioListInterate(vazioUtilList, producao, 0, listNewDireita, newDireita);
                    for(String simbolsNewDireita : listNewDireita){
                        newProducao = new Producao();
                        newProducao.setDireita(simbolsNewDireita);
                        newProducao.setEsquerda(producao.getEsquerda());
                        listaNovasProducoes.add(newProducao);
                    }
                }
            }
        }
        
        for(Producao producao : listaNovasProducoes){
            this.add(producao);
        }
        listaNovasProducoes = null;
        
        for(int i = 0; i < this.size(); i++){
            newProducao = this.get(i);
            if(newProducao.isVazio()){
                producoes.add(newProducao);
            }
        }
        
        for(Producao producao : producoes){
            this.remove(producao);
        }
        
        this.EliminarEquivalentes();
    }
    
    public Gramatica elimitarSimbolosInuteis(){
        List<Producao> producoes;
        List<String> naoTerminais = new ArrayList<String>();
        naoTerminais = this.pegarTodosNaoTerminais();
        List<String> naoTerminaisValidos = new ArrayList<String>();
        
        //Etapa 1 - Producoes que geram somente terminais diretamente
        for(Producao producao : this){
            if(producao.temSomenteTerminais()){
                if(!naoTerminaisValidos.contains(producao.getEsquerda())){
                    naoTerminaisValidos.add(producao.getEsquerda());
                }
            }
        }
        
        //Etapa 2 - Producoes que geram somente terminais indiretamente
        for(Producao producao : this){
            if(producao.temSomenteTerminaisIndiretamente(this)){
                if(!naoTerminaisValidos.contains(producao.getEsquerda())){
                    naoTerminaisValidos.add(producao.getEsquerda());
                }
            }
        }
        
        Gramatica gramatica = new Gramatica();
        
        //Adiciona producoes do simbolo inicial
        producoes = this.getProducoesByEsquerda(this.getSimboloInicial());
        for(Producao producao : producoes){
                gramatica.add(producao);
        }
        
        //seta o simbolo inicial da nova gramatica;
        gramatica.setSimboloInicial(this.getSimboloInicial());
        
        //Adiciona producoes dos não terminais determinados como validos
        for(String naoTerminalValido : naoTerminaisValidos){
            producoes = this.getProducoesByEsquerda(naoTerminalValido);
            for(Producao producao : producoes){
                gramatica.add(producao);
            }
        }
        
        //Pega todos os não terminais da nova gramatica
        naoTerminais = gramatica.pegarTodosNaoTerminais();
        //Exclui as producoes com nãoTerminais não existentes
        
        for(int i = 0; i < gramatica.size(); i++){
            Producao producao = gramatica.get(i);
            for(Simbolo simbolo : producao.getSimbolos()){
                if(simbolo.getClass().equals(NaoTerminal.class)){
                    if(!naoTerminais.contains(simbolo.getConteudo())){
                        gramatica.remove(producao);
                    }
                }
            }  
        }
        
        
        //Mantem na gramatica apenas sentecas que são acessiveis a partir do simbolo inicial
        //Define todas as producoes temporiariamente como inuteis
        for(Producao producao : gramatica){
            producao.setInutil(true);
        }
        
        //Pega as producoes do simbolo inicial
        producoes = gramatica.getProducoesByEsquerda(gramatica.getSimboloInicial());
        for(Producao producao : producoes){
           //Passa em cada uma das producoes a partir das producoes do simbolo inicial, marcando as acessadas como não inuteis
           IteratorVerificarNaoAcessiveis(producao, gramatica);
        }
        
        producoes.clear();
        for(int i = 0; i < gramatica.size(); i++){
            Producao producao = gramatica.get(i);
            if(producao.isInutil()){
                producoes.add(producao);
            }
        }
        
        for(Producao producao : producoes){
            gramatica.remove(producao);
        }
        
        gramatica.EliminarEquivalentes();
        return gramatica;
    }
    
    
    public void IteratorVerificarNaoAcessiveis(Producao producao, Gramatica gramtica){
        List<Producao> producoes;
        producao.setInutil(false);
        if(!producao.isInutil()){
            return;
        }else{
            for(Simbolo simbolo : producao.getSimbolos()){
                if(simbolo.getClass().equals(NaoTerminal.class)){
                    producoes = this.getProducoesByEsquerda(simbolo.getConteudo());
                    for(Producao prod : producoes){
                        IteratorVerificarNaoAcessiveis(prod, gramtica);
                    }
                }
            }
        }
    }
    
    public void EliminarEquivalentes(){
        for(int i = 0; i < this.size(); i++){
            Producao producao = this.get(i);
            for(int j = i + 1; j < this.size(); j++ ){
                Producao producao2 = this.get(j);
                if(producao.getEsquerda().equals(producao2.getEsquerda()) && 
                        producao.getDireita().equals(producao2.getDireita())){
                    this.remove(j);
                }
            }
        }
    }
    
    public List<String> pegarTodosNaoTerminais(){
        List<String> naoTerminais  = new ArrayList<String>();
        for(Producao producao : this){
            if(!naoTerminais.contains(producao.getEsquerda())){
                naoTerminais.add(producao.getEsquerda());
            }
        }
        return naoTerminais;
    }
    
    public void VazioListInterate(VazioUtilList vazioUtilList, Producao producao, int index, List<String> listNewDireita, 
            String newDireita ){
        Simbolo simbolo = producao.getSimbolos().get(index);
        if(index + 1 == producao.getSimbolos().size()){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                if(!producao.getDireita().equals(newDireita + "<" + simbolo.getConteudo() + ">")){
                    listNewDireita.add(newDireita + "<" + simbolo.getConteudo() + ">");
                }if(vazioUtilList.haveSimbolo(simbolo.getConteudo()) && newDireita.length() > 0){
                    listNewDireita.add(newDireita);
                }
                return;
            }else{
                listNewDireita.add(newDireita + "{" + simbolo.getConteudo() + "}");
                return;
            }
        }
        index++;
        if(simbolo.getClass().equals(NaoTerminal.class)){
            VazioListInterate(vazioUtilList, producao, index, listNewDireita, newDireita + "<" + simbolo.getConteudo() + ">");
            if(vazioUtilList.haveSimbolo(simbolo.getConteudo())){
                VazioListInterate(vazioUtilList, producao, index, listNewDireita, newDireita );
            }
        }else{
            VazioListInterate(vazioUtilList, producao, index, listNewDireita, newDireita + "{" + simbolo.getConteudo() + "}");
        }
    }
    
    
    @Override
    public boolean add(Producao e) {
        return super.add(e);
    }
    
    public void eliminarUnitarios(){
        List<Producao> apenasUnitarios = new ArrayList<Producao>();
        List<Producao> producoesDoSimbolo;
        Producao producao;
        //separa os unitários
        for(Producao prod : this){
            if(prod.isUnitaria()){
                apenasUnitarios.add(prod);
            }
        }
        
        //Para cada producao unitária ele irá criar as novas producoes onde ela ocorre
        
        for(Producao producaoUnitaria : apenasUnitarios){
            producoesDoSimbolo = getProducoesByEsquerda(producaoUnitaria.getSimbolos().get(0).getConteudo());
            for(Producao producaoDosimbolo : producoesDoSimbolo){
                producao = new Producao();
                producao.setEsquerda(producaoUnitaria.getEsquerda());
                producao.setDireita(producaoDosimbolo.getDireita());
                getList().add(producao);
            }
            this.remove(producaoUnitaria);
        }
        
        this.EliminarEquivalentes();
        
    }
 
    
    @Override
    public Producao get(int index) {
        return super.get(index); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Gramatica clone(){
        Gramatica gramatica = new Gramatica();
        gramatica.setSimboloInicial(this.getSimboloInicial());
        for(Producao producao : this){
            try {
                gramatica.add(producao.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Gramatica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gramatica;
    }
    
    public boolean isValida(){
        if(this.getSimboloInicial().isEmpty()){
            return false;
        }
        if(this.getProducoesByEsquerda(this.getSimboloInicial()).size() == 0){
            return false;
        }
        for(Producao producao : this){
            if(producao.getEsquerda().isEmpty() || producao.getDireita().isEmpty()){
                return false;
            }
        }
        return true;
    }

    public String getSimboloInicial() {
        return simboloInicial;
    }

    public void setSimboloInicial(String simboloInicial) {
        this.simboloInicial = simboloInicial;
    }
}
