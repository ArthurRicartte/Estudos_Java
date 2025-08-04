package ExerciciosPropostos;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ContaLetra {
    public static final int SIZE = 5;
    
    //Conta a quantas vezes a letra desejada aparece
    public static int CountLetra(String palavra){
        final int SIZEWORD = palavra.length();

        String letrasA = "";
        for(int i = 0; i < SIZEWORD; i++){
            char letra = palavra.charAt(i);
            if (letra == 'a'){
                letrasA += letra;
            }
        }

        return (letrasA.length());
    }

    //Exibir resposta -> vai concatenando cada palavra e quantas vezez o 'a' apareceu
    public static void ExibeResposta(String[] palavra, int[] qtdLetra){
        String msg = "";
        
        for(int i = 0; i < SIZE; i++){
            if (qtdLetra[i] == 0){
                msg += ("Palavra: " + palavra[i] + " - 'a' apareceu nenhuma vez" + "\n");
            }else if (qtdLetra[i] == 1){
                msg += ("Palavra: " + palavra[i] + " - 'a' apareceu 1 vez" + "\n");
            }else{
                msg += ("Palavra: " + palavra[i] + "  -  'a' apareceu " + qtdLetra[i] +  " vezes" + "\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, msg);
    }
    
    public static void main(String[] args) throws IOException {
    
        String[] palavras = new String[SIZE];
        int[] qtdCaracter = new int[SIZE];

        for (int i = 0; i < SIZE; i++){
            palavras[i] = JOptionPane.showInputDialog("Digite a palavra " + (i + 1) +":").toLowerCase().trim();
            qtdCaracter[i] = CountLetra(palavras[i]);
        }

        //Exibindo resposta:
        ExibeResposta(palavras, qtdCaracter);
        
}
}