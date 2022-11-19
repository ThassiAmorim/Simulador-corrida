import java.util.Random;
import java.util.Scanner;
import java.io.Serializable;

public class Simulador implements Serializable{
    private Veiculo[] competidores;
    private int qtdVeiculos;
    private final int MAXVEICULOS;

    public Simulador(){
        MAXVEICULOS = 20;
        competidores = new Veiculo[MAXVEICULOS];
        qtdVeiculos = 0;
    }

    public int getQtdVeiculos(){
        return qtdVeiculos;
    }


    public int incluirVeiculo(char escolha){

        for(int i = 0; i < this.MAXVEICULOS; i++){

            if(competidores[i] == null){

                Random r = new Random();
                int id = r.nextInt(9000) + 1000;

                switch(escolha){
                    case 'B':
                    competidores[i] = new Bicicleta(id); break;

                    case 'M': 
                    competidores[i] = new Motocicleta(id); break;
                    
                    case 'P': 
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

    public int buscarCompetidor(int ID){
        for(int i = 0; i < competidores.length; i++){
            if(competidores[i] != null && competidores[i].getID() == ID){
                return i;
            }
        }
        return -1;
    }

    public void removerVeiculo(int id){
        competidores[buscarCompetidor(id)] = null;
        qtdVeiculos--;
    }

    /*public void abastecerVeiculo(int id, float f){
        competidores[buscarCompetidor(id)].abastecer(f);
    }*/

    public void imprimirDados(){
        for(int i = 0; i < competidores.length; i++){
            if(competidores[i] != null ){
                System.out.println(competidores[i]);
            }
        }
    }

    public void imprimirDados(char escolha){
        switch(escolha){
            case 'B':
            for(int i = 0; i < competidores.length; i++){
            if(competidores[i] != null && competidores[i] instanceof Bicicleta){
                System.out.println(competidores[i]);
            }
            } break;

            case 'M': 
            for(int i = 0; i < competidores.length; i++){
                if(competidores[i] != null && competidores[i] instanceof Motocicleta){
                    System.out.println(competidores[i]);
                }
            } break;
            
            case 'P': 
            for(int i = 0; i < competidores.length; i++){
                if(competidores[i] != null && competidores[i] instanceof CarroPasseio){
                    System.out.println(competidores[i]);
                }
            } break;

            case 'E': 
            for(int i = 0; i < competidores.length; i++){
                if(competidores[i] != null && competidores[i] instanceof Esportivo){
                    System.out.println(competidores[i]);
                }
            } break;
        }
    }

}
