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
                        if(s.removerVeiculo(pedirID(s))){
                            System.out.println("Veiculo removido com sucesso.");
                        }
                        else{
                            System.out.println("Veiculo nao removido.");
                        }
                    }
                    else{
                        System.out.println("Nao ha veiculos para remover.");
                    }

                break;

                case 3:
                    float gas = 0;
                    id = pedirID(s);

                    if(id != -1){
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
                        
    
                        
                        if(s.abastecerVeiculo(id, gas)){
                            System.out.println("Veiculo " + id + " abastecido com sucesso");
                        }
                        else{
                            System.out.println("falha ao abastecer veiculo");
                        }
                        
                    }
                    else{
                        System.out.println("veiculo nao encontrado");
                    }

                    break;

                case 4: // movimentar 1 veiculo
                    
                    if(s.movimentar(pedirID(s))){
                        System.out.println("Veiculo movido com sucesso");
                    }
                    else{
                        System.out.println("Erro ao mover veiculo");
                    }

                    break;

                case 5: // movimentar 1 tipo
                    
                    if(s.movimentar(pedirTipo())){
                        System.out.println("veiculos movidos com sucesso");
                    }    
                    else{
                        System.out.println("Não foi possivel mover todos os veiculos solicitados");
                    }

                    break;

                case 6:
                    if(s.movimentar()){
                        System.out.println("Veiculos movimentados com sucesso");
                    }
                    else{
                        System.out.println("Falha ao movimentar todos os veiculos");
                    }
                    
                break;

                case 7:
                    s.imprimirDados();
                break;

                case 8:
                    s.imprimirDados(pedirTipo());
                break;

                case 9:
                    if(s.calibrar(pedirID(s))){
                        System.out.println("Calibrado/Descalibrado com sucesso.");
                    }
                    else{
                        System.out.println("Ocorreu um erro.");
                    }

                break;

                case 10:
                    if(s.calibragemTipo(pedirTipo(), true)){
                        System.out.println("Calibrado com sucesso.");
                    }
                    else{
                        System.out.println("Ocorreu um erro.");
                    }
                    
                break;

                case 11:
                    if(s.calibragemTipo(pedirTipo(), false)){
                        System.out.println("Descalibrado com sucesso.");
                    }
                    else{
                        System.out.println("Ocorreu um erro.");
                    }
                break;
                
                case 12:
                    s.desenharPista();

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

                case 15:
                    s.vencedor();
                break;

            }
            System.out.print("Precione Enter para continuar...");   
            System.in.read();

        }while(escolha != 15);

    }

    public static void imprimirMenu() {

        System.out.println("\nMenu: ");
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
                System.out.print("Digite o tipo do veiculo (B - Bicicleta, P - Carro Passeio, E - Carro Esportivo, M - Motocicleta): ");
                escolha = teclado.next().charAt(0);
                escolha = Character.toUpperCase(escolha);
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
        int validaID;

        try{
            do{
                System.out.println("\nIDs disponiveis:");
                s.exibirCompetidores();
                
                System.out.print("\nDigite o ID do veiculo ou digite 0 para voltar ao menu principal: ");   
                id = teclado.nextInt();
                validaID = s.buscarCompetidor(id);

                if (id == 0){
                    return -1;
                }

                if( validaID != -1 ){
                    return id;
                }
                
                System.out.println("\nID nao encontrado");  
                
            }while (validaID == -1);
        }
        catch(Exception e){
            System.out.println("Dado Invalido.");
            return -1;
        }
        return -1;
    }
}
