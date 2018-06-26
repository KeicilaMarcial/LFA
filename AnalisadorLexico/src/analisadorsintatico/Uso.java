package analisadorsintatico;
import analisadorsintatico.Tela;
import analisadorlexico.*;
import javax.swing.JOptionPane;

public class Uso {
     public static Tela tela = new Tela();
     static public MyAnalisadorSintatico parser;
    
    public static void main(String[] args) {
        String str = "entrada.txt";
        tela.setVisible(true);
        
        try {
            
            if (args.length != 1) {
               
                throw new RuntimeException(" Esqueceu de escrever o nome do arquivo de entrada! \n");
                
            }
            parser = new MyAnalisadorSintatico(str);
            parser.blocoComandos();
            System.out.println("Análise realizada com sucesso no arquivo " + parser.NOME_DEFAULT_ARQUIVO_ENTRADA);
        } catch (ErroLexico e) {
            System.out.println("Erro léxico: " + e.toString());
        } catch (ErroSintatico e) {
            System.out.println("Erro sintático: " + e.toString());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
