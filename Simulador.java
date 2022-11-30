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

                    default:
                        return -1;
                }
                
                qtdVeiculos++; 
                return id;         
            }
        }
        return -1;
    }

    public boolean abastecerVeiculo(int id, float f){
        int v = buscarCompetidor(id);
        if (!(competidores[v] instanceof Bicicleta)){
            ((VeiculoMotorizado)competidores[v]).abastecer(f);
            
            return true;
        }
        System.out.println("bicicleta nao abastece");
        return false;
    }

    public int buscarCompetidor(int ID){
        for(int i = 0; i < competidores.length; i++){
            if(competidores[i] != null && competidores[i].getID() == ID){
                return i;
            }
        }
        return -1;
    }

    public void exibirCompetidores(){
        String tipo = new String(); 
        for(int i = 0; i < competidores.length; i++){
            if(competidores[i] != null){
                if(competidores[i] instanceof Bicicleta){ tipo = "Bicicleta";}
                else if(competidores[i] instanceof CarroPasseio){ tipo = "Carro de Passeio";}
                else if(competidores[i] instanceof Esportivo){ tipo = "Esportivo";}
                else{ tipo = "Motocicleta";}

                System.out.println(competidores[i].getID() + " - " + tipo);
            }
        }
    }

    public boolean removerVeiculo(int id){
        if(id != -1){
            competidores[buscarCompetidor(id)] = null;
            qtdVeiculos--;
            return true;
        }
        
        return false;
    }

    public void movimentar(ind id){
        
        int n = buscarCompetidor(id);
        if(competidores[n] instanceof Bicicleta){
            return ((Bicicleta)competidores[n]).Mover();    
        }
        else if(competidores[n] instanceof CarroPasseio){
            ((CarroPasseio)competidores[n]).Mover();
            return 
        }
        else if(competidores[n] instanceof Esportivo){
            return ((Esportivo)competidores[n]).Mover();
        }
        else if(competidores[n] instanceof Motocicleta){  
            return ((Motocicleta)competidores[n]).Mover();
        }
        else 
            return false;
        
    }


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

    public bollean calibrar(ind id){

        



    }

}
