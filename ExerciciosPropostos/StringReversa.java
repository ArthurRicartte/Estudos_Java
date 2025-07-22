package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class StringReversa {
    public static void main(String args[]){
    
        String fraseDigitada = JOptionPane.showInputDialog("Insira Texto:");
        fraseDigitada = fraseDigitada.trim(); //Retirando espacos iniciais e finais.
                
        String invertida = inverterFrase(fraseDigitada);
        JOptionPane.showMessageDialog(null, "Frase invertida(Sem espacos): " + invertida);

    }

public static String inverterFrase(String s){

    String fraseSemEspacos = "";
    for (int i = 0; i < s.length(); i++){
        
        //Aqui, pegamos um caractere por vez (nao conta o i + 1, so o i)
        String caractere = s.substring(i, i + 1);

        //Aqui analisamos se ha espacos entre letras, e nao contabilizamos (frase sem nenhum espaco formada).
        if (!caractere.equals(" ")) {
            fraseSemEspacos += caractere;
        }
    }

    //Formando a frase invertida
    String fraseInvertida = "";
    for (int i = fraseSemEspacos.length() - 1; i >= 0; i--){
        fraseInvertida += fraseSemEspacos.substring(i, i + 1); 
    }

    return fraseInvertida;
}
}
