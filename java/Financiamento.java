package modelo;

public  abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento ( double valordesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valordesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    public double getValorImovel() {
        return this.valorImovel;
    }
    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }
    public abstract double calcularPagamentoMensal();

    protected double calcularPagamentoMensalBase() {
        return (getValorImovel() / (getPrazoFinanciamento() * 12)) * (1 + (getTaxaJurosAnual() / 12));
    }

    public double calcularTotaldoPagamento(){
    return (this.calcularPagamentoMensal() * this.prazoFinanciamento * 12);
    }
    public void mostrarDadosNaTela(){
        System.out.println("O valor do imóvel é: R$ "+ this.valorImovel);
        System.out.println(" O valor do financiamento é de: R$ "+ calcularTotaldoPagamento());
    }
}




