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
        //ifs

        super.setDistanciaPercorrida(super.getDistanciaPercorrida() + 10);
    }

    public float calcularIPVA(){
        return IPVA.VALOR_BASE * IPVA.CTE_ESPORTIVO;
    }

}
