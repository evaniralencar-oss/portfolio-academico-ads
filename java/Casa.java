package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento,
                double taxaJurosAnual, double areaConstruida,
                double areaTerreno) {

        super(valorImovel, prazoFinanciamento, taxaJurosAnual);

        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }
    @Override
    public double calcularPagamentoMensal() {
        return calcularPagamentoMensalBase() + 240.0;
    }
}