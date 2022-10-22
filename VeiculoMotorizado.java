public abstract class VeiculoMotorizado extends Veiculo {
    
    private static final float GASTOMOTOCICLETA = 0.25f;
    private static final float GASTOPASSEIO = 0.75f;
    private static final float GASTOESPORTIVO = 2.3f;
    private float combustivel;
    private float valorIPVA;
    private float valor;
    
    public VeiculoMotorizado(int id, int quantidadeRodas, float valorIPVA, float valor){

        super(id, quantidadeRodas);
        this.combustivel = 2.5f;
        this.valorIPVA = valorIPVA;
        this.valor = valor;
    }

    

}
