package modelo;

public class Apartamento extends Financiamento {
    private int numeroVagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento,
                       double taxaJurosAnual, int numeroVagasGaragem,
                       int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.numeroVagasGaragem = numeroVagasGaragem;
        this.numeroAndar = numeroAndar;
    }
    @Override
    public double calcularPagamentoMensal() {
        double totalPagamento = getValorImovel()
                * (1 + (getTaxaJurosAnual() * getPrazoFinanciamento()));

        return totalPagamento / (getPrazoFinanciamento() * 12);
    }
}