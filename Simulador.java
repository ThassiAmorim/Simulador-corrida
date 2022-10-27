import java.util.Random;
import java.util.Scanner;

public class Simulador {
    Veiculo[] competidores = new Veiculo[20];
    int qtdVeiculos;

    public boolean incluirVeiculo(char escolha){

        for(int i = 0; i < this.qtdVeiculos; i++){

            if(competidores[i] == null){

                if(escolha != 'B' && escolha != 'M' && escolha != 'C' && escolha != 'E'){
                    System.out.println("Tipo invalido");
                    return false;
                }

                Random r = new Random(System.in);
                int id = r.nextInt(9000) + 1000;
                
                if(escolha == 'B'){
                    competidores[i] = new Bicicleta(id);
                }
                if(escolha == 'M'){
                    competidores[i] = new Motocicleta(id);
                }
                if(escolha == 'C'){
                    competidores[i] = new Popular(id);
                }
                if(escolha == 'E'){
                    competidores[i] = new Esportivo(id);
                }    
                
            }
        }
    }
}
