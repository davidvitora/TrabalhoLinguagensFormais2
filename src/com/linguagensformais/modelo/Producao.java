package com.linguagensformais.modelo;

import Exception.ParsingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Producao implements Cloneable {

    private String esquerda;
    private String direita;
    private boolean isVazio;
    private Simbolo simboloEsquerda;
    private Simbolos simbolos;
    private List<String> simbolosIsolados;
    private boolean inutil;
    
    
    public Producao(){
        simbolos = new Simbolos();
        this.setEsquerda("");
        this.setDireita("");
        this.inutil = false;
    }
    
    public String getEsquerda() {
        return esquerda;
    }

    public boolean temSomenteTerminais(){
        if(this.isVazio){
            return true;
        }
        for(Simbolo simbolo: simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean temSomenteTerminaisIndiretamente(Gramatica gramatica){
        List<Producao> producoes;
        if(this.isVazio){
            return true;
        }
        boolean somenteTerminaisQueGeramSentencasCompletas = true;
        for(Simbolo simbolo: simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                producoes = gramatica.getProducoesByEsquerda(simbolo.getConteudo());
                somenteTerminaisQueGeramSentencasCompletas = false;
                for(Producao producao : producoes){
                    if(producao.temSomenteTerminais()){
                        somenteTerminaisQueGeramSentencasCompletas = true;
                        break;
                    }
                }
            }
        }
        return somenteTerminaisQueGeramSentencasCompletas;
    }
    
    public void setEsquerda(String esquerda) {
        this.esquerda = esquerda;
        this.simboloEsquerda = new Terminal(esquerda);
    }
    
    public void atualizarDireitaBaseadoNosSimbolos(){
        String direita = "";
        for(Simbolo simbolo : this.simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                direita += "<" + simbolo.getConteudo() + ">";
            }else{
                direita += "{" + simbolo.getConteudo() + "}";
            }
        }
        this.setDireita(direita);
    }

    public void modificarNaoTerminal(String naoTerminal, String newNaoTerminal){
        for(Simbolo simbolo : this.simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                if(simbolo.getConteudo().equals(naoTerminal)){
                    simbolo.setConteudo(newNaoTerminal);
                }
            }
        }
        atualizarDireitaBaseadoNosSimbolos();
    }
    
    public void modificarNaoTerminal(String naoTerminal, String newNaoTerminal, int ordem){
        int ordemAtual = 1;
        for(Simbolo simbolo : this.simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                if(simbolo.getConteudo().equals(naoTerminal)){
                    if(ordemAtual == ordem){
                        simbolo.setConteudo(newNaoTerminal);
                    }
                    ordemAtual++;
                }
            }
            if(ordemAtual < ordem){
                break;
            }
        }
        atualizarDireitaBaseadoNosSimbolos();
    }
    
    public Producao modificarNaoTerminalERetornaCopia(String naoTerminal, String newNaoTerminal, int ordem){
        Producao producao = null;
        try {
            producao = (Producao) this.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Producao.class.getName()).log(Level.SEVERE, null, ex);
        }
        int ordemAtual = 1;
        for(Simbolo simbolo : producao.simbolos){
            if(simbolo.getClass().equals(NaoTerminal.class)){
                if(simbolo.getConteudo().equals(naoTerminal)){
                    if(ordemAtual == ordem){
                        simbolo.setConteudo(newNaoTerminal);
                    }
                    ordemAtual++;
                }
            }
            if(ordemAtual < ordem){
                break;
            }
        }
        producao.atualizarDireitaBaseadoNosSimbolos();
        return producao;
    }


    public String getDireita() {
        return direita;
    }

    public void setVazio(boolean vazio){
        if(vazio = true){
            isVazio = false;
            setDireita("Ø");
            simbolos.clear();
            isVazio = true;
        }
    }
    
    public boolean verificarSePossuiNaoTerminal(String NaoTerminal){
        for(Simbolo simbol : this.simbolos){
            if(simbol.getConteudo().equals(NaoTerminal)){
                return true;
            }
        }
        return false;
    }
    
    
    public boolean isVazio(){
        return isVazio;
    }
 
    public void setDireita(String direita) {
        char a = 0;
        if(direita.equals("Ø")){
            this.direita = "Ø";
            isVazio = true;
            return;
        }
        isVazio = false;
        direita = direita.replaceAll("Ø", "");
        try{
            this.direita = direita;
            if(!this.direita.isEmpty()){
                isolarSimbolos();
            }
        }catch(ParsingException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            this.direita = "";
        }
        
    }
    
    private void isolarSimboloss(){
        this.simbolosIsolados = new ArrayList<String>();
        if(this.direita.charAt(0) == '\'' ){
            String slice = this.direita.substring(direita.indexOf(esquerda) , 0);
        }
    }
    
    
    //Verifica a quantidade de ocorrencias de um determinado caracter
    public int verificarQuantidadeDeOcorrencias(String naoTerminal){
        int ocorrencias = 0;
        Character conteudo;
        String substring = direita;
        while( substring.indexOf(naoTerminal) != -1 ){
            if(substring.indexOf(naoTerminal) != -1){
               ocorrencias++;
               substring = substring.substring(substring.indexOf(naoTerminal) + 1);
            }
        }
        return ocorrencias;
    }
    
    //Substitui todas as vezes que o não terminal aparece pela substituição enviada
    public void substituirNaoTerminal(String naoTerminal, String substituicao){
        this.direita = this.direita.replaceAll(naoTerminal, substituicao);
    }
    
    //Substitui o não terminal pela substituição enviada apenas na ordem informada ex: Primera aparição ordem = 1
    public boolean substituirNaoTerminal(String naoTerminal, String substituicao, int ordem){
        int indexOfOrdem = 0;
        if( ordem > verificarQuantidadeDeOcorrencias(naoTerminal) || ordem < 1){
            System.out.println("Nao terminal não aparece na ordem informada - erro");
            return false;
        }
        String substring = direita;
        String pre;
        String pos;
        for(int i = 1; i <= ordem;){
            if(i == ordem){
                indexOfOrdem += substring.indexOf(naoTerminal) + ordem -1;
                break;
            }else{
                indexOfOrdem += substring.indexOf(naoTerminal);
                substring = substring.
                        substring(substring.indexOf(naoTerminal) + 1);
                i++;
            }
        }
        pre = direita.substring(0, indexOfOrdem);
        pos = direita.substring(indexOfOrdem + 1);
        this.direita = pre + substituicao + pos;
        return false;
    }
    
    
    
    
    public void isolarSimbolos() throws ParsingException{
        //Limpa simbolos
        this.getSimbolos().clear();
        
        String substring = this.direita;
        String simbolSubstring = "";
        int index = 0;
        int indexInicio;
        Character caracter = substring.charAt(index);
        while(index < direita.length()){
            caracter = direita.charAt(index);
            if(caracter.equals('{') || caracter.equals('<')){
                if(caracter.equals('{')){
                   indexInicio = index;
                   index++;
                   while(!caracter.equals('}')){
                       if( index >= direita.length()){
                           throw new ParsingException("O simbolo não terminal com inicio na coluna " + (indexInicio + 1) +
                                   " Não foi fechado - Esperado }");
                       }
                       caracter = direita.charAt(index);
                       if(!caracter.equals('}')){
                        simbolSubstring += caracter;
                        index++;
                       }
                   }
                    getSimbolos().add(new Terminal(simbolSubstring));
                   simbolSubstring = "";
                }else{
                   indexInicio = index;
                   index++;
                   while(!caracter.equals('>')){
                       if( index >= direita.length()){
                           throw new ParsingException("O simbolo terminal com inicio na coluna " + (indexInicio + 1) +
                                   " Não foi fechado - Esperado >}");
                       }
                       caracter = direita.charAt(index);
                       if(!caracter.equals('>')){
                        simbolSubstring += caracter;
                        index++;
                       }
                   }
                    getSimbolos().add(new NaoTerminal(simbolSubstring));
                   simbolSubstring = "";
                }
            }else{
               throw new ParsingException("O caracter " + caracter + " da coluna " +
                       (index + 1) + " não está entre {} para terminais ou <> para não terminais"); 
            }
            index++;
        }
        
    }

    public Simbolos getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(Simbolos simbolos) {
        this.simbolos = simbolos;
    }

    public Simbolo getSimboloEsquerda() {
        return simboloEsquerda;
    }

    public void setSimboloEsquerda(Simbolo simboloEsquerda) {
        this.simboloEsquerda = simboloEsquerda;
    }
    
    public boolean isUnitaria(){
        if(this.simbolos.size() == 1){
            if(this.simbolos.get(0).getClass().equals(NaoTerminal.class) && 
                    !this.isVazio){
                return true;
            }
        }
        return false;
    }
    
    
     public Producao clone() throws CloneNotSupportedException {
        Producao producao = new Producao();
        producao.setDireita(this.getDireita());
        producao.isVazio = this.isVazio;
        producao.setEsquerda(this.getEsquerda());
        return producao;
    }

    public boolean isInutil() {
        return inutil;
    }

    public void setInutil(boolean inutil) {
        this.inutil = inutil;
    }


}