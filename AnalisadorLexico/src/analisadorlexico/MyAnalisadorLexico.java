package analisadorlexico;

import java.io.IOException;

public class MyAnalisadorLexico extends AnalisadorLexico {

    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }

    public void s0() {
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
        } else if (this.proxCaractereIs(OP_COMP)) {
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
        }/*
        if (this.proxCaractereIs(VAZIOS)) {
            leProxCaractere();
            s2();
        }
        if (this.proxCaractere == PT_VIRG) {
            leProxCaractere();
            s3();
        } /*
            if(this.proxCaractereIs(IDENT)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(NUM)) {
			leProxCaractere();
			s2();
		}/*
                if(this.proxCaractereIs(WHILE)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(FOR)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(IF)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(DO)) {
			leProxCaractere();
			s1();
		}

                if(this.proxCaractereIs(OP_COMP)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(OP_BIN_LOGICO)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == OP_UNI_LOGICO) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == OP_UNI_LOGICO) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(OP_ARIT)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractereIs(OP_ARIT_SINAL)) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == ATRIB) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == AP) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == FP) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == AC) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == FC) {
			leProxCaractere();
			s1();
		}
                if(this.proxCaractere == PT_VIRG) {
			leProxCaractere();
			s1();
		}*/ else {
            throw new ErroLexico(this.proxCaractere, LETRA + WHILE + FOR + IF + DO + OP_COMP + OP_BIN_LOGICO + OP_UNI_LOGICO + OP_ARIT + OP_ARIT_SINAL + ATRIB + AP + FP + AC + FC + PT_VIRG + LETRA + DIGITO + EOF + VAZIOS);
        }
    }/*
	public void s1() {
		//if (this.proxCaractere == '$')
                //String teste =(String)this.tokenReconhecido.toString();
		if(this.proxCaractereIs(IDENT)) {
			leProxCaractere();
			s1();
		}
	}
	public void s2() {
		if(this.proxCaractereIs(NUM)) {
			leProxCaractere();
			s2();
		}
		else if(this.proxCaractere ==PT) {
			leProxCaractere();
			s3();
		}
                else if(this​.proxCaractereIs(OP_ARIT_SINAL)) {
                    leProxCaractere();
                    s4();
                }
		else
			throw new ErroLexico(this.proxCaractere,NUM+PT);
	}
         public void s3() {
           if(this.proxCaractereIs(NUM)) {
			leProxCaractere();
			s3();
		}
            else if(this​.proxCaractereIs(OP_ARIT_SINAL)) {
                    leProxCaractere();
                    s4();
                }
         else
	    throw new ErroLexico(this.proxCaractere,NUM);
         } 
         
         public void s4() {
           if(this.proxCaractereIs(NUM)) {
			leProxCaractere();
			s2();
		}
         }
         
        /*
	public void s3() {
		this.tokenReconhecido = Token.ATRIB;
	}
	public void s4() {
		this.tokenReconhecido = Token.IDENT;
		if(this.proxCaractereIs(LETRAS+HIFEN)) {
			leProxCaractere();
			s4();
		}
	}/*
	public void s2() {
		this.tokenReconhecido = Token.VAZIOS;
	}
         public void s3() {
		this.tokenReconhecido = Token.PT_VIRG;
	}
	public void s1() {
		this.tokenReconhecido = Token.EOF;
	}*/

 /*public void q0() {
        if (this.proxCaractere == 'd') {
            leProxCaractere();
            q6();
        } else if (this.proxCaractere == 'w') {
            leProxCaractere();
            q1();
        } else if (this.proxCaractere == 'i') {
            leProxCaractere();
            q8();
        } else if (this.proxCaractere == 's') {
            leProxCaractere();
            q10();
        } else if (this.proxCaractere == 'c') {
            leProxCaractere();
            q16();
        } else if (this.proxCaractere == 'f') {
            leProxCaractere();
            q20();
        } else if (this.proxCaractere == PT_VIRG) {
            leProxCaractere();
            q23();
        } else if (this.proxCaractere == AP) {
            leProxCaractere();
            q24();
        } else if (this.proxCaractere == FP) {
            leProxCaractere();
            q25();
        } else if (this.proxCaractere == AC) {
            leProxCaractere();
            q26();
        } else if (this.proxCaractere == FC) {
            leProxCaractere();
            q27();
        } else if (this.proxCaractere == DOIS_PT) {
            leProxCaractere();
            q28();
        } else if (this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        } else if (this.proxCaractere == IGUAL) {
            leProxCaractere();
            q30();
        } else if ((this.proxCaractere == MAIS) || (this.proxCaractere == MENOS)) {
            leProxCaractere();
            q33();
        } else if (this.proxCaractereIs(NUM)) {
            leProxCaractere();
            q37();
        } else if (this.proxCaractere == ASTERISCO) {
            leProxCaractere();
            q45();
        } else if (this.proxCaractere == BARRA) {
            leProxCaractere();
            q45();
        } else if (this.proxCaractere == PT) {
            leProxCaractere();
            q38();
        } else if (this.proxCaractere == COMERCIAL) {
            leProxCaractere();
            q32();
        } else if (this.proxCaractereIs(ASPA)) {
            leProxCaractere();
            q34();
        } else if (this.proxCaractere == BARRA_OU) {
            leProxCaractere();
            q41();
        } else if ((this.proxCaractere == MAIOR) || (this.proxCaractere == MENOR) || (this.proxCaractere == OP_UN)) {
            leProxCaractere();
            q43();
        } else if (this.proxCaractereIs(VAZIOS)) {
            leProxCaractere();
            q0();
        } else if (this.proxCaractere == EOF) {
            leProxCaractere();
            q46();
        } else {
            throw new ErroLexico(this.proxCaractere, CARACTER + VAR + NUM + WHILE + FOR + IF + SWITCH + CASE + DO);
        }
    }*/

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
}
