package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class Calculadora{
    /**Criando uma string opara armazenar as opercoes e um contador
    *(nimguem precisa mecher nessas variaveis, entao deixei elas privadas)**/
    private static String[] historico = new String[5];
    private static int contadorHistorico = 0;
    
    public static int Soma(int a, int b){
        return (a + b);
    }

    public static int Subtracao(int a, int b){
        return (a - b);
    }
    
    public static int Multiplicacao(int a, int b){
        return (a * b);
    }
    
    public static double divisao(int a, int b){
        return (a *1.0 / b);
    }
    

    public static void AdcionarHistorico(String conta){
        //Se menor que 5, add normalmente no historico
        if(contadorHistorico < 5){
            historico[contadorHistorico] = conta;
        } else{
            //Se maior que 5, alguem vai ter que sair (o primeiro adicionado)
            for(int i = 0; i < 4; i++){
                historico[i] = historico[i + 1];
            }

            /**nesse programa o elemento de indice 0 fica com o elemento de indice 1, o 1 com o 2...
            * e o elemento de indice 4 vai ficar com o que foi digitado por ultimo e nao tinha "uma vaga" no historico**/
            
            historico[4] = conta;
        }

        //Se for menor que 5 -> ainda tem espaco no historico -> adiciona +1 em contadorHistorico
        if (contadorHistorico < 5){
            contadorHistorico++;
        }
    }

    public static void MostrarHistorico(){
        //Uma forma interressante para exibir um string com JOptionPane
        StringBuilder msg = new StringBuilder();
        
        if (contadorHistorico == 0){
            msg.append("Nenhuma operacao foi realizada ainda.");
        }else if (contadorHistorico == 1) {
            msg.append("A ultima opercao:\n\n");
        }else{
            msg.append("As ultimas " + contadorHistorico + " operacoes:\n\n");
        }        

        if(contadorHistorico > 0){
            for(int i = 0; i < contadorHistorico; i ++){
                msg.append(historico[i]);
                msg.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, msg.toString());
    }

    public static void ExibeResultado(int sinal, int n1, int n2){
        String resultado = "";

        if (sinal == 1){
            resultado = n1 + " + " + n2 + " = " + Soma(n1, n2);    
            JOptionPane.showMessageDialog(null, n1 + " + " + n2 + " = " + Soma(n1, n2));
           }
           if(sinal == 2){
                resultado = n1 + " - " + n2 + " = " + Subtracao(n1, n2);
                JOptionPane.showMessageDialog(null, n1 + " - " + n2 + " = " + Subtracao(n1, n2));
           } 
           if(sinal == 3){
                resultado = n1 + " x " + n2 + " = " + Multiplicacao(n1, n2);
                JOptionPane.showMessageDialog(null, n1 + " x " + n2 + " = " + Multiplicacao(n1, n2));
           } 
           if(sinal == 4){
                resultado = String.format("%d / %d = %.2f", n1, n2, divisao(n1, n2));
                JOptionPane.showMessageDialog(null, resultado);
           }
           
           AdcionarHistorico(resultado);
    }
    
    public static void main(String args[]){
        int operacao = 0;
        int num1, num2;
        
        //Implementando o menu:
        while(true){
            String choice = JOptionPane.showInputDialog("Somar[1]\nSubtrair[2]\nMultiplicar[3]\nDividir[4]\nConsultar Historico[5]\nSair[6]");
            operacao = Integer.parseInt(choice);

            //Verificando se digitou alog indesejado ou se pediu para sair:
            if (operacao < 1 || operacao > 6){
                JOptionPane.showMessageDialog(null, "Operacao nao reconhecida.");
                continue;
            }
            
            if(operacao == 5){
                MostrarHistorico();
                continue;
            }

            if (operacao == 6){
                break;
            }

            //Colhendo os numeros:
            choice = JOptionPane.showInputDialog("Digite o primeiro numero:");
            num1 = Integer.parseInt(choice);
            
            choice = JOptionPane.showInputDialog("Digite o segundo numero:");
            num2 = Integer.parseInt(choice);
           
           //Chamando o metodo para mostrar a resposta:
           ExibeResultado(operacao, num1, num2);

        }

        System.out.println("Acabou.");
    }
}