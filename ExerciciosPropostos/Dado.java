package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class Dado {
    public static void main(String[] args){
        int[] dado = {1,2,3,4,5,6};
        int soma = 0;
        int[] jogadas = new int[3];

        //Sorteando números:
        for(int i = 0; i < 3; i++){
            int aleatorio = (int)(Math.random() * 7);
            soma += dado[aleatorio];

            jogadas[i] = dado[aleatorio];
            
        }

        //Exibindo resultado:
        String msg = String.format("Número sorteado: %d\nNúmero Sorteado: %d\nNúmero Sorteado: %d\nSoma dos pontos: %d", jogadas[0], jogadas[1], jogadas[2], soma);
        JOptionPane.showMessageDialog(null, msg);
        
    }
}
