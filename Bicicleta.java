import javax.swing.text.Utilities;
import java.io.Serializable;

public class Bicicleta extends Veiculo implements Serializable{
    private String[] desenho = new String[3];

    public Bicicleta(int id){
        super(id, 2);

        desenho[0]="   __o\n";
        desenho[1]=" _`\\<,_\n";
        desenho[2]="(*)/ (*)\n\n";

    }

    public boolean mover(){
        
        if(!super.rodasCalibradas()){
            System.out.println("Rodas descalibradas");
            return false;
        }

        super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 2);

        return true;
    }

    public String toString(){
        return "\nBicicleta\n" + super.toString();
    }

    private void auxiliaDesenho(int dist){
        System.out.print(" ");
    }

    public void desenhar(){
        int aux = (Veiculo)super.getDistanciaPercorrida();

        System.out.print("ID: " + (Veiculo)super.getID());

        auxiliaDesenho(aux); System.out.print(desenho[0]);
        auxiliaDesenho(aux); System.out.print(desenho[1]);
        auxiliaDesenho(aux); System.out.print(desenho[2]);
    }
}
