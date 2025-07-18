import java.util.Scanner;;

public class TestandoExibicaoFUncao {

    public static void main(String[] args){
        int[] vetor = new int[10];

        Scanner input = new Scanner(System.in);

        
        for(int indice = 0; indice < 10; indice++){
            System.out.printf("Digite o %d numero:", indice + 1);
            vetor[indice] = input.nextInt();
        }
        
        input.close();
        System.out.println("-----------------------------------------");

        for(int i = 0; i < 10; i++){
            System.out.println(vetor[i]);
        }
    }


    public void ImprimePalavra(){
        System.out.println("Your phone lingi, your phone lingi");
    }
}