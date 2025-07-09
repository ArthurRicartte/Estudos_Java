package conceitos;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        int peso = 68;
        float altura = 1.70F;
        double imc = peso / (altura * altura);

        // Fazendo um input de um número inteiro:
        Scanner leitor = new Scanner(System.in);
        System.out.print("Digite um número inteiro: "); // Mensagem para o usuário
        int numero = leitor.nextInt(); // Lê um int
    
        System.out.printf("O IMC calculado para o número %d é: %.1f%n", numero, imc);
        leitor.close();
    }
}