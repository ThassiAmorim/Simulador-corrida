import java.util.Random;
import java.io.Serializable;

public class Esportivo extends VeiculoMotorizado implements IPVA, Serializable {
    private String[] desenho = new String[6]; 
    private static final float GASTOESPORTIVO = 2.3f;


    public Esportivo(int id){
        super(id, 4, IPVA.VALOR_BASE * IPVA.CTE_ESPORTIVO, (new Random()).nextFloat() * 10000);
        
    
        desenho[0] = "           __\n";
        desenho[1] = "        ~( @\\ \\   \n";
        desenho[2] = "       _]_[_/_>____\n";
        desenho[3] = "    /  __ \\<>  |  __ \\     \n";
        desenho[4] = "    \\_/__\\_\\___|_/__\\_D\n";
        desenho[5] = "      (__)       (__)    \n\n";
        

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < this.GASTOESPORTIVO){
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
            super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 10);
        }
        
        return valida;
    }

    public String toString(){
        return "\nCarro Esportivo\n" + super.toString();
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
        auxiliaDesenho(aux); System.out.print(desenho[4]);
        auxiliaDesenho(aux); System.out.print(desenho[5]);
    }

}
