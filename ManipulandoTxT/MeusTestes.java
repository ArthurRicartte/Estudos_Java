package ManipulandoTxT;
import java.util.Scanner;
import java.io.*;

public class MeusTestes {
    public static void main(String args[]){
    
    //Criando uma variavel para ler o txt:
    File arquivo = new File("dados.txt");

    //Tenta ler ler o arquivo
    try(Scanner leitor = new Scanner(arquivo)){
        
        //Variavel para controlar se foi encontrado ou nao um usuario no txt
        boolean UsuarioEncontrado = false; 
        
        //criando variaveis para ler o que for digitado pelo usuario
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome de usuario:");
        String palavraUsuario = input.nextLine();

        //Se nao for digitado nada
        if (palavraUsuario == null || palavraUsuario.trim().isEmpty()){
            System.out.println("Usuário não digitado.");
        }

        //So vai verficar se tiver linhas para ler e se nao tiver encontrado o usuario correspondente
        while (leitor.hasNextLine() && !UsuarioEncontrado){
            //Pega a linha e divide cada palavra de acordo com o split
            String linha = leitor.nextLine();
            String[] palavras = linha.split(",");
            
            //For each para iterar as palavras separadas pelo split
            for (String palavra : palavras){
                
                /**Aqui, eh verificado se o que foi digitado esta presente no txt, note que usei um 
                toLowerCase() para deixar tudo em minusculo e facilitar a comparacao**/
                if (palavraUsuario.toLowerCase().equalsIgnoreCase(palavra.toLowerCase())){
                    System.out.println("Usuário encontrado: " + palavra);
                    UsuarioEncontrado = true;
                    break;
                }
            }    
        }

        //Caso nao seja encontrado nada
        if (!UsuarioEncontrado) {
                System.out.println("Usuário Não encontrado");
        }

        input.close();
    
    //Tratamento de erro:
    } catch(FileNotFoundException e){
        System.out.println("Arquivo nao encontrado: " + e.getMessage());
    }
    
    }    
}
