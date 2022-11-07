import java.util.Random;
import java.util.Scanner;

public class Simulador {
    private Veiculo[] competidores;
    private int qtdVeiculos;
    private final int MAXVEICULOS;

    public Simulador(){
        MAXVEICULOS = 20;
        competidores = new Veiculo[MAXVEICULOS];
        qtdVeiculos = 0;
    }


    public int incluirVeiculo(char escolha){

        for(int i = 0; i < this.MAXVEICULOS; i++){

            if(competidores[i] == null){

                if(escolha != 'B' && escolha != 'M' && escolha != 'C' && escolha != 'E'){
                    System.out.println("Tipo invalido");
                    return -1;
                }

                Random r = new Random();
                int id = r.nextInt(9000) + 1000;

                switch(escolha){
                    case 'B':
                    competidores[i] = new Bicicleta(id); break;

                    case 'M': 
                    competidores[i] = new Motocicleta(id); break;
                    
                    case 'C': 
                    competidores[i] = new CarroPasseio(id); break;

                    case 'E': 
                    competidores[i] = new Esportivo(id); break;
                }
                
                qtdVeiculos++; 
                return id;         
            }
        }
        return -1;
    }

}

    /*public boolean RemoveVeiculo(int id){

    }*/
