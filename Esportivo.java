import java.util.Random;

public class Esportivo extends VeiculoMotorizado implements IPVA {
    private String[] desenho;


    public Esportivo(int id){
        super(id, 4, this.calcularIPVA(), this.calcularValor());
        
    
        desenho[0] = "           __\n";
        desenho[1] = "        ~( @\ \\n";
        desenho[2] = "       _]_[_/_>____\n";
        desenho[3] = "    /  __ \<>  |  __ \\n";
        desenho[4] = "    \_/__\_\___|_/__\_D\n";
        desenho[5] = "      (__)       (__)    \n";
        

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < super.GASTOESPORTIVO){
            System.out.println("Combustivel insuficiente");
            valida = false;
        }
        for(int i = 0; i < this.quantidadeRodas; i++){
            if(this.rodasVeiculo[i].getCalibragemPneu() == false){
                System.out.println("Rodas descalibradas");
                valida = false;
                break;
            }
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

    public float calcularIPVA(){
        return IPVA.VALOR_BASE * IPVA.CTE_ESPORTIVO;
    }

    public float calcularValor(){
        Random r = new Random();
        return r.nextFloat() * 10000;
    }

}
