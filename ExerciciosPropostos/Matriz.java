package ExerciciosPropostos;
import javax.swing.JOptionPane;

public class Matriz{
    
    //Funcao para determinate da 3x3:
    public static int Determinate3x3(int[][] m){
        int determinante = 
            m[0][0] * m[1][1] * m[2][2] +
            m[0][1] * m[1][2] * m[2][0] +
            m[0][2] * m[1][0] * m[2][1] -
            m[0][2] * m[1][1] * m[2][0] -
            m[0][0] * m[1][2] * m[2][1] -
            m[0][1] * m[1][0] * m[2][2];
        
        return determinante;
    }

    //Funcao para calcular o determinante da 4x4:
    public static int Determinate4x4(int[][] m){
        int determinante = 0;
        int sinal = 1;

        for(int i = 0; i < m.length; i++){
            //O calculo de determinante da matriz 4x4, tem que gerar uma submatriz para cada termo da primeira linha
            int[][] submatriz = GerarSubmatriz(m, 0, i);
            determinante += sinal * m[0][i] * Determinate3x3(submatriz);
            sinal *= -1; //No calculo da determinante voce soma e em seguinda subtrai, por isso essa linha intercala a operecao
        }

        return determinante;
    }

    //Funcao para gerar determinante da 5x5:
    public static int Determinante5x5(int [][]m){
        int determinante = 0;
        int sinal = 1;

        for(int coluna = 0; coluna < m.length; coluna++){
            int[][] submatriz = GerarSubmatriz(m, 0, coluna);
            //Aqui, é necessário um passo a mais, gerar uma submatriz 4x4 -> calcular o determinante dela
            determinante += sinal * m[0][coluna] * Determinate4x4(submatriz);
            sinal *= -1;
        }

        return determinante;
    }

    //Funcao para gerar submatriz 3x3 (para determinate de 4x4 e 5x5):
    public static int[][] GerarSubmatriz(int[][] m, int linhaExcluida, int colunaExcluida){
        int size = m.length;
        int[][] submatriz = new int[size - 1][size - 1];
        
        int subLinha = 0;
        //Travamos a primeira linha, e uma coluna por vez, geranda uma 3x3
        for(int l = 0; l < size; l++){
            if (l == linhaExcluida){
                continue;
            }

            int subColuna = 0;
            for(int c = 0; c < size; c++){
                if (c == colunaExcluida){
                    continue;
                }

                submatriz[subLinha][subColuna] = m[l][c];
                subColuna++;
            }
            subLinha++;
        }

        return submatriz;
    }

    //Funcao para gerar numeros parar a Matriz(25% de chance de cair zero):
    public static int randomProbabilidadeZero(){
        
        int chance = (int)(Math.random() * 4); // 0 a 3 → 25% de chance de cair 0
        if (chance == 0) return 0;
        // Caso contrário, sorteia entre -9 a 9:
        int n = (int)(Math.random() * 18) - 9;
        return n;
    }


    //Funcao para gera Matriz:
    public static void GerarMatriz(int[][] m){
        for (int l = 0; l < m.length; l++){
            for (int c = 0; c < m[l].length; c++){
                
                //gerando numero aleatorio:
                m[l][c] = randomProbabilidadeZero();
                
                //Exibindo Matriz:
                System.out.printf(" %d ", m[l][c]);
            }
            System.out.printf("\n");
        }
    }
    
    public static void main(String args[]){
        int linha, coluna;

        while(true){
            String aux = JOptionPane.showInputDialog("Digite a linha: ");
            linha = Integer.parseInt(aux);
            
            aux = JOptionPane.showInputDialog("Digite a coluna: ");
            coluna = Integer.parseInt(aux);

            //Recebendo valores:
            if ((linha >= 2 && linha <= 5) && ((coluna >= 2 && coluna <= 5))){
                break;
            }else{ 
                if((linha < 2 || linha > 5) && (coluna >= 2 && coluna <= 5)){
                    JOptionPane.showMessageDialog(null, "[Error] digite um numero para a linha entre 2 e 5!");
                } else if ((coluna < 2 || coluna > 5) && (linha >= 2 && linha <= 5)){
                    JOptionPane.showMessageDialog(null, "[Error] digite um numero para coluna entre 2 e 5!");
                } else{
                    JOptionPane.showMessageDialog(null, "[Error] digite um numero para coluna e outro para a linha entre 2 e 5!");
                }
            }
        }

        int[][] matriz = new int[linha][coluna];
        //Gerando matriz:
        GerarMatriz(matriz);
        System.out.println();

        //Calcular diagonal principal e secundária:
        int diagonalPrincipal = 1;
        int diagonalSecundaria = 1;

        for (int l = 0; l < matriz.length; l++){
            for (int c = 0; c < matriz[l].length; c++){
                if(l == c){
                    diagonalPrincipal *= matriz[l][c];
                }

                if(l + c == coluna - 1){
                    diagonalSecundaria *= matriz[l][c];
                }
            }
        }

        System.out.printf("D1: %d\nD2: %d\n", diagonalPrincipal, diagonalSecundaria);

        //Calcular determinate 2x2 e 3x3:
        if((linha == 2) && (coluna == 2)){
            System.out.printf("Dterminate da 2x2: %d", (diagonalPrincipal - diagonalSecundaria));
        }
        else if((linha == 3) && (coluna == 3)){
            System.out.printf("Determinate da 3x3: %d\n", Determinate3x3(matriz));
        }else if(linha == 4 && coluna == 4){
            System.out.printf("Determinante da 4x4: %d\n", Determinate4x4(matriz));
        }else if(linha == 5 && coluna == 5){
            System.out.printf("Determinante da 5x5: %d\n", Determinante5x5(matriz));
        }
        else{
            System.out.printf("Por enquanto, nao consigo calcular esse determinate!\n");
        }
    }


}