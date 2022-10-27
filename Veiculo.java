import java.util.Random;

public abstract class Veiculo {
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

    public abstract boolean mover();

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }
        
    


}
