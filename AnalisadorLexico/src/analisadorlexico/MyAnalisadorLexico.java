package analisadorlexico;

import java.io.IOException;

public class MyAnalisadorLexico extends AnalisadorLexico {

    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }

    public void q0() {
        if (this.proxCaractere == AP) {
            leProxCaractere();
            q26();
        } else if (this.proxCaractere == FP) {
            leProxCaractere();
            q27();
        } else if (this.proxCaractere == AC) {
            leProxCaractere();
            q28();
        } else if (this.proxCaractere == FC) {
            leProxCaractere();
            q29();
        } else if (this.proxCaractere == PT_VIRG) {
            leProxCaractere();
            q23();
        } else if (this.proxCaractere == ATRIB) {
            leProxCaractere();
            q24();
        } else if (this.proxCaractere == '>' || this.proxCaractere == '!') {
            leProxCaractere();
            q32();
        } else if (this.proxCaractere == ATRIB) {
            leProxCaractere();
            q33();
        } else if (this.proxCaractere == OP_UNI_LOGICO) {
            leProxCaractere();
            q25();
        } else if (this.proxCaractereIs(OP_ARIT)){
            leProxCaractere();
            q21();
        } else if (this.proxCaractereIs(OP_ARIT_SINAL)){
            leProxCaractere();
            q22();
        } else if (this.proxCaractere == PT_VIRG){
            leProxCaractere();
            q23();
        } else if (this.proxCaractereIs(NUM)){
            leProxCaractere();
            q30();
        } else if (this.proxCaractere =='w' || this.proxCaractere =='W'){
            leProxCaractere();
            q3();
        } else if (this.proxCaractere =='d'|| this.proxCaractere =='D'){
            leProxCaractere();
            q8();
        } else if (this.proxCaractere =='f'|| this.proxCaractere =='F'){
            leProxCaractere();
            q10();
        }else if (this.proxCaractere =='i'|| this.proxCaractere =='I'){
            leProxCaractere();
            q13();
        }else if (this.proxCaractere =='a'|| this.proxCaractere =='A'){
            leProxCaractere();
            q15();
        }else if (this.proxCaractere =='o'|| this.proxCaractere =='O'){
            leProxCaractere();
            q18();
        }else if (this.proxCaractere =='|'){
            leProxCaractere();
            q19();
        }else if (this.proxCaractere =='&'){
            leProxCaractere();
            q20();
        }else if (this.proxCaractere == '<'){
            leProxCaractere();
            q37();
        }else if (this.proxCaractere == '$'){
            leProxCaractere();
            q1();
        }else if (this.proxCaractereIs(VAZIOS)){
            leProxCaractere();
            q0();
        }else if (this.proxCaractere == EOF){
            leProxCaractere();
            q100();
        }
        else {
            throw new ErroLexico(this.proxCaractere, LETRA + WHILE + FOR + IF + DO + OP_COMP + OP_BIN_LOGICO + OP_UNI_LOGICO + OP_ARIT + OP_ARIT_SINAL + ATRIB + AP + FP + AC + FC + PT_VIRG + LETRA + DIGITO + EOF + VAZIOS);
        }
    }
    
    void q23() {
        this.tokenReconhecido = Token.PT_VIRG;
    }

    void q26() {
        this.tokenReconhecido = Token.AP;
    }

    void q27() {
        this.tokenReconhecido = Token.FP;
    }

    void q28() {
        this.tokenReconhecido = Token.AC;
    }

    void q29() {
        this.tokenReconhecido = Token.FC;
    }

    void q24() {
        if (this.proxCaractere ==IGUAL) {
            leProxCaractere();
            q32();
        } else {
            this.tokenReconhecido = Token.OP_COMP;
        }
    }

    void q32() {
        if (this.proxCaractere == IGUAL) {
            leProxCaractere();
        q33();
        } else{
            this.tokenReconhecido = Token.OP_COMP;
        }
    }

    void q33() {
        this.tokenReconhecido = Token.OP_COMP;
    }

    void q25(){
        if (this.proxCaractereIs(OP_COMP)) {
            leProxCaractere();
            q32();
        } else {
            this.tokenReconhecido = Token.OP_COMP;
        }
    }
    void q21(){
        this.tokenReconhecido = Token.OP_ARIT;
    }
    void q22(){
        this.tokenReconhecido = Token.OP_ARIT_SINAL;
        if(this.proxCaractereIs(NUM)){
            leProxCaractere();
            q30();
        }
    }
    void q30(){
        this.tokenReconhecido = Token.NUM;
        if(this.proxCaractere == PT){
            leProxCaractere();
            q31();
        } else if (this.proxCaractereIs(NUM)){
            leProxCaractere();
            q30();
        } 
    }
    void q31(){
        if(this.proxCaractereIs(NUM)){
            leProxCaractere();
            q50();
        }else
            throw new ErroLexico(this.proxCaractere,NUM);
        
    }
    void q50(){
        if(this.proxCaractereIs(NUM)){
            leProxCaractere();
            q50();
        }
    }
    void q3(){
        if (this.proxCaractere =='h' || this.proxCaractere =='H'){
            leProxCaractere();
            q4();
        }else {
         throw new ErroLexico(this.proxCaractere,"h or H");
        }
    }
    void q4(){
        if (this.proxCaractere =='i' || this.proxCaractere =='I'){
            leProxCaractere();
            q5();
        }else {
         throw new ErroLexico(this.proxCaractere,"i or I");
        }
    }
    void q5(){
        if (this.proxCaractere =='l' || this.proxCaractere =='L'){
            leProxCaractere();
            q6();
        }else {
         throw new ErroLexico(this.proxCaractere,"l or L");
        }
    }
    void q6(){
        if (this.proxCaractere =='e' || this.proxCaractere =='E'){
            leProxCaractere();
            q7();
        }else {
         throw new ErroLexico(this.proxCaractere,"e or E");
        }
    }
    void q7(){
        this.tokenReconhecido = Token.WHILE;
    }
    void q8(){
        if (this.proxCaractere =='o' || this.proxCaractere =='O'){
            leProxCaractere();
            q9();
        }
    }
    void q9(){
        this.tokenReconhecido = Token.DO;
    }
    void q10(){
        if (this.proxCaractere =='o' || this.proxCaractere =='O'){
            leProxCaractere();
            q11();
        }else {
         throw new ErroLexico(this.proxCaractere,"o or O");
        }
    }
    void q11(){
        if (this.proxCaractere =='r' || this.proxCaractere =='R'){
            leProxCaractere();
            q12();
        }else {
         throw new ErroLexico(this.proxCaractere,"r or R");
        }
    }
    void q12(){
        this.tokenReconhecido = Token.FOR;
    }
    void q13(){
        if (this.proxCaractere =='f' || this.proxCaractere =='F'){
            leProxCaractere();
            q14();
        }else {
         throw new ErroLexico(this.proxCaractere,"f or F");
        }
    }
    void q14(){
        this.tokenReconhecido = Token.IF;
    }
    void q15(){
        if (this.proxCaractere =='n' || this.proxCaractere =='N'){
            leProxCaractere();
            q16();
        }else {
         throw new ErroLexico(this.proxCaractere,"n or N");
        }
    }
    void q16(){
        if (this.proxCaractere =='d' || this.proxCaractere =='D'){
            leProxCaractere();
            q17();
        }else {
         throw new ErroLexico(this.proxCaractere,"d or D");
        }
    }
    void q17(){
        this.tokenReconhecido = Token.OP_BIN_LOGICO;
    }
    void q18(){
        if (this.proxCaractere =='r' || this.proxCaractere =='R'){
            leProxCaractere();
            q17();
        }else {
         throw new ErroLexico(this.proxCaractere,"r or R");
        }
    }
    void q19(){
        if (this.proxCaractere =='|'){
            leProxCaractere();
            q17();
        }else {
         throw new ErroLexico(this.proxCaractere,"|");
        }
    }
    void q20(){
        if (this.proxCaractere =='&'){
            leProxCaractere();
            q17();
        } else {
         throw new ErroLexico(this.proxCaractere,"&");
        }
    }
    
    void q37(){
        if (this.proxCaractere =='>'){
            leProxCaractere();
            q34();
        } else if (this.proxCaractere =='='){
            leProxCaractere();
            q33();
        } else{
            throw new ErroLexico(this.proxCaractere, ">, =");
        }
    }
    
    void q34(){
        this.tokenReconhecido = Token.OP_COMP;
    }
    
    
    void q1(){
        this.tokenReconhecido = Token.IDENT;
        if (this.proxCaractereIs(LETRA)) {
            leProxCaractere();
            q2();
        } else
            throw new ErroLexico(this.proxCaractere, LETRA);
    }
    
    void q2(){
        if (this.proxCaractereIs(LETRA)) {
            leProxCaractere();
            q2();
        } else if (this.proxCaractereIs(NUM)) {
            leProxCaractere();
            q2();
        }
        
    }
    
    public void q100() {
		this.tokenReconhecido = Token.EOF;
	}
}
