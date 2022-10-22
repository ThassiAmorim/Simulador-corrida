public class Esportivo extends VeiculoMotorizado implements IPVA {
    private String[] desenho;


    public Esportivo(int id, int quantidadeRodas, float valorIPVA, float valor){
        super(id, quantidadeRodas, valorIPVA, valor);
        
        System.out.println("
                __\n
                ~( @\ \\n
            _____]_[_/_>____\n
            /  __ \<>  |  __ \\n
        =\_/__\_\___|_/__\_D\n
            (__)       (__)    \n
        ");

    }

    public boolean mover(){
        
        boolean valida = true;
        if(super.getCombustivel() < this.GASTOESPORTIVO){
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

}
