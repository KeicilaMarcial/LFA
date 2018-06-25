package analisadorlexico;

public interface Constantes {
    enum Token { 
        IDENT, 
        NUM, 
        WHILE, FOR, IF, DO,
        OP_COMP,
        OP_BIN_LOGICO,
        OP_UNI_LOGICO,
        OP_ARIT,
        OP_ARIT_SINAL,
        ATRIB,
        AP,
        FP,
        AC,
        FC,
        PT,
        PT_VIRG,
        LETRA,
        DIGITO,
        EOF,
        VAZIOS,
        IGUAL
        };
    
    
    char   
            AP = '(',
            FP = ')',
            AC = '{',
            FC = '}',
            OP_UNI_LOGICO = '!',
            PT_VIRG = ';',
            ATRIB = '=',
            PT = '.',
            EOF = 0,
            IGUAL = '=';
            
    String  LETRA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ",
            NUM = "0123456789",
            DIGITO ="0123456789",
            WHILE = "whileWHILE",
            FOR = "forFOR",
            IF = "ifIF",
            DO = "doDO",
            VAZIOS = " \r\n\t",
            OP_BIN_LOGICO = "andANDorORxorXOR&&||",
            OP_COMP ="<>!",
            OP_ARIT = "*/",
            OP_ARIT_SINAL = "+-";
                    

    String NOME_DEFAULT_ARQUIVO_ENTRADA = "entrada.txt";
}
