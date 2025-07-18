package ExerciciosPropostos;
import javax.swing.JOptionPane;
import java.util.Arrays;

public class SortNotas {
    public static void main(String args[]){
        double[] notas = new double[5];
        double somatorio = 0f, media = 0f;
       
        for(int i = 0; i < 5; i++){
            String msg = String.format("Digite a %d nota:", i + 1);
            String entrada = JOptionPane.showInputDialog(msg);
            
            notas[i] = Double.parseDouble(entrada);
            somatorio += notas[i];
        }

        //organizando o array:
        Arrays.sort(notas);
       
        //Media:
        media = somatorio / notas.length;

        //exibindo resultados:
        String msgFinal = String.format("A media eh: %.1f\nMaior nota: %.1f\nMenor nota: %.1f", media, notas[0], notas[notas.length - 1]);
        JOptionPane.showMessageDialog(null, msgFinal);
    
    }
}
