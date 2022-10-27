import java.util.Scanner;

public class UsaSimulador {
    public static void main(String[] args) {
        


    }

    public static void menu() {
        //printa as opcao isaac
    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        boolean valida;

        do{
    
            System.out.println("Digite a opcao");
            escolha = teclado.nextLine();

            if(valida = (escolha < 1 && escolha > 15)){
                System.out.println("Opcao invalida");
            }

        }while(valida);
        
        
    }

    public static char pedirTipo(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("B P M ");
        char escolha = teclado.nextLine();
        return escolha;
    }
}
