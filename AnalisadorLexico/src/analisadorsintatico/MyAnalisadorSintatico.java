package analisadorsintatico;

import analisadorlexico.Constantes;

/**
 *
 * @author Ana Flávia, Carlos, Julio, Keicila e Ramon
 */
public class MyAnalisadorSintatico extends AnalisadorSintatico {
	
        /**
        *
        * @param _nomeArquivoEntrada
        */

    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
		super(_nomeArquivoEntrada);
    }
    
    public void blocoComandos() {
	if(proxTokenIs(Token.WHILE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || 
           proxTokenIs(Token.IF) || proxTokenIs(Token.IDENT)) { 
            comando();
            blocoComandos();
        }
        else if(proxTokenIs(Token.EOF)) {
            reconhece(Token.EOF);
        }
        else if(proxTokenIs(Token.FC)) {
        }
        else {
            Token[] tokensEsperados = {Token.IDENT, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }

    public void comando() {
        if(proxTokenIs(Token.WHILE)) {
            While();
        }
        else if(proxTokenIs(Token.DO)) {
            Do();
        }
        else if(proxTokenIs(Token.FOR)) {
            For();
        }
        else if(proxTokenIs(Token.IF)) {
            If();
        }
        else if(proxTokenIs(Token.IDENT)) {
            atrib();
        }
        else {
            Token[] tokensEsperados = {Token.IDENT, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }
    
    public void exp() {
        if(proxTokenIs(Token.OP_UNI_LOGICO)) {
            reconhece(Token.OP_UNI_LOGICO);
            exp();
            R();
        }
        else if(proxTokenIs(Token.AP)) {
            reconhece(Token.AP);
            exp();
            R();
            reconhece(Token.FP);
        }
        else if(proxTokenIs(Token.NUM)) {
            reconhece(Token.NUM);
            R();
        }
        else if(proxTokenIs(Token.OP_ARIT_SINAL)) {
            reconhece(Token.OP_ARIT_SINAL);
            reconhece(Token.NUM);
            R();
        }
        else if(proxTokenIs(Token.IDENT)) {
            reconhece(Token.IDENT);
            R();
        }
    }
    
    public void R() {
        if(proxTokenIs(Token.OP_COMP) || proxTokenIs(Token.OP_BIN_LOGICO)  || 
           proxTokenIs(Token.OP_ARIT) || proxTokenIs(Token.OP_ARIT_SINAL)) {
            operador();
            exp();
            R();
        }
        else if(proxTokenIs(Token.EOF))
            reconhece(Token.EOF);
    }
    
    public void While() {
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    public void If() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    public void For() {
        reconhece(Token.FOR);
        reconhece(Token.AP);
        exp(); //* ************** if else /
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    public void atrib() {
        reconhece(Token.IDENT);
        reconhece(Token.ATRIB);
        exp();
        reconhece(Token.PT_VIRG);
    }
    
    public void operador() {
        if (proxTokenIs(Token.OP_COMP)){
            reconhece(Token.OP_COMP);
        }
        else if (proxTokenIs(Token.OP_BIN_LOGICO)){
            reconhece(Token.OP_BIN_LOGICO);
        }
        else if (proxTokenIs(Token.OP_ARIT)){
            reconhece(Token.OP_BIN_LOGICO);
        }
        else if (proxTokenIs(Token.OP_ARIT_SINAL)){
            reconhece(Token.OP_BIN_LOGICO);
        }
    }

    public void Do() {
        reconhece(Token.DO);
        corpo();
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.PT_VIRG);
    }
    
    public void corpo(){
        if(proxTokenIs(Token.AC)) {
            reconhece(Token.AC);
            blocoComandos();
            reconhece(Token.FC);
        }
        else if(proxTokenIs(Token.WHILE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || 
                proxTokenIs(Token.IF) || proxTokenIs(Token.IDENT)) { 
            comando();
        }
    }
}