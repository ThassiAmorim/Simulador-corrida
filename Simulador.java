import java.util.Random;
import java.util.Scanner;

public class Simulador {
    Veiculo[] competidores = new Veiculo[20];
    int qtdVeiculos;

    public incluirVeiculo(int tipo){/teste

        for(int i = 0; i < this.qtdVeiculos; i++){

            if(competidores[i] == null){
                Scanner teclado = new Scanner(System.in);
                char escolha;

                while(escolha != 'B' && escolha != 'M' && escolha != 'C' && escolha != 'E'){
                    System.out.println("Qual tipo de veiculo deseja incluir?");
                    escolha = teclado.next();
                }

                Random r = new Random(System.in);
                
                if(escolha == 'B'){
                    competidores[i] = new Bicicleta(r.nextInt(6));
                }
                if(escolha == 'M'){
                    competidores[i] = new Morocicleta(r.nextInt(6));
                }
                if(escolha == 'C'){
                    competidores[i] = new Popular(r.nextInt(6));
                }
                if(escolha == 'E'){
                    competidores[i] = new Esportivo(r.nextInt(6));
                }    
                
            }
        }
    }
}
