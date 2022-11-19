import java.util.Scanner;
import java.util.zip.DeflaterOutputStream;
import java.io.IOException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class UsaSimulador {
    public static void main(String[] args) throws IOException {
        System.out.println("Bem Vindo ao Simulador Corrida Maluca!");
        Simulador s = new Simulador();
        Scanner teclado = new Scanner(System.in);
        int escolha, id;

        do{
            escolha = menu();

            switch(escolha){

                case 1:// incluir veiculo
                    id = s.incluirVeiculo(pedirTipo());
                    if(id != -1){
                        System.out.println("veiculo de ID: " + id);
                    }
                    else{
                        System.out.println("Veiculo nao inserido.");
                    }
                break;

                case 2:
                    if(s.getQtdVeiculos() > 0){
                        id = pedirID(s);
                        if((id != -1)){
                            s.removerVeiculo(id);
                            System.out.println("Veiculo removido com sucesso.");
                        }
                        else{
                            System.out.println("Veiculo nao encontrado.");
                        }
                    }
                    else{
                        System.out.println("Nao ha veiculos para remover.");
                    }

                break;

                case 3:
                    /*float gas;
                    try{
                        do{
                            System.out.print("Informe a quantidade de combustivel: ");
                            gas = teclado.nextFloat();
                            
                            if(gas <= 0){
                                System.out.println("Valor invalido.");
                            }

                        }while(gas <= 0);
                    }
                    catch(Exception e){
                        System.out.println("Dado invalido");  
                    }
                    
                    id = pedirID(s);

                    if(id != -1){
                        s.abastecerVeiculo(id, gas);
                    }
                    else{
                        System.out.println("Veiculo nao encontrado."); 
                    }*/


                break;

                case 4:
                break;

                case 5:
                break;

                case 6:
                break;

                case 7:
                    s.imprimirDados();
                break;

                case 8:
                    s.imprimirDados(pedirTipo());
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
                File arquivo1 = new File("Corrida.dat");

                    try{
                        FileOutputStream fout = new FileOutputStream(arquivo1);
                        ObjectOutputStream oos = new ObjectOutputStream(fout);

                        oos.writeObject(s);

                        oos.flush();
                        oos.close();
                        fout.close();
                        System.out.print("\nGravado com Sucesso.\n");

                    }catch(Exception ex){
                        System.err.println("Erro: "+ ex.toString());
                    }
                break;

                case 14:
                File arquivo2 = new File("Corrida.dat");
                    try{
                        FileInputStream fin = new FileInputStream(arquivo2);
                        ObjectInputStream oin = new ObjectInputStream(fin);

                        s = (Simulador) oin.readObject(); 
                        oin.close();
                        fin.close();


                    }catch(Exception ex){
                        System.err.println("Erro: "+ ex.toString());
                    }
                break;
            }
            System.out.print("Precione Enter para continuar...");   
            System.in.read();

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

        try{
            System.out.print("Digite a opcao: ");
            escolha = teclado.nextInt();

            while(escolha < 1 || escolha > 15){
                System.out.print("Valor Invalido\n Digite novamente: ");
                escolha = teclado.nextInt();
            }
            
            return escolha;
        }
        catch(Exception e){
            System.out.println("Dado invalido");   
            return 0;
        }
    }

    public static char pedirTipo(){

        Scanner teclado = new Scanner(System.in);
        char escolha = 'a';
        boolean invalido;

       try{
            do{
                System.out.print("Digite o tipo do veiculo (B - Bicicleta, P - Carro Popular, E - Carro Esportivo, M - Motocicleta): ");
                escolha = teclado.next().charAt(0);
                escolha = Character.toUpperCase(escolha);
                System.out.println(escolha);
                invalido = ((escolha != 'B') && (escolha != 'P') && (escolha != 'E') && (escolha != 'M'));
                if(invalido){
                    System.out.println("Tipo invalido");
                }
            }while(invalido);
        }
        catch(Exception e){
            System.out.println("Dado Invalido.");
        }

        return escolha;
    }

    public static int pedirID(Simulador s){
        Scanner teclado = new Scanner(System.in);
        int id;

        try{
            System.out.print("Digite o ID do veiculo que desejas remover: ");      
            if(s.buscarCompetidor(id = teclado.nextInt()) != -1){
                return id;
            }
        }
        catch(Exception e){
            System.out.println("Dado Invalido.");
        }
        return -1;
    }
}
