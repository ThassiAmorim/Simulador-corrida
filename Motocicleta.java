import java.util.Random;
import java.io.Serializable;

public class Motocicleta extends VeiculoMotorizado implements IPVA, Serializable {
    private String[] desenho = new String[3];
    private static final float GASTOMOTOCICLETA = 0.25f;


    public Motocicleta(int id){
        super(id, 4, IPVA.VALOR_BASE * IPVA.CTE_MOTOCICLETA, (new Random()).nextFloat() * 500);
        
    
        desenho[0]="   ,_oo\n";
        desenho[1]=".-/c-//::\n";
        desenho[2]="(_)'==(_)\n\n";

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < this.GASTOMOTOCICLETA){
            System.out.println("Combustivel insuficiente");
            valida = false;
        }
        if(!super.rodasCalibradas()){
            valida = false;
        }
        
        if(!this.isPagoIPVA()){
            System.out.println("Ipva nao pago");
            valida = false;
        }
        
        if(valida){
            super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 3);
        }
        
        return valida;
    }

    public String toString(){
        return "Motocicleta\n" + super.toString();
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
