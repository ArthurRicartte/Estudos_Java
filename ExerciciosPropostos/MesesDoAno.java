package ExerciciosPropostos;
public class MesesDoAno {
    
    public static int GeraNum(){
        return (int)(Math.random() * 10 + 1);
    }
    
    public static void main(String[] args){
        String[] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro","Dezembro",};
        int mesAleatorio = GeraNum();

        System.out.println(meses[mesAleatorio]);
        System.out.println(mesAleatorio);
        
    }
}
