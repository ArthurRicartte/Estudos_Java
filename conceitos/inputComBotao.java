package conceitos;
import javax.swing.JOptionPane;

public class inputComBotao {

    public static void main(String args[]){
        int a, b = 0;
        //Lendo a
        String entrada = JOptionPane.showInputDialog("Digite o valor de A:");
        a = Integer.parseInt(entrada);

        //Lendo b
        entrada = JOptionPane.showInputDialog("Digite o valor d b:");
        b = Integer.parseInt(entrada);

        System.out.println(a);//Só pra testar
        int resultado = a*b;
        
        //Exibindo resultado
        JOptionPane.showMessageDialog(null,a + "x" + b + "x" + "=" + resultado);

    }
    
}