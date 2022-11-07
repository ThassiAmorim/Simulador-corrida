import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;

public class UsaSimulador {
    public static void main(String[] args) {
        System.out.println("Bem Vindo ao Simulador Corrida Maluca!");
        Simulador s = new Simulador();
        int escolha;

        do{
            escolha = menu();

            switch(escolha){

                case 1:// incluir veiculo
                    int id = s.incluirVeiculo(pedirTipo());
                    if(id != -1){
                        System.out.printf("veiculo de ID: %d incluido com sucesso", id);
                    }
                    else{
                        System.out.println("falha ao inserir veiculo, por favor tente novamente");
                    }
                break;

                case 2:
                break;

                case 3:
                break;

                case 4:
                break;

                case 5:
                break;

                case 6:
                break;

                case 7:
                break;

                case 8:
                break;

                case 9:
                break;

                case 10:
                break;

                case 11:
                break;
                
                case 12:
                break;

                case 13:
                break;

                case 14:
                break;
            }


        }while(escolha != 15);

    }

    public static void imprimirMenu() {

        System.out.println("Menu: ");
        System.out.println("1) Incluir veiculo.");
        System.out.println("2) Remover veiculo.");
        System.out.println("3) Abastecer veiculo.");
        System.out.println("4) Movimentar veiculo especifico.");
        System.out.println("5) Movimentar veiculo por tipo.");
        System.out.println("6) Movimentar todos os veiculos.");
        System.out.println("7) Imprimir dados de todos os veiculos.");
        System.out.println("8) Imprimir dados de veiculos por tipo.");
        System.out.println("9) Calibrar/Esvaziar pneu especifico.");
        System.out.println("10) Calibrar todos os pneus de veiculos por tipo.");
        System.out.println("11) Esvaziar todos os pneus de veiculos por tipo.");
        System.out.println("12) Imprimir pista.");
        System.out.println("13) Gravar veiculos em arquivo.");
        System.out.println("14) Ler veiculos em arquivo.");
        System.out.println("15) Encerrar corrida.");

    }

    public static int menu() {
        Scanner teclado = new Scanner(System.in);
        int escolha;
        //boolean valida;

        imprimirMenu();

       // try{// nao ta executando esse try
            System.out.print("Digite a opcao: ");
            escolha = teclado.nextInt();

            while(escolha < 1 || escolha > 15){
                System.out.print("Valor Invalido\n Digite novamente: ");
                escolha = teclado.nextInt();
            }

        //}
        /*catch(Exception e){
          System.out.println("Valor invalido");   
       
     }*/
        
        return escolha;
    }

    public static char pedirTipo(){

        Scanner teclado = new Scanner(System.in);
        System.out.println("B P M E");
        char escolha = 'a';
        boolean invalido = true;

       // try{
            while(invalido){
                System.out.println("Digite o tipo do veiculo (B, P, E, M)");
                escolha = teclado.next().charAt(0);
                escolha = Character.toUpperCase(escolha);
                invalido = (escolha != 'B' && escolha != 'P' && escolha != 'E' && escolha != 'M');
                if(invalido){
                    System.out.println("Tipo invalido");
                }
            }
       // }
        /*catch(Exception e){
            System.out.println("dado inserido invalido");
        }*/

        return escolha;
    }
}
