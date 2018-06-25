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
            reconhece(Token.PT_VIRG);
            blocoComandos();
        }
        else if(proxTokenIs(Token.EOF)) {
            reconhece(Token.EOF);
        }
        else {
            Token[] tokensEsperados = {Token.IDENT, Token.NUM, Token.EOF};
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
            Token[] tokensEsperados = {Token.IDENT, Token.NUM, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }
    
    /**
     *função exp pode receber um operador2 seguido de uma expressão e um R(operador1 seguido de uma expressão, R ou vazio) ou abre parênteses com uma expressão dentro, fecha parêntes e R, ou uma variável e R, ou um número e R, ou um sinal(-,+) seguido de um número e R
     * exp = operador2 exp R | AP exp FP R | VAR R | NUM R| SINAL NUM R
     */
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
        else if(proxTokenIs(Token.OP_ARIT_SINAL)) { //aqui é sinal: apenas + ou -. Então é OP_UN_BIN
            reconhece(Token.OP_ARIT_SINAL);
            reconhece(Token.NUM);
            R();
        }
        else if(proxTokenIs(Token.IDENT)) {
            reconhece(Token.IDENT);
            R();
        }
    }
    
    /**
     * função R é um operador1 seguido de uma expressão e chamando a própria função R ou vazia
     * GR: R = operador1 exp R | ?
     */
    public void R() {
        if(proxTokenIs(Token.OP_COMP) || proxTokenIs(Token.OP_BIN_LOGICO) || 
           proxTokenIs(Token.OP_ARIT) || proxTokenIs(Token.OP_ARIT_SINAL)) {
            operador();
            exp();
            R();
        }
        else if(proxTokenIs(Token.EOF))
            reconhece(Token.EOF);
    }
    
    /**
     *função while reconhece o while seguido de abre parênteses com uma expressão dentro e fecha parêntenses seguido de um bloco
     * while = WHILE AP exp FP bloco
     */
    public void While() {
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    /**
     *função if reconhece o if seguido de abre parênteses com uma expressão dentro e fecha parêntenses seguido de um bloco
     * GR: if = IF AP exp FP bloco
     */
    public void If() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    /**
     * função for reconhece o token for, em seguida abre parênteses com uma atribuição dentro, ponto e vírgula, depois uma expressão, ponto e vírgula, atribuição e fecha parênteses seguido de um bloco  
     * GR: for = FOR AP atribuicao PT_VIRG exp PT_VIRG atribuicao FP bloco 
     */

    public void For() {
        reconhece(Token.FOR);
        reconhece(Token.AP);
        exp();
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.FP);
        corpo();
    }
    
    /**
     *função atribuição pode ser uma variável ou igual seguido de uma expressão  
     * GR: atribuicao = VAR IGUAL exp
     */
    public void atrib() {
        reconhece(Token.IDENT);
        reconhece(Token.ATRIB);
        exp();
    }
    
    /**
     * função operador1 que pode ser um operador unário binário ou só um operador binário
     * GR: operador1 = OP_UN_BIN | OP_BIN
     */
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

    /**
     * função operador2 que pode ser um operador unário binário ou só um operador unário 
     * GR: operador2 = OP_UN_BIN | OP_UN
     */
    
    /**
     * função DoWhile reconhece o token DO seguido de um abre chaves com um bloco dentro e fecha chaves, depois um while, abre parênteses com uma expressão dentro e fecha parênteses
     * GR: do_while = DO AC bloco FC WHILE AP exp FP
     */
    public void Do() {
        reconhece(Token.DO);
        corpo();
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
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