package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class FifoHistorico {
    public static void ExibeHistórico(String[] historico){
        String msgExibida = "";
                for(int i = 0; i < 5; i++){
                    msgExibida += historico[i] + "\n";
                }

                JOptionPane.showMessageDialog(null, msgExibida);
    }

    public static void Fifo(String[] historico, String msg, int cont){
        
        if (cont >= 5){
                for(int i = 0; i < historico.length - 1; i++){
                    historico[i] = historico[i + 1];
            }

            historico[historico.length - 1] = msg;
            
            }else{
                historico[cont] = msg;
            }
    }
    public static void main(String args[]){
        String[] historico = new String[5];

        int cont = 1;

        while (true) {
            String entrada = JOptionPane.showInputDialog("Digite algo (digite sair para encerrar): ");
            
            if (entrada.equalsIgnoreCase("sair")){
                break;
            }

            String msg = String.format("Mensagem %d: %s", cont, entrada);

            Fifo(historico,msg, cont);

            if (cont >= 5){
                ExibeHistórico(historico);
            }

            cont++;
                        
        }

    }
}
