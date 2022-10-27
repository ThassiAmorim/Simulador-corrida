import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo {
    
    private static final float GASTOMOTOCICLETA = 0.25f;
    private static final float GASTOPASSEIO = 0.75f;
    private static final float GASTOESPORTIVO = 2.3f;
    
    private float combustivel;
    private float valorIPVA;
    private boolean pagoIPVA;
    

    private float valor;
    
    public VeiculoMotorizado(int id, int quantidadeRodas, float valorIPVA, float valor){

        Random r = new Random();
        super(id, quantidadeRodas);
        this.combustivel = 2.5f;
        this.pagoIPVA = r.nextBoolean();
        this.valorIPVA = valorIPVA;
        this.valor = valor;
    };

    public float getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(float combustivel) {
        this.combustivel = combustivel;
    }

    public boolean isPagoIPVA() {
            return pagoIPVA;
        }
    

}
