package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class ReajustePreco {
    public static void main(String args[]){
        double valor = 0f;
        double reajuste = 1.12; //aumento de 12% -> 112% -> 1.12%

        while (true){
            
            //Lendo valores:
            String msg = JOptionPane.showInputDialog("Digite um valor (o para parar):");
            valor = Double.parseDouble(msg);

            //Condicao de parada:
            if (valor == 0){
                JOptionPane.showMessageDialog(null, "Programa finalizado.");
                break;
            }

            //Ja calcula diretemanete o reajuste no valor (valor = valor * reajuste)
            valor *= reajuste;
            
            //Exibindo resultado:
            String resposta = String.format("O novo valor do produto é: R$ %.2f", Math.ceil(valor));
            JOptionPane.showMessageDialog(null, resposta);
        }
    }
}