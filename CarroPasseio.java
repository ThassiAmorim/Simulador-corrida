import java.util.Random;
import java.io.Serializable;

public class CarroPasseio extends VeiculoMotorizado implements IPVA, Serializable {
    private String[] desenho = new String[4];
    private static final float GASTOPASSEIO = 0.75f;


    public CarroPasseio(int id){
        super(id, 4, IPVA.VALOR_BASE * IPVA.CTE_PASSEIO, (new Random()).nextFloat() * 2000);
        
    
        desenho[0]="  ______\n";
        desenho[1]=" /|_||_\\`.__\n";
        desenho[2]="(   _    _ _\\ \n";
        desenho[3]="=`-(_)--(_)-'\n\n"; 

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < this.GASTOPASSEIO){
            System.out.println("Combustivel insuficiente");
            valida = false;
        }
        if(!super.rodasCalibradas()){
            valida = false;
            System.out.println("Rodas descalibradas");
        }
        
        if(!this.isPagoIPVA()){
            System.out.println("Ipva nao pago");
            valida = false;
        }
        
        if(valida){
            super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 5);
        }
        
        return valida;
    }

    public String toString(){
        return "\nCarro de Passeio\n" + super.toString();
    }

    private void auxiliaDesenho(int dist){
        for(int i = 0; i < dist; i++){
            System.out.print(" ");
        }
    }

    public void desenhar(){
        int aux = super.getDistanciaPercorrida();

        System.out.println("ID: " + super.getID());

        auxiliaDesenho(aux); System.out.print(desenho[0]);
        auxiliaDesenho(aux); System.out.print(desenho[1]);
        auxiliaDesenho(aux); System.out.print(desenho[2]);
        auxiliaDesenho(aux); System.out.print(desenho[3]);
    }

}