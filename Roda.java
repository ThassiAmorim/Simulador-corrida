import java.util.Random;
import java.io.Serializable;

public class Roda implements Serializable{
    
    private boolean calibragemPneu;

    public Roda(){
        Random r = new Random();
        this.calibragemPneu = r.nextBoolean();
    }
    
    public boolean getCalibragemPneu() {
        return calibragemPneu;
    }

    public void setCalibragemPneu(boolean calibragemPneu) {
        this.calibragemPneu = calibragemPneu;
    }



}
