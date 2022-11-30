import java.util.Random;
import java.io.Serializable;

public abstract class VeiculoMotorizado extends Veiculo implements Serializable {
    
    private float combustivel;
    private float valorIPVA;
    private boolean pagoIPVA;
    

    private float valor;
    
    public VeiculoMotorizado(int id, int quantidadeRodas, float valorIPVA, float valor){
        super(id, quantidadeRodas);
        Random r = new Random();
        this.combustivel = 2.5f;
        this.pagoIPVA = r.nextBoolean();
        this.valorIPVA = valorIPVA;
        this.valor = valor;
    }

    public float getCombustivel() {
        return combustivel;
    }

    public boolean isPagoIPVA() {
            return pagoIPVA;
        }

    public void abastecer(float f){
        this.combustivel += f;
    }

    public abstract void Movimentar()
    
    public String toString(){
        
        String s = super.toString() + "Valor do IPVA: " + this.valorIPVA + ".\nIPVA: ";
        if(this.pagoIPVA){
            s += "Pago.\n";
        }
        else{
            s += "Em debito.\n";
        }
        s += (super.rodasCalibradas() ? "Rodas calibradas" : "Rodas descalibradas\n");
        return s;
    }

}
