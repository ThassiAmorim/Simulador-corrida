import java.util.Random;
import java.io.Serializable;

public abstract class Veiculo implements Serializable{
    private int id;
    private int distanciaPercorrida;
    private Roda[] rodasVeiculo;
    private int quantidadeRodas;

    public Veiculo(int id, int quantidadeRodas){
        Random r = new Random();
        this.id = id;
        this.distanciaPercorrida = 0;
        this.quantidadeRodas = quantidadeRodas;
        this.rodasVeiculo = new Roda[quantidadeRodas];
        
        for(int i = 0; i < quantidadeRodas; i++){
            rodasVeiculo[i] = new Roda();
        }
    } 

    public int getQuantidadeRodas(){
        return quantidadeRodas;
    }

    public abstract boolean mover();

    public int getID(){
        return id;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
        
    public boolean rodasCalibradas(){
        for(int i = 0; i < quantidadeRodas;i++){
            if(!rodasVeiculo[i].getCalibragemPneu()){
                return false;
            }
        }
        return true;
    }

    public void calibragem(int pos, int v){
        if(v == 1){
            rodasVeiculo[pos].setCalibragemPneu(true);
        }
        else{
            rodasVeiculo[pos].setCalibragemPneu(false);
        }
    }

    public boolean calibragemPneus(boolean calibragem){
        for(int i = 0; i < quantidadeRodas; i++){
            rodasVeiculo[i].setCalibragemPneu(calibragem);
        }
        return true;
    }

    public abstract void desenhar();


    public String toString(){
        return "ID: " + this.id + ".\n";
    }

}
