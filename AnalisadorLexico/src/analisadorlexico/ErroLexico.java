package analisadorlexico;
import analisadorsintatico.Tela;

public class ErroLexico extends RuntimeException {
	private char caractereEncontrado;
	private String caracteresEsperados;
        

	public ErroLexico(char _caracterEncontrado, String _caracteresEsperados) { // MODIFICAR PARA RECEBER LINHA E POSICAO
		this.caractereEncontrado = _caracterEncontrado;
		this.caracteresEsperados = _caracteresEsperados;
	}
	public String toString() { // MODIFICAR PARA ENVIAR PARA A INTERFACE
                return "caractere encontrado: "+((char)this.caractereEncontrado)+
	       "\nera(m) esperado(s): "+this.caracteresEsperados;
	}
}
