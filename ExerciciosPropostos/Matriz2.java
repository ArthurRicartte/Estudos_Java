package ExerciciosPropostos;
public class Matriz2 {
    //Criei constantes para a linha e coluna
    public static final int LINHA = 4;
    public static final int  COLUNA = 3;

    //Funcao para preenhcer matriz com numeros aleatorios
    public static void PreencherMatriz(int[][] vetor){
        for(int linha = 0; linha < vetor.length; linha ++){
            for(int coluna = 0; coluna < vetor[linha].length; coluna++){
                //Dessa forma geramos numeros aletaorios no formato [min, max]
                vetor[linha][coluna] = -100 + (int) (Math.random() * (100 + 100 + 1));
            }
        }
    }

    //Funcao para exibir matriz
    public static void ExibeMatriz(int[][] matriz){
        for(int linha = 0; linha < matriz.length; linha ++){
            for(int coluna = 0; coluna < matriz[linha].length; coluna++){
                //%6d exibe o numero centralizado em 6 digitos
                String num = String.format("%6d", matriz[linha][coluna]);
                System.out.printf(num);
            }
            System.out.println("");
        }
    }

    //Funcao para somar matriz
    public static void SomaMatriz(int[][] resultado, int[][] a, int[][]b){
        for(int linha = 0; linha < resultado.length; linha ++){
            for(int coluna = 0; coluna < resultado[linha].length; coluna++){
                resultado[linha][coluna] = a[linha][coluna] + b[linha][coluna];
            }
        }
    }

    //Funcao para subtrair matriz
    public static void SubtraiMatriz(int[][] resultado, int[][] a, int[][]b){
        for(int linha = 0; linha < resultado.length; linha ++){
            for(int coluna = 0; coluna < resultado[linha].length; coluna++){
                resultado[linha][coluna] = a[linha][coluna] - b[linha][coluna];
            }
        }
    }

    
    //Funcao para multiplicar matriz
    public static void ProdutoMatriz(int[][] resultado, int[][] a, int[][]b){
        for(int linha = 0; linha < resultado.length; linha++){
            for(int coluna = 0; coluna < resultado[linha].length; coluna++){
                resultado[linha][coluna] = a[linha][coluna] * b[linha][coluna];
            }
        }
    }
    public static  void main(String args[]) {
        int[][] b = {{ 2, -3, 5 },
                    { -1, 4, 0 },
                    { 7, 8, -6 },
                    { 9, -2, 1 }};

        int [][] a = new int[LINHA][COLUNA];
        int[][] soma = new int[LINHA][COLUNA];
        int[][] subtracao = new int[LINHA][COLUNA];
        int[][] produto = new int[LINHA][COLUNA];

        //Exibicao de resultados
        System.out.println("-------Matriz B-------");
        ExibeMatriz(b);

        System.out.println("-------Matriz A-------");
        PreencherMatriz(a);
        ExibeMatriz(a);

        System.out.println("-------Matriz SOMA-------");
        SomaMatriz(soma, a, b);
        ExibeMatriz(soma);

        System.out.println("-------Matriz SUBTRACAO-------");
        SubtraiMatriz(subtracao, a, b);
        ExibeMatriz(subtracao);
        
        System.out.println("-------Matriz MULTIPLICACAO-------");
        ProdutoMatriz(produto, a, b);
        ExibeMatriz(produto);
    
    }
}
