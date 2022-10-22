import java.util.Random;

public class Roda {
    
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
