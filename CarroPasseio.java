import java.util.Random;

public class CarroPasseio extends VeiculoMotorizado implements IPVA {
    private String[] desenho = new String[4];
    private static final float GASTOPASSEIO = 0.75f;


    public CarroPasseio(int id){
        super(id, 4, this.calcularIPVA(), this.calcularValor());
        
    
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

    public float calcularIPVA(){
        return IPVA.VALOR_BASE * IPVA.CTE_PASSEIO;
    }

    public float calcularValor(){
        Random r = new Random();
        return r.nextFloat() * 2000;
    }

    public String toString(){
        return super.toString();
    }

}